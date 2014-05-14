package org.vaadin.training.calendarpicker.client.calendarpicker;

import com.vaadin.shared.communication.ServerRpc;

public interface CalendarPickerServerRpc extends ServerRpc {

    public void setDate(long newValue);

}
