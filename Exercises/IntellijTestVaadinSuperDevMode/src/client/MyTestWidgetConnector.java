package client;

import.MyTestWidget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;


@Connect(MyTestWidget.class)
public class MyTestWidgetConnector extends AbstractComponentConnector {
    private final MyTestWidgetServerRpc serverRpc = RpcProxy.create(MyTestWidgetServerRpc.class, this);

    public MyTestWidgetConnector() {
        registerRpc(MyTestWidgetClientRpc.class, new MyTestWidgetClientRpc() {
        });
    }

    @Override
    protected Widget createWidget() {
        return GWT.create(MyTestWidgetWidget.class);
    }

    @Override
    public MyTestWidgetWidget getWidget() {
        return (MyTestWidgetWidget) super.getWidget();
    }

    @Override
    public MyTestWidgetState getState() {
        return (MyTestWidgetState) super.getState();
    }
}
