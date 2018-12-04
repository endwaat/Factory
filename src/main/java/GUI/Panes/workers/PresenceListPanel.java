/*
 * Created by JFormDesigner on Mon Dec 03 15:17:45 CET 2018
 */

package GUI.Panes.workers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dominik
 */
public class PresenceListPanel extends JPanel {
    public PresenceListPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        label1 = new JLabel();
        fromDate = new JSpinner();
        label2 = new JLabel();
        toDate = new JSpinner();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        deleteButton = new JButton();
        showButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[150,grow,fill]" +
            "[150,grow,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Mett\u0151l");
        add(label1, "cell 0 0,alignx right,growx 0");

        //---- fromDate ----
        fromDate.setModel(new SpinnerDateModel());
        add(fromDate, "cell 1 0");

        //---- label2 ----
        label2.setText("Meddig");
        add(label2, "cell 0 1,alignx right,growx 0");

        //---- toDate ----
        toDate.setModel(new SpinnerDateModel());
        add(toDate, "cell 1 1");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, "cell 0 2 2 1");

        //---- deleteButton ----
        deleteButton.setText("T\u00f6rl\u00e9s");
        add(deleteButton, "cell 0 3");

        //---- showButton ----
        showButton.setText("Megjelen\u00edt\u00e9s");
        add(showButton, "cell 1 3");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label1;
    private JSpinner fromDate;
    private JLabel label2;
    private JSpinner toDate;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton deleteButton;
    private JButton showButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void setTableValues(List<Map> list) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Azonosító", "Név", "Dátum", "Óra"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).get("id"), list.get(i).get("barcode"), list.get(i).get("name"), list.get(i).get("date"), list.get(i).get("hour")});
        }
        table1.setModel(model);
        table1.removeColumn(table1.getColumnModel().getColumn(0));
    }

    public Map getDateInterval(){
        Map values = new HashMap();
        values.put("from",fromDate.getValue());
        values.put("to",toDate.getValue());
        return values;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public void setScrollPane1(JScrollPane scrollPane1) {
        this.scrollPane1 = scrollPane1;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getShowButton() {
        return showButton;
    }

    public void setShowButton(JButton showButton) {
        this.showButton = showButton;
    }
}
