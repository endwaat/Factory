package GUI.Windows;

import GUI.Panes.orders.SupplierListPanel;
import GUI.Panes.storage.IngredientListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class SupplierListFrame extends JInternalFrame {
    private SupplierListPanel supplierListPanel;

    public SupplierListFrame(String title, boolean resizable, boolean closable,
                             boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 500, 275);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        supplierListPanel = new SupplierListPanel();
        this.setVisible(true);
        this.add(supplierListPanel);
    }

    public void setEdit(ActionListener actionListener){
        supplierListPanel.getEditButton().addActionListener(actionListener);
    }
    public void setDelete(ActionListener actionListener){
        supplierListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) supplierListPanel.getTable1().getModel().getValueAt(supplierListPanel.getTable1().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        supplierListPanel.setTableValues(values);
    }

}
