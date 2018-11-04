package GUI.Windows;

import GUI.Panes.ProfilePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ProfileFrame extends JInternalFrame {
    private ProfilePane profilePane;
    private JPanel mainPanel;

    public ProfileFrame(String title, boolean resizable, boolean closable,
                        boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 300, 275);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        profilePane = new ProfilePane();
        mainPanel = profilePane.getPanel1();
        this.setVisible(true);
        this.add(mainPanel);
    }

    public void setSave(ActionListener actionListener){
        profilePane.setSave(actionListener);
    }

    public HashMap getValues(){
        return profilePane.getValues();
    }

    public void setValues(HashMap values){
        profilePane.setTexts(values);
    }

}
