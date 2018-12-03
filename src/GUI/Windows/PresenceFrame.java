package GUI.Windows;

import GUI.Panes.workers.PresencePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class PresenceFrame extends JInternalFrame {
    private PresencePanel presencePanel;

    public PresenceFrame(String title, boolean resizable, boolean closable,
                         boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
            this.setBounds(10, 10, 345, 160);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        presencePanel = new PresencePanel();
        this.setVisible(true);
        this.add(presencePanel);
    }
    public void setSave(ActionListener actionListener){
        presencePanel.setSave(actionListener);
    }

    public Map getValues(){
        return presencePanel.getValues();
    }

}
