package GUI.Windows;

import GUI.Panes.storage.IngredientListPanel;
import GUI.Panes.storage.IngredientTypeListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class IngredientListFrame extends JInternalFrame {
    private IngredientListPanel ingredientListPanel;

    public IngredientListFrame(String title, boolean resizable, boolean closable,
                               boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 500, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        ingredientListPanel = new IngredientListPanel();
        this.setVisible(true);
        this.add(ingredientListPanel);
    }

    public void setEdit(ActionListener actionListener){
        ingredientListPanel.getEditButton().addActionListener(actionListener);
    }
    public void setDelete(ActionListener actionListener){
        ingredientListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) ingredientListPanel.getIngredientTable().getModel().getValueAt(ingredientListPanel.getIngredientTable().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        ingredientListPanel.setTableValues(values);
    }

}
