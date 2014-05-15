package com.example.stepper.client.stepper;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;

public class StepperWidget extends HorizontalPanel implements HasValue<Integer> {

	private final IntegerBox integerBox = new IntegerBox();
	private final Button upButton = new Button("^");
	private final Button downButton = new Button("V");

	public StepperWidget() {
		add(integerBox);
		add(upButton);
		add(downButton);
		
		initialiseListeners();
	}

	private void initialiseListeners() {
		initialiseBoxListener();
		initialiseUpButtonListener();
		initialiseDownButtonListener();
	}

	private void initialiseDownButtonListener() {
		downButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				setValue(getValue() - 1);
			}
		});
	}

	private void initialiseUpButtonListener() {
		upButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				setValue(getValue() + 1);
			}
		});
	}

	private void initialiseBoxListener() {
		integerBox.addKeyDownHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {
				int keyCode = event.getNativeKeyCode();
				if(!isValid(keyCode)) {
					event.preventDefault();
				}
			}
		});
		
		integerBox.addMouseWheelHandler(new MouseWheelHandler() {
			
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				setValue(getValue() - event.getDeltaY());
			}
		});
	}

	private boolean isValid(int keyCode) {
		return (keyCode >= (int)'0' && keyCode <= (int)'9') || keyCode == KeyCodes.KEY_DELETE ||
					keyCode == KeyCodes.KEY_BACKSPACE || keyCode == KeyCodes.KEY_LEFT ||
					keyCode == KeyCodes.KEY_RIGHT;
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Integer> handler) {
		return integerBox.addValueChangeHandler(handler);
	}

	@Override
	public Integer getValue() {
		return integerBox.getValue();
	}

	@Override
	public void setValue(Integer value) {
		integerBox.setValue(value);
	}

	@Override
	public void setValue(Integer value, boolean fireEvents) {
		integerBox.setValue(value, fireEvents);
	}

}