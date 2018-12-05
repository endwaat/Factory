package GUI.Windows;

import GUI.Panes.orders.OrderPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class OrderFrame extends JInternalFrame {
    private OrderPanel productTypePanel;

    public OrderFrame(String title, boolean resizable, boolean closable,
                      boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
            this.setBounds(10, 10, 400, 290);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        productTypePanel = new OrderPanel();
        this.setVisible(true);
        this.add(productTypePanel);
    }
    public void setSave(ActionListener actionListener){
        productTypePanel.setSave(actionListener);
    }

    public void setBrowseProductTypeButton(ActionListener actionListener){
        productTypePanel.setBrowseProductTypeButton(actionListener);
    }

    public void setBrowseProductButton(ActionListener actionListener){
        productTypePanel.setBrowseProductButton(actionListener);
    }

    public Map getValues(){
        return productTypePanel.getValues();
    }

    public void setId(int id){
        productTypePanel.setId(id);
    }

    public void setSelectedProductTypeItem(Map values){
        productTypePanel.setSelectedProductTypeItem(values);
    }

    public void setSelectedProductItem(Map values){
        productTypePanel.setSelectedProductItem(values);
    }

}
