package GUI.Windows;

import GUI.Panes.storage.IngredientTypePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class IngredientTypeFrame extends JInternalFrame {
    private IngredientTypePanel ingredientTypePanel;

    public IngredientTypeFrame(String title, boolean resizable, boolean closable,
                               boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 250, 130);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        ingredientTypePanel = new IngredientTypePanel();
        this.setVisible(true);
        this.add(ingredientTypePanel);
    }
    public void setSave(ActionListener actionListener){
        ingredientTypePanel.setSave(actionListener);
    }

    public Map getValues(){
        return ingredientTypePanel.getValues();
    }

    public void setValues(Map values){
        ingredientTypePanel.setTexts(values);
    }

    public void setId(int id){
        ingredientTypePanel.setId(id);
    }

}
