package org.vaadin.training.views.department;

import org.vaadin.training.authentication.AuthenticationService;
import org.vaadin.training.backend.PersonService;
import org.vaadin.training.backend.ProgressingFuture;
import org.vaadin.training.data.Person;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DepartmentPresenter {

    private DepartmentView departmentView;
    private PersonService service = new PersonService();
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    public DepartmentPresenter(DepartmentView departmentView) {
        this.departmentView = departmentView;
    }

    public void update(String parameters) {
        departmentView.setEmployees(Collections.<Person>emptyList());
        pool.submit(new UIUpdateRunnable(parameters));
        departmentView.setDepartment(AuthenticationService.getLoggedInUser()
                .getDepartment());
        departmentView.setDataLoadingState(0);
    }

    private void parseParameters(String parameters, List<Person> employees) {
        if(!parameters.isEmpty()) {
            int id = Integer.parseInt(parameters);
            for (Person employee : employees) {
                if(employee.getId() == id) {
                    departmentView.selectEmployee(employee);
                    break;
                }
            }

        }
    }

    public void personSelected(Person person) {
    	if(person != null) {
    		departmentView.showEmployeeInForm(person);
            departmentView.setParameters(String.valueOf(person.getId()));
        }
        departmentView.enableEmployeeForm(person != null);
    }

    public void onSaveClick() {
        Person person = departmentView.commitChanges();
        service.save(person);
        departmentView.selectEmployee(null);
    }

    public void onCancelClick() {
        departmentView.discardChanges();
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
                departmentView.setDataLoadingState(employeesAsync.getProgress()/100f);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                List<Person> employees = employeesAsync.get();
                departmentView.setEmployees(employees);
                departmentView.setDataLoadingState(1);
                parseParameters(parameters, employees);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
