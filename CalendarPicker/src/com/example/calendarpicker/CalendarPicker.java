package com.example.calendarpicker;

import java.util.Date;

import com.example.calendarpicker.client.calendarpicker.CalendarPickerServerRpc;
import com.example.calendarpicker.client.calendarpicker.CalendarPickerState;
import com.vaadin.shared.AbstractFieldState;

public class CalendarPicker extends com.vaadin.ui.AbstractField<Date> {

	private CalendarPickerServerRpc rpc = new CalendarPickerServerRpc() {

		@Override
		public void setDate(long date) {
			Date newDate = new Date(date);
			if(!isReadOnly() && !newDate.equals(getValue())) {
				setValue(newDate);
			}
			
		}
	};  

	public CalendarPicker() {
		registerRpc(rpc);
	}

	
	
	@Override
	protected CalendarPickerState getState() {
		return (CalendarPickerState) super.getState();
	}



	@Override
	public Class<? extends Date> getType() {
		return Date.class;
	}
	
}
