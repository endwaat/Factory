package GUI.Windows;

import GUI.Panes.allergens.AllergensListPanel;
import GUI.Panes.machines.MachineListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class MachineListFrame extends JInternalFrame {
    private MachineListPanel machineListPanel;

    public MachineListFrame(String title, boolean resizable, boolean closable,
                            boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 300, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        machineListPanel = new MachineListPanel();
        this.setVisible(true);
        this.add(machineListPanel);
    }

    public void setEdit(ActionListener actionListener){
        machineListPanel.getEditButton().addActionListener(actionListener);
    }
    public void setDelete(ActionListener actionListener){
        machineListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) machineListPanel.getMachineTable().getModel().getValueAt(machineListPanel.getMachineTable().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        machineListPanel.setTableValues(values);
    }

}
