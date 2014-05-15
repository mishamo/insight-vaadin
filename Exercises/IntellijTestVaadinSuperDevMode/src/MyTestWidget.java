import client.MyTestWidgetClientRpc;
import client.MyTestWidgetServerRpc;
import client.MyTestWidgetState;
import com.vaadin.shared.AbstractComponentState;
import com.vaadin.ui.AbstractComponent;


public class MyTestWidget extends AbstractComponent {
    public MyTestWidget() {
        registerRpc(new MyTestWidgetServerRpc() {
            private MyTestWidgetClientRpc getClientRpc() {
                return getRpcProxy(MyTestWidgetClientRpc.class);
            }
        });
    }

    @Override
    protected MyTestWidgetState getState() {
        return (MyTestWidgetState) super.getState();
    }
}
