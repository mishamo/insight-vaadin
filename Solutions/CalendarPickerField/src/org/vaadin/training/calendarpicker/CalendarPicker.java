package org.vaadin.training.calendarpicker;

import java.util.Date;

import org.vaadin.training.calendarpicker.client.calendarpicker.CaledanrPickerServerRpc;
import org.vaadin.training.calendarpicker.client.calendarpicker.CalendarPickerState;

public class CalendarPicker extends com.vaadin.ui.AbstractField<Date> {

	private CaledanrPickerServerRpc rpc = new CaledanrPickerServerRpc() {

		@Override
		public void setDate(long newDateValue) {
			if (isReadOnly()) {
				return;
			}

			final Date oldValue = getValue();
			final Date newValue = new Date(newDateValue);

			if (!newValue.equals(oldValue)) {
				// The event is only sent if the switch state is changed
				setValue(newValue);
			}
		}

	};

    @Override
    protected void setInternalValue(Date newValue) {
        super.setInternalValue(newValue);
        if (newValue == null) {
            newValue = new Date();
        }
        getState().date = newValue.getTime();
    }

	public CalendarPicker() {
		registerRpc(rpc);
	}

	@Override
	public CalendarPickerState getState() {
		return (CalendarPickerState) super.getState();
	}

	@Override
	public Class<? extends Date> getType() {
		return Date.class;
	}
}
