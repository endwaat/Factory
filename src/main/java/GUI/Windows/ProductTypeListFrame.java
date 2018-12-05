package GUI.Windows;

import GUI.Panes.product.ProductTypeListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ProductTypeListFrame extends JInternalFrame {
    private ProductTypeListPanel productTypeListPanel;

    public ProductTypeListFrame(String title, boolean resizable, boolean closable,
                                boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 500, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        productTypeListPanel = new ProductTypeListPanel();
        this.setVisible(true);
        this.add(productTypeListPanel);
    }

    public void setEdit(ActionListener actionListener){
        productTypeListPanel.getEditButton().addActionListener(actionListener);
    }
    public void setDelete(ActionListener actionListener){
        productTypeListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) productTypeListPanel.getTable1().getModel().getValueAt(productTypeListPanel.getTable1().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        productTypeListPanel.setTableValues(values);
    }

}
