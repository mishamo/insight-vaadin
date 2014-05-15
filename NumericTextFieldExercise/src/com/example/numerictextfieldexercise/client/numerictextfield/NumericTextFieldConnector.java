package com.example.numerictextfieldexercise.client.numerictextfield;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.thirdparty.guava.common.base.CharMatcher;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.VTextField;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;
import com.example.numerictextfieldexercise.NumericTextField;
import com.google.gwt.user.client.ui.Label;

@Connect(NumericTextField.class)
public class NumericTextFieldConnector extends TextFieldConnector {

	
	public NumericTextFieldConnector() {

	}

	@Override
	protected Widget createWidget() {
		VTextField widget = GWT.create(VTextField.class);
		widget.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				int keyCode = event.getCharCode();
				if(!isValid(keyCode)) {
					getWidget().cancelKey();
				}
			}
		});
		return widget;
	}

	protected boolean isValid(int keyCode) {
		return keyCode >= '0' || keyCode <= '9' || keyCode == KeyCodes.KEY_DELETE ||
				keyCode == KeyCodes.KEY_BACKSPACE || keyCode == KeyCodes.KEY_LEFT ||
				keyCode == KeyCodes.KEY_RIGHT;
	}

	@Override
	public VTextField getWidget() {
		return super.getWidget();
	}

}

