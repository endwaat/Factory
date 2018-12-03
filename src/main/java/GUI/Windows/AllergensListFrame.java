package GUI.Windows;

import GUI.Panes.allergens.AllergensListPanel;
import GUI.Panes.allergens.AllergensPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllergensListFrame extends JInternalFrame {
    private AllergensListPanel allergensListPanel;

    public AllergensListFrame(String title, boolean resizable, boolean closable,
                              boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 300, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        allergensListPanel = new AllergensListPanel();
        this.setVisible(true);
        this.add(allergensListPanel);
    }

    public void setEdit(ActionListener actionListener){
        allergensListPanel.getEditButton().addActionListener(actionListener);
    }
    public void setDelete(ActionListener actionListener){
        allergensListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) allergensListPanel.getAllergensTable().getModel().getValueAt(allergensListPanel.getAllergensTable().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        allergensListPanel.setTableValues(values);
    }

}
