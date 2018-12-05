package GUI.Windows;

import GUI.Panes.orders.OrderListPanel;
import GUI.Panes.product.ProductTypeListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class OrderListFrame extends JInternalFrame {
    private OrderListPanel orderListPanel;

    public OrderListFrame(String title, boolean resizable, boolean closable,
                          boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 500, 275);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        orderListPanel = new OrderListPanel();
        this.setVisible(true);
        this.add(orderListPanel);
    }

    public void setEdit(ActionListener actionListener){
        orderListPanel.getEditButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) orderListPanel.getTable1().getModel().getValueAt(orderListPanel.getTable1().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        orderListPanel.setTableValues(values);
    }

}
