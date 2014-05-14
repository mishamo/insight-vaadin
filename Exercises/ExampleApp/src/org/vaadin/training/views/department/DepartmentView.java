package org.vaadin.training.views.department;

import org.vaadin.training.authentication.Department;
import org.vaadin.training.data.Person;

import java.util.List;

public interface DepartmentView {
    public void setEmployees(List<Person> employees);
    public void showEmployeeInForm(Person employee);
    public Person commitChanges();
    public void discardChanges();
    public void selectEmployee(Person employee);
    public void setDepartment(Department department);
    public void enableEmployeeForm(boolean enable);
    void setParameters(String parameters);
    public void setDataLoadingState(float percentageProgress);
}
