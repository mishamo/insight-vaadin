package com.example.calendarpicker.client.calendarpicker;

import java.util.Date;

import com.example.calendarpicker.CalendarPicker;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(CalendarPicker.class)
public class CalendarPickerConnector extends AbstractFieldConnector {

	CalendarPickerServerRpc rpc = RpcProxy
			.create(CalendarPickerServerRpc.class, this);
	
	public CalendarPickerConnector() {

		getWidget().addValueChangeHandler(new ValueChangeHandler<Date>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				rpc.setDate(event.getValue().getTime());
			}
		});

	}

	@Override
	protected Widget createWidget() {
		return GWT.create(CalendarPickerWidget.class);
	}

	@Override
	public CalendarPickerWidget getWidget() {
		return (CalendarPickerWidget) super.getWidget();
	}

	@Override
	public CalendarPickerState getState() {
		return (CalendarPickerState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		long date = getState().date;
		getWidget().setValue(new Date(date));
	}

}

