package GUI.Windows;

import GUI.Panes.orders.SupplierPanel;
import GUI.Panes.storage.IngredientPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class SupplierFrame extends JInternalFrame {
    private SupplierPanel supplierPanel;

    public SupplierFrame(String title, boolean resizable, boolean closable,
                         boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 300, 230);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        supplierPanel = new SupplierPanel();
        this.setVisible(true);
        this.add(supplierPanel);
    }
    public void setSave(ActionListener actionListener){
        supplierPanel.setSave(actionListener);
    }

    public Map getValues(){
        return supplierPanel.getValues();
    }

    public void setValues(Map values){
        supplierPanel.setTexts(values);
    }

    public void setId(int id){
        supplierPanel.setId(id);
    }

}
