package org.vaadin.training.data;

import lombok.Data;
import org.vaadin.training.authentication.Department;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

@Data
public class DepartmentDTO {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private Department department;
    private List<EmployeeProxy> employees;
    private float loadingState = 0;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void setEmployees(List<EmployeeProxy> employees) {
        List<EmployeeProxy> oldEmployees = this.employees;
        this.employees = employees;
        propertyChangeSupport.firePropertyChange("employees", oldEmployees, employees);
    }

    public void setDepartment(Department department) {
        Department oldDepartment = this.department;
        this.department = department;
        propertyChangeSupport.firePropertyChange("department", oldDepartment, department);
    }

    public void setLoadingState(float state) {
        float oldLoadingState = this.loadingState;
        this.loadingState = state;
        propertyChangeSupport.firePropertyChange("loadingState", oldLoadingState, state);
    }

}
