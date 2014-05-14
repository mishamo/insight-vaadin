package org.vaadin.training.views.department;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import org.vaadin.training.authentication.Department;
import org.vaadin.training.data.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DepartmentViewImpl extends VerticalSplitPanel implements
		ValueChangeListener, EmployeeEditorHandler, View, DepartmentView {

	private static final long serialVersionUID = 1L;
	private Table table;

	private EmployeeEditor employeeEditor = new EmployeeEditor(this);
	private DepartmentInfo departmentInfo;
	private BeanItemContainer<Person> personContainer;
    private final DepartmentPresenter presenter;

	public DepartmentViewImpl() {
        presenter = new DepartmentPresenter(this);
		setSizeFull();

		VerticalLayout departmentInfoAndEmployeeTableLayout = new VerticalLayout();
		departmentInfoAndEmployeeTableLayout.setSizeFull();
		departmentInfoAndEmployeeTableLayout.setSpacing(true);

		departmentInfo = new DepartmentInfo();
		departmentInfoAndEmployeeTableLayout.addComponent(departmentInfo);

		createEmployeeTable();
		departmentInfoAndEmployeeTableLayout.addComponent(table);
		departmentInfoAndEmployeeTableLayout.setExpandRatio(table, 1f);
		addComponent(departmentInfoAndEmployeeTableLayout);
		addComponent(employeeEditor);
	}

	private void createEmployeeTable() {
		createContainer(new ArrayList<Person>());
		table = new Table();
		table.setContainerDataSource(personContainer);
		table.setSizeFull();
		table.setSelectable(true);
		table.setImmediate(true);
		table.setVisibleColumns(new String[] { "firstName", "lastName", "email" });
		table.addValueChangeListener(this);
	}

	private void createContainer(Collection<Person> employees) {
		personContainer = new BeanItemContainer<Person>(Person.class);
		personContainer.addAll(employees);
	}

	/*
	 * (non-Javadoc) Example implementation for table value change listener
	 */
	@Override
	public void valueChange(ValueChangeEvent event) {
        presenter.personSelected((Person)table.getValue());
	}

	@Override
	public void onSaveClick() {
        presenter.onSaveClick();
	}

	@Override
	public void onCancelClick() {
        presenter.onCancelClick();
	}

	@Override
	public void enter(ViewChangeEvent event) {
        presenter.update(event.getParameters());
	}

    @Override
    public void setEmployees(List<Person> employees) {
        personContainer.removeAllItems();
        personContainer.addAll(employees);
    }

    @Override
    public void showEmployeeInForm(Person employee) {
        employeeEditor.setPerson(personContainer.getItem(employee));
    }

    @Override
    public Person commitChanges() {
        return employeeEditor.commit();
    }

    @Override
    public void discardChanges() {
        employeeEditor.discard();
    }

    @Override
    public void selectEmployee(Person employee) {
        table.setValue(employee);
    }

    @Override
    public void setDepartment(Department department) {
        departmentInfo.setDepartment(department);
    }

    @Override
    public void enableEmployeeForm(boolean enable) {
        employeeEditor.setEnabled(enable);
    }
}