package GUI.Windows;

import GUI.Panes.allergens.AllergensPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AllergensFrame extends JInternalFrame {
    private AllergensPanel allergensPanel;

    public AllergensFrame(String title, boolean resizable, boolean closable,
                        boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 250, 100);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        allergensPanel = new AllergensPanel();
        this.setVisible(true);
        this.add(allergensPanel);
    }

    public void setSave(ActionListener actionListener){
        allergensPanel.setSave(actionListener);
    }

    public HashMap getValues(){
        return allergensPanel.getValues();
    }

    public void setValues(Map values){
        allergensPanel.setTexts(values);
    }

    public void setId(int id){
        allergensPanel.setId(id);
    }

}
