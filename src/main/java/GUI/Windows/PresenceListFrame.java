package GUI.Windows;

import GUI.Panes.workers.PresenceListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class PresenceListFrame extends JInternalFrame {
    private PresenceListPanel presenceListPanel;

    public PresenceListFrame(String title, boolean resizable, boolean closable,
                             boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 500, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        presenceListPanel = new PresenceListPanel();
        this.setVisible(true);
        this.add(presenceListPanel);
    }

    public void setShow(ActionListener actionListener){
        presenceListPanel.getShowButton().addActionListener(actionListener);
    }

    public void setDelete(ActionListener actionListener){
        presenceListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public Map getDateInterval(){
        return presenceListPanel.getDateInterval();
    }

    public int getId(){
        return (int) presenceListPanel.getTable1().getModel().getValueAt(presenceListPanel.getTable1().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        presenceListPanel.setTableValues(values);
    }

}
