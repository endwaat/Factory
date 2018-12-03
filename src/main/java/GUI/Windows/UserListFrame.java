package GUI.Windows;

import GUI.Panes.admin.UserListPanel;
import GUI.Panes.allergens.AllergensListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class UserListFrame extends JInternalFrame {
    private UserListPanel userListPanel;

    public UserListFrame(String title, boolean resizable, boolean closable,
                         boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 300, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        userListPanel = new UserListPanel();
        this.setVisible(true);
        this.add(userListPanel);
    }

    public void setEdit(ActionListener actionListener){
        userListPanel.getEditButton().addActionListener(actionListener);
    }
    public void setDelete(ActionListener actionListener){
        userListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) userListPanel.getUserTable().getModel().getValueAt(userListPanel.getUserTable().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        userListPanel.setTableValues(values);
    }

}
