/*
 * Created by JFormDesigner on Mon Nov 05 22:48:07 CET 2018
 */

package GUI.Panes.orders;

import javax.swing.*;

import Database.DAO;
import bean.Item;
import net.miginfocom.swing.*;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dominik
 */
public class SupplierPanel extends JPanel {
    public SupplierPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        label1 = new JLabel();
        nameField = new JTextField();
        label2 = new JLabel();
        phoneField = new JTextField();
        label3 = new JLabel();
        zipField = new JTextField();
        label4 = new JLabel();
        townField = new JTextField();
        label5 = new JLabel();
        addressField = new JTextField();
        saveButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
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
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Sz\u00e1ll\u00edt\u00f3 neve");
        add(label1, "cell 0 0,alignx right,growx 0");
        add(nameField, "cell 1 0");

        //---- label2 ----
        label2.setText("Telefonsz\u00e1m");
        add(label2, "cell 0 1,alignx right,growx 0");
        add(phoneField, "cell 1 1");

        //---- label3 ----
        label3.setText("Ir\u00e1ny\u00edt\u00f3sz\u00e1m");
        add(label3, "cell 0 2,alignx right,growx 0");
        add(zipField, "cell 1 2");

        //---- label4 ----
        label4.setText("V\u00e1ros");
        add(label4, "cell 0 3,alignx right,growx 0");
        add(townField, "cell 1 3");

        //---- label5 ----
        label5.setText("C\u00edm");
        add(label5, "cell 0 4,alignx right,growx 0");
        add(addressField, "cell 1 4");

        //---- saveButton ----
        saveButton.setText("Ment\u00e9s");
        add(saveButton, "cell 0 5 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label1;
    private JTextField nameField;
    private JLabel label2;
    private JTextField phoneField;
    private JLabel label3;
    private JTextField zipField;
    private JLabel label4;
    private JTextField townField;
    private JLabel label5;
    private JTextField addressField;
    private JButton saveButton;
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
            values.put("phone", phoneField.getText());
            values.put("zip", zipField.getText());
            values.put("town", townField.getText());
            values.put("address", addressField.getText());
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
        phoneField.setText(String.valueOf(values.get("phone")));
        zipField.setText(String.valueOf(values.get("zip")));
        townField.setText((String) values.get("town"));
        addressField.setText((String) values.get("address"));
    }
}
