package org.vaadin.training.views.department;

import com.google.gwt.thirdparty.guava.common.base.Function;
import com.google.gwt.thirdparty.guava.common.collect.Lists;
import org.vaadin.training.authentication.AuthenticationService;
import org.vaadin.training.backend.PersonService;
import org.vaadin.training.backend.ProgressingFuture;
import org.vaadin.training.data.DepartmentDTO;
import org.vaadin.training.data.EmployeeProxy;
import org.vaadin.training.data.Person;

import javax.annotation.Nullable;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DepartmentPresenter {

    private DepartmentView departmentView;
    private PersonService service = new PersonService();
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    private final DepartmentDTO departmentDTO = new DepartmentDTO();

    public DepartmentPresenter(DepartmentView departmentView) {
        this.departmentView = departmentView;
    }

    public void update(String parameters) {
        pool.submit(new UIUpdateRunnable(parameters));
        departmentDTO.setLoadingState(0);
    }

    private void parseParameters(String parameters, List<EmployeeProxy> employees) {
        if(!parameters.isEmpty()) {
            int id = Integer.parseInt(parameters);
            for (EmployeeProxy employee : employees) {
                if(employee.getId() == id) {
                    departmentView.selectEmployee(employee);
                    break;
                }
            }

        }
    }

    public void personSelected(EmployeeProxy person) {
    	if(person != null) {
    		departmentView.showEmployeeInForm(person);
            departmentView.setParameters(String.valueOf(person.getId()));
        }
        departmentView.enableEmployeeForm(person != null);
    }

    public void onSaveClick() {
        EmployeeProxy person = departmentView.commitChanges();
        service.save(person.getPerson());
        departmentView.selectEmployee(null);
    }

    public void onCancelClick() {
        departmentView.discardChanges();
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        departmentDTO.addPropertyChangeListener(propertyChangeListener);
    }

    private class UIUpdateRunnable implements Runnable {
        ProgressingFuture<List<Person>> employeesAsync;
        private final String parameters;

        public UIUpdateRunnable(String parameters) {
            this.parameters = parameters;
        }

        @Override
        public void run() {
            employeesAsync = service.getEmployeesAsync();
            while(!employeesAsync.isDone()){
                departmentDTO.setLoadingState(employeesAsync.getProgress() / 100f);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            populateData();
        }

        private void populateData() {
            try {
                List<Person> employees = employeesAsync.get();
                List<EmployeeProxy> proxies = Lists.transform(employees, convertToProxy());

                departmentDTO.setDepartment(AuthenticationService.getLoggedInUser().getDepartment());
                departmentDTO.setEmployees(proxies);
                departmentDTO.setLoadingState(1);
                parseParameters(parameters, proxies);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Function<Person, EmployeeProxy> convertToProxy() {
        return new Function<Person, EmployeeProxy>() {
            @Override
            public EmployeeProxy apply(@Nullable Person person) {
                return new EmployeeProxy(person);
            }
        };
    }
}
