package com.example.stepper;

import com.example.stepper.client.stepper.StepperState;
import com.vaadin.ui.AbstractField;

public class Stepper extends AbstractField<Integer> {

	@Override
	public StepperState getState() {
		return (StepperState) super.getState();
	}

	@Override
	public Class<? extends Integer> getType() {
		return Integer.class;
	}
}
