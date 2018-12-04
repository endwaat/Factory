package GUI.Windows;

import GUI.Panes.product.ProductTypePanel;
import GUI.Panes.workers.WorkerPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ProductTypeFrame extends JInternalFrame {
    private ProductTypePanel productTypePanel;

    public ProductTypeFrame(String title, boolean resizable, boolean closable,
                            boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
            this.setBounds(10, 10, 345, 320);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        productTypePanel = new ProductTypePanel();
        this.setVisible(true);
        this.add(productTypePanel);
    }
    public void setSave(ActionListener actionListener){
        productTypePanel.setSave(actionListener);
    }

    public void setBrowseIngredientButton(ActionListener actionListener){
        productTypePanel.setBrowseIngredientButton(actionListener);
    }

    public void setBrowseMachineButton(ActionListener actionListener){
        productTypePanel.setBrowseMachineButton(actionListener);
    }

    public Map getValues(){
        return productTypePanel.getValues();
    }

    public void setValues(Map values){
        productTypePanel.setTexts(values);
    }

    public void setId(int id){
        productTypePanel.setId(id);
    }

    public void setSelectedIngredientTypeItem(Map values){
        productTypePanel.setSelectedIngredientTypeItem(values);
    }

    public void setSelectedMachineItem(Map values){
        productTypePanel.setSelectedMachineItem(values);
    }

}
