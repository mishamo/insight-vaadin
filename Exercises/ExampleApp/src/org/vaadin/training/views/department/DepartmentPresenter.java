package org.vaadin.training.views.department;

import org.vaadin.training.authentication.AuthenticationService;
import org.vaadin.training.backend.PersonService;
import org.vaadin.training.data.Person;

import java.util.List;

public class DepartmentPresenter {

    private DepartmentView departmentView;
    private PersonService service = new PersonService();

    public DepartmentPresenter(DepartmentView departmentView) {
        this.departmentView = departmentView;
    }

    public void update(String parameters) {
        List<Person> employees = service.getEmployees();
        departmentView.setEmployees(employees);
        departmentView.setDepartment(AuthenticationService.getLoggedInUser()
                .getDepartment());

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
}
