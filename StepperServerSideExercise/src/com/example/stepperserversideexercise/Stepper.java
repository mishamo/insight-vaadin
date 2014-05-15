package com.example.stepperserversideexercise;

import org.vaadin.training.numerictextfield.NumericTextField;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.HorizontalLayout;

public class Stepper extends CustomField<Integer>{

	@Override
	protected Component initContent() {
		HorizontalLayout layout = new HorizontalLayout();
		
		final NumericTextField numericField = new NumericTextField();
		numericField.setValue("1");
		
		Button upButton = new Button("^");
		upButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				numericField.setValue(String.valueOf(Integer.parseInt(numericField.getValue()) + 1));				
			}
		});
		
		Button downButton = new Button("V");
		downButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				numericField.setValue(String.valueOf(Integer.parseInt(numericField.getValue()) - 1));				
			}
		});
		
		layout.addComponent(numericField);
		layout.addComponent(upButton);
		layout.addComponent(downButton);
		
		return layout;
	}

	@Override
	public Class<? extends Integer> getType() {
		return Integer.class;
	}

}
