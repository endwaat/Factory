package GUI.Windows;

import GUI.Panes.product.ProductListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ProductListFrame extends JInternalFrame {
    private ProductListPanel productListPanel;

    public ProductListFrame(String title, boolean resizable, boolean closable,
                            boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 500, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        productListPanel = new ProductListPanel();
        this.setVisible(true);
        this.add(productListPanel);
    }

    public void setShow(ActionListener actionListener){
        productListPanel.getShowButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) productListPanel.getTable1().getModel().getValueAt(productListPanel.getTable1().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        productListPanel.setTableValues(values);
    }

}
