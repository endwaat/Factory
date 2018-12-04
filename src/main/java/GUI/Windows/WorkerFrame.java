package GUI.Windows;

import GUI.Panes.orders.SupplierPanel;
import GUI.Panes.workers.WorkerPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class WorkerFrame extends JInternalFrame {
    private WorkerPanel workerPanel;

    public WorkerFrame(String title, boolean resizable, boolean closable,
                       boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
            this.setBounds(10, 10, 345, 320);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        workerPanel = new WorkerPanel();
        this.setVisible(true);
        this.add(workerPanel);
    }
    public void setSave(ActionListener actionListener){
        workerPanel.setSave(actionListener);
    }

    public Map getValues(){
        return workerPanel.getValues();
    }

    public void setValues(Map values){
        workerPanel.setTexts(values);
    }

    public void setAttendance(List<Map> values){
        workerPanel.setAttendance(values);
    }

    public void setId(int id){
        workerPanel.setId(id);
    }

}
