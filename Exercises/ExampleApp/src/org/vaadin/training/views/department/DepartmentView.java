package org.vaadin.training.views.department;

import org.vaadin.training.data.EmployeeProxy;

public interface DepartmentView {
    public void showEmployeeInForm(EmployeeProxy employee);
    public EmployeeProxy commitChanges();
    public void discardChanges();
    public void selectEmployee(EmployeeProxy employee);
    public void enableEmployeeForm(boolean enable);
    void setParameters(String parameters);
}
