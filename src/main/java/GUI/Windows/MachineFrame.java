package GUI.Windows;

import GUI.Panes.allergens.AllergensPanel;
import GUI.Panes.machines.MachinePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MachineFrame extends JInternalFrame {
    private MachinePanel machinePanel;

    public MachineFrame(String title, boolean resizable, boolean closable,
                        boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 250, 100);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        machinePanel = new MachinePanel();
        this.setVisible(true);
        this.add(machinePanel);
    }

    public void setSave(ActionListener actionListener){
        machinePanel.setSave(actionListener);
    }

    public Map getValues(){
        return machinePanel.getValues();
    }

    public void setValues(Map values){
        machinePanel.setTexts(values);
    }

    public void setId(int id){
        machinePanel.setId(id);
    }

}
