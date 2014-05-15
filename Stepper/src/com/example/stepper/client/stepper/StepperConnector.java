package com.example.stepper.client.stepper;

import com.example.stepper.Stepper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(Stepper.class)
public class StepperConnector extends AbstractFieldConnector {

	@Override
	protected Widget createWidget() {
		return GWT.create(StepperWidget.class);
	}

	@Override
	public StepperWidget getWidget() {
		return (StepperWidget) super.getWidget();
	}

	@Override
	public StepperState getState() {
		return (StepperState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		final Integer value= getState().value;
		getWidget().setValue(value);
	}

}

