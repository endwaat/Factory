package GUI.Windows;

import GUI.Panes.admin.UserPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class UserFrame extends JInternalFrame {
    private UserPanel userPanel;

    public UserFrame(String title, boolean resizable, boolean closable,
                          boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 475, 370);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        userPanel = new UserPanel();
        this.setVisible(true);
        this.add(userPanel);
    }

    public void setSave(ActionListener actionListener){
        userPanel.setSave(actionListener);
    }

    public Map getValues(){
        return userPanel.getValues();
    }

    public void setValues(Map values){
        userPanel.setTexts(values);
    }

    public void setId(int id){
        userPanel.setId(id);
    }
}
