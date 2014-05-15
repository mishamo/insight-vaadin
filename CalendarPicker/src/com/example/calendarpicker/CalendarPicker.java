package com.example.calendarpicker;

import com.example.calendarpicker.client.calendarpicker.CalendarPickerServerRpc;
import com.example.calendarpicker.client.calendarpicker.CalendarPickerState;

public class CalendarPicker extends com.vaadin.ui.AbstractComponent {

	private CalendarPickerServerRpc rpc = new CalendarPickerServerRpc() {

		@Override
		public void setDate(long date) {
			getState().date = date;
			
		}
	};  

	public CalendarPicker() {
		registerRpc(rpc);
	}

	@Override
	public CalendarPickerState getState() {
		return (CalendarPickerState) super.getState();
	}
	
}
