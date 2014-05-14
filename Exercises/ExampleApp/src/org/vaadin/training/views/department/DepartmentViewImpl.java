package org.vaadin.training.views.department;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import org.vaadin.training.authentication.Department;
import org.vaadin.training.data.EmployeeProxy;
import org.vaadin.training.utils.UIAccessWrapper;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;

public class DepartmentViewImpl extends VerticalSplitPanel implements
		ValueChangeListener, EmployeeEditorHandler, View, DepartmentView {

	private static final long serialVersionUID = 1L;
	private Table table;

	private EmployeeEditor employeeEditor = new EmployeeEditor(this);
	private DepartmentInfo departmentInfo;
	private BeanItemContainer<EmployeeProxy> personContainer;
    private final DepartmentPresenter presenter;

	public DepartmentViewImpl() {
        presenter = new DepartmentPresenter(this);
        setupDataListener();
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
		createContainer();
		table = new Table();
		table.setContainerDataSource(personContainer);
		table.setSizeFull();
		table.setSelectable(true);
		table.setImmediate(true);
		table.setVisibleColumns(new String[] { "firstName", "lastName", "email" });
		table.addValueChangeListener(this);
	}

	private void createContainer() {
		personContainer = new BeanItemContainer<EmployeeProxy>(EmployeeProxy.class);
	}

	/*
	 * (non-Javadoc) Example implementation for table value change listener
	 */
	@Override
	public void valueChange(ValueChangeEvent event) {
        presenter.personSelected((EmployeeProxy)table.getValue());
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

    private void setupDataListener() {
        presenter.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(final PropertyChangeEvent event) {
                UIAccessWrapper.callOnUI(new Runnable() {
                    @Override
                    public void run() {
                        onUpdateEvent(event);
                    }
                }, getUI(), DepartmentViewImpl.this);

            }
        });
    }

    private void onUpdateEvent(PropertyChangeEvent event) {
        String propertyName = event.getPropertyName();
        if (propertyName.equals("employees")) {
            personContainer.removeAllItems();
            personContainer.addAll((Collection<EmployeeProxy>) event.getNewValue());
        } else if (propertyName.equals("department")) {
            departmentInfo.setDepartment((Department) event.getNewValue());
        } else if (propertyName.equals("loadingState")) {
            departmentInfo.setLoadingState((Float) event.getNewValue());
        }
    }

    @Override
    public void showEmployeeInForm(EmployeeProxy employee) {
        employeeEditor.setPerson(personContainer.getItem(employee));
    }

    @Override
    public EmployeeProxy commitChanges() {
        return employeeEditor.commit();
    }

    @Override
    public void discardChanges() {
        employeeEditor.discard();
    }

    @Override
    public void selectEmployee(EmployeeProxy employee) {
        table.setValue(employee);
    }

    @Override
    public void enableEmployeeForm(boolean enable) {
        employeeEditor.setEnabled(enable);
    }

    @Override
    public void setParameters(String parameters) {
        Page.getCurrent().setUriFragment("!departmentView/" + parameters, false);
    }
}
