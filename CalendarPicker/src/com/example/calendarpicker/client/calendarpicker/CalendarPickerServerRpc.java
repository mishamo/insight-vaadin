package com.example.calendarpicker.client.calendarpicker;

import com.vaadin.shared.communication.ServerRpc;

public interface CalendarPickerServerRpc extends ServerRpc {

	void setDate(long date);

}
