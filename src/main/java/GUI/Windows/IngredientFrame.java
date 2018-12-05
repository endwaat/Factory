package GUI.Windows;

import GUI.Panes.storage.IngredientPanel;
import GUI.Panes.storage.IngredientTypePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class IngredientFrame extends JInternalFrame {
    private IngredientPanel ingredientPanel;

    public IngredientFrame(String title, boolean resizable, boolean closable,
                           boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 410, 295);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        ingredientPanel = new IngredientPanel();
        this.setVisible(true);
        this.add(ingredientPanel);
    }
    public void setSave(ActionListener actionListener){
        ingredientPanel.setSave(actionListener);
    }

    public Map getValues(){
        return ingredientPanel.getValues();
    }

    public void setValues(Map values){
        ingredientPanel.setTexts(values);
    }

    public void setId(int id){
        ingredientPanel.setId(id);
    }

}
