package org.vaadin.training;

import com.vaadin.annotations.Push;
import org.vaadin.training.views.auditing.AuditingViewImpl;
import org.vaadin.training.views.dashboard.DashboardViewImpl;
import org.vaadin.training.views.department.DepartmentViewImpl;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Push
public class ExampleApp extends UI implements ClickListener {
	private static final long serialVersionUID = 1L;
	private Navigator navigator;
	private Button dashboard;
	private Button department;
	private Button auditing;

	@Override
	public void init(VaadinRequest request) {

		Label label = new Label("Hello Vaadin user");
		setContent(label);

		HorizontalLayout rootLayout = new HorizontalLayout();
		rootLayout.setSizeFull();

		createNavigationBar(rootLayout);

		Panel panel = new Panel();
		panel.setSizeFull();

		navigator = createNavigator(panel);
		registerViews();
		navigateToDefaultView();

		rootLayout.addComponent(panel);
		rootLayout.setExpandRatio(panel, 1);

		setContent(rootLayout);

	}
	
	private void navigateToDefaultView() {
		// If no URI fragment is defined, then navigate to default view
		if ("".equals(navigator.getState())) {
			navigator.navigateTo("departmentView");
		}
	}

	private void registerViews() {
		navigator.addView("auditingView", AuditingViewImpl.class);
		navigator.addView("dashboardView", DashboardViewImpl.class);
		navigator.addView("departmentView", DepartmentViewImpl.class);
	}

	private Navigator createNavigator(Panel panel) {
		return new Navigator(this, panel);
	}

	private void createNavigationBar(HorizontalLayout rootLayout) {
		VerticalLayout sideNavigation = new VerticalLayout();
		sideNavigation.setWidth("150px");
		sideNavigation.setMargin(true);
		sideNavigation.setSpacing(true);

		dashboard = new Button("Dashboard", this);
		department = new Button("Department", this);
		auditing = new Button("Auditing", this);
		sideNavigation.addComponent(dashboard);
		sideNavigation.addComponent(department);
		sideNavigation.addComponent(auditing);

		rootLayout.addComponent(sideNavigation);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (dashboard.equals(event.getButton())) {
			navigator.navigateTo("dashboardView");
		} else if (department.equals(event.getButton())) {
			navigator.navigateTo("departmentView");
		} else if (auditing.equals(event.getButton())) {
			navigator.navigateTo("auditingView");
		}
	}

}
