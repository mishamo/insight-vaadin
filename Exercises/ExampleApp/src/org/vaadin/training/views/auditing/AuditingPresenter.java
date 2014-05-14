package org.vaadin.training.views.auditing;

import org.vaadin.training.backend.AuditLogService;
import org.vaadin.training.backend.AuditLogService.AuditLogListener;

public class AuditingPresenter {
	private AuditingView view;
	
	public AuditingPresenter() {
        AuditLogService.addAuditLogListener(new AuditLogListener() {
            @Override
            public void auditLogAdded(String message) {
                view.addAuditLog(message);
            }
        });
	}

	public void setView(AuditingView auditingView) {
		view = auditingView;
		fetchInitialData();
	}

	private void fetchInitialData() {
		for (String message : AuditLogService.getAuditLogMessages()) {
			view.addAuditLog(message);
		}
	}

}
