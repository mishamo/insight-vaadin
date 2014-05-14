package org.vaadin.training.views.auditing;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import org.vaadin.training.utils.UIAccessWrapper;

public class AuditingViewImpl extends VerticalLayout implements AuditingView, View {

	private final AuditingPresenter presenter;

	public AuditingViewImpl() {
		Label header = new Label("Audit Log Messages");
		header.setStyleName(Reindeer.LABEL_H1);
		addComponent(header);
		setMargin(true);

		presenter = new AuditingPresenter();
		presenter.setView(this);
	}

	@Override
	public void addAuditLog(final String message) {
        UIAccessWrapper.callOnUI(new Runnable() {
            @Override
            public void run() {
                addComponent(new Label(message));
            }
        }, getUI(), this);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
