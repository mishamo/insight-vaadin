package org.vaadin.training.utils;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.ui.UI;

public class UIAccessWrapper {
    public static void callOnUI(Runnable runnable, UI ui, AbstractClientConnector connector) {
        if(!connector.isAttached() || ui.getSession().hasLock()) {
            runnable.run();
        }
        else {
            ui.access(runnable);
        }
    }
}
