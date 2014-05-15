package org.vaadin.training.optimization;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class OptimizationUI extends UI {

	@Override
	public void init(VaadinRequest request) {
		CssLayout layout = new CssLayout();
        layout.setStyleName("vertical");

		for (int i = 0; i < 100; i++) {
			CssLayout hl = new CssLayout();
            hl.setStyleName("details");
            layout.addComponent(hl);
            hl.setCaption("John Doe");
			hl.setWidth("100%");

            Label details = new Label("Phone: 123 4567<br/>Fax: 123 4568<br/>Email: example@example.com");
            details.setContentMode(ContentMode.HTML);
            details.setWidth(50, Unit.PERCENTAGE);
			hl.addComponent(details);

            Label addressLabel = new Label("Random street 1<br/>City of Lorem Ipsum<br/>012345");
            addressLabel.setContentMode(ContentMode.HTML);
            addressLabel.setWidth(50, Unit.PERCENTAGE);

			hl.addComponent(addressLabel);

		}

		setContent(layout);
	}
}

