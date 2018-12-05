package GUI.Windows;

import GUI.Panes.orders.SupplierListPanel;
import GUI.Panes.workers.WorkerListPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class WorkerListFrame extends JInternalFrame {
    private WorkerListPanel workerListPanel;

    public WorkerListFrame(String title, boolean resizable, boolean closable,
                           boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(10, 10, 500, 300);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        workerListPanel = new WorkerListPanel();
        this.setVisible(true);
        this.add(workerListPanel);
    }

    public void setEdit(ActionListener actionListener){
        workerListPanel.getEditButton().addActionListener(actionListener);
    }
    public void setDelete(ActionListener actionListener){
        workerListPanel.getDeleteButton().addActionListener(actionListener);
    }

    public int getId(){
        return (int) workerListPanel.getWorkerTable().getModel().getValueAt(workerListPanel.getWorkerTable().getSelectedRow(),0);
    }

    public void setValues(List<Map> values){
        workerListPanel.setTableValues(values);
    }

}
