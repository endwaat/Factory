package GUI.Windows;

import GUI.Panes.file.ProfilePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ProfileFrame extends JInternalFrame {
    private ProfilePanel profilePanel;
    private JPanel mainPanel;

    public ProfileFrame(String title, boolean resizable, boolean closable,
                        boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 300, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        profilePanel = new ProfilePanel();
        mainPanel = profilePanel.getPanel1();
        this.setVisible(true);
        this.add(mainPanel);
    }

    public void setSave(ActionListener actionListener){
        profilePanel.setSave(actionListener);
    }

    public HashMap getValues(){
        return profilePanel.getValues();
    }

    public void setValues(HashMap values){
        profilePanel.setTexts(values);
    }

}
