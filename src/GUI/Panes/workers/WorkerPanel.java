/*
 * Created by JFormDesigner on Sun Nov 18 23:03:47 CET 2018
 */

package GUI.Panes.workers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dominik
 */
public class WorkerPanel extends JTabbedPane {
    public WorkerPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        dataPanel = new JPanel();
        label1 = new JLabel();
        nameField = new JTextField();
        label8 = new JLabel();
        barcodeField = new JTextField();
        label2 = new JLabel();
        emailField = new JTextField();
        label3 = new JLabel();
        salaryField = new JTextField();
        label4 = new JLabel();
        zipField = new JTextField();
        label5 = new JLabel();
        townField = new JTextField();
        label6 = new JLabel();
        addressField = new JTextField();
        label7 = new JLabel();
        phoneField = new JTextField();
        saveButton = new JButton();
        scrollPane1 = new JScrollPane();
        presenceTable = new JTable();

        //======== this ========

        //======== dataPanel ========
        {

            // JFormDesigner evaluation mark
            dataPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), dataPanel.getBorder()));
            dataPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            dataPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[175,grow,fill]" +
                            "[175,grow,fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]"));

            //---- label1 ----
            label1.setText("N\u00e9v");
            dataPanel.add(label1, "cell 0 0,alignx right,growx 0");
            dataPanel.add(nameField, "cell 1 0");

            //---- label8 ----
            label8.setText("Azonos\u00edt\u00f3");
            dataPanel.add(label8, "cell 0 1,alignx right,growx 0");
            dataPanel.add(barcodeField, "cell 1 1");

            //---- label2 ----
            label2.setText("Email");
            dataPanel.add(label2, "cell 0 2,alignx right,growx 0");
            dataPanel.add(emailField, "cell 1 2");

            //---- label3 ----
            label3.setText("Fizet\u00e9s");
            dataPanel.add(label3, "cell 0 3,alignx right,growx 0");
            dataPanel.add(salaryField, "cell 1 3");

            //---- label4 ----
            label4.setText("Ir\u00e1ny\u00edt\u00f3sz\u00e1m");
            dataPanel.add(label4, "cell 0 4,alignx right,growx 0");
            dataPanel.add(zipField, "cell 1 4");

            //---- label5 ----
            label5.setText("V\u00e1ros");
            dataPanel.add(label5, "cell 0 5,alignx right,growx 0");
            dataPanel.add(townField, "cell 1 5");

            //---- label6 ----
            label6.setText("Lakc\u00edm");
            dataPanel.add(label6, "cell 0 6,alignx right,growx 0");
            dataPanel.add(addressField, "cell 1 6");

            //---- label7 ----
            label7.setText("Telefonsz\u00e1m");
            dataPanel.add(label7, "cell 0 7,alignx right,growx 0");
            dataPanel.add(phoneField, "cell 1 7");

            //---- saveButton ----
            saveButton.setText("Ment\u00e9s");
            dataPanel.add(saveButton, "cell 0 8 2 1");
        }
        addTab("Adatok", dataPanel);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(presenceTable);
        }
        addTab("Jelenl\u00e9t", scrollPane1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JPanel dataPanel;
    private JLabel label1;
    private JTextField nameField;
    private JLabel label8;
    private JTextField barcodeField;
    private JLabel label2;
    private JTextField emailField;
    private JLabel label3;
    private JTextField salaryField;
    private JLabel label4;
    private JTextField zipField;
    private JLabel label5;
    private JTextField townField;
    private JLabel label6;
    private JTextField addressField;
    private JLabel label7;
    private JTextField phoneField;
    private JButton saveButton;
    private JScrollPane scrollPane1;
    private JTable presenceTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private int id = 0;

    public void setSave(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }

    public Map getValues() {
        Map values = new HashMap();
        try {
            values.put("id", id);
            values.put("name", nameField.getText());
            values.put("barcode", barcodeField.getText());
            values.put("email", emailField.getText());
            values.put("salary", salaryField.getText());
            values.put("zip", zipField.getText());
            values.put("town", townField.getText());
            values.put("address", addressField.getText());
            values.put("phone", phoneField.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
        return values;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexts(Map values) {
        nameField.setText((String) values.get("name"));
        barcodeField.setText((String) values.get("barcode"));
        emailField.setText((String) values.get("email"));
        salaryField.setText(String.valueOf(values.get("salary")));
        zipField.setText(String.valueOf(values.get("zip")));
        townField.setText((String) values.get("town"));
        addressField.setText((String) values.get("address"));
        phoneField.setText(String.valueOf(values.get("phone")));
    }

    public void setAttendance(List<Map> list) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Felhasználó", "Telefon"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).get("id"), list.get(i).get("name"), list.get(i).get("phone")});
        }
        presenceTable.setModel(model);
        presenceTable.removeColumn(presenceTable.getColumnModel().getColumn(0));
    }

    public JTable getPresenceTable() {
        return presenceTable;
    }

    public void setPresenceTable(JTable presenceTable) {
        this.presenceTable = presenceTable;
    }
}
