package GUI.Windows;

import GUI.Panes.product.ProductPanel;
import GUI.Panes.product.ProductTypePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class ProductFrame extends JInternalFrame {
    private ProductPanel productPanel;

    public ProductFrame(String title, boolean resizable, boolean closable,
                        boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
            this.setBounds(10, 10, 345, 320);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        productPanel = new ProductPanel();
        this.setVisible(true);
        this.add(productPanel);
    }
    public void setSave(ActionListener actionListener){
        productPanel.setSave(actionListener);
    }

    public void setBrowseIngredientButton(ActionListener actionListener){
        productPanel.setBrowseIngredientButton(actionListener);
    }

    public Map getValues(){
        return productPanel.getValues();
    }

    public boolean beforeSave(){
        return productPanel.beforeSave();
    }

    public void setId(int id){
        productPanel.setId(id);
    }

    public void setSelectedIngredientItem(Map values){
        productPanel.setSelectedIngredientItem(values);
    }

}
