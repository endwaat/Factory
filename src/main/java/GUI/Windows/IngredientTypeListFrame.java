package GUI.Windows;

import GUI.Panes.machines.MachineListPanel;
import GUI.Panes.storage.IngredientTypeListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class IngredientTypeListFrame extends JInternalFrame {
    private IngredientTypeListPanel ingredientTypeListPanel;

    public IngredientTypeListFrame(String title, boolean resizable, boolean closable,
                                   boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 300, 325);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        ingredientTypeListPanel = new IngredientTypeListPanel();
        this.setVisible(true);
        this.add(ingredientTypeListPanel);
    }

    public void setEdit(ActionListener actionListener){
        ingredientTypeListPanel.getEditButton().addActionListener(actionListener);
    }
    public void setDelete(ActionListener actionListener){
        ingredientTypeListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) ingredientTypeListPanel.getIngredienTypeTable().getModel().getValueAt(ingredientTypeListPanel.getIngredienTypeTable().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        ingredientTypeListPanel.setTableValues(values);
    }

}
