/*
 * Created by JFormDesigner on Mon Nov 12 21:46:36 CET 2018
 */

package GUI.Panes.admin;

import javax.swing.*;

import com.sun.org.apache.xpath.internal.operations.Bool;
import net.miginfocom.swing.*;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dominik
 */
public class UserPanel extends JPanel {
    public UserPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        label3 = new JLabel();
        nameField = new JTextField();
        label4 = new JLabel();
        passwordField = new JTextField();
        label5 = new JLabel();
        emailField = new JTextField();
        label1 = new JLabel();
        zipField = new JTextField();
        label2 = new JLabel();
        townField = new JTextField();
        label6 = new JLabel();
        addressField = new JTextField();
        label7 = new JLabel();
        phoneField = new JTextField();
        storageCheckBox = new JCheckBox();
        productCheckBox = new JCheckBox();
        workerCheckBox = new JCheckBox();
        allergensCheckBox = new JCheckBox();
        machinesCheckBox = new JCheckBox();
        orderCheckBox = new JCheckBox();
        adminCheckBox = new JCheckBox();
        saveButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "fillx,hidemode 3,align center center",
            // columns
            "[grow,fill]" +
            "[grow,fill]" +
            "[grow,fill]" +
            "[grow,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label3 ----
        label3.setText("N\u00e9v");
        add(label3, "cell 0 0 2 1,alignx right,growx 0");
        add(nameField, "cell 2 0 2 1");

        //---- label4 ----
        label4.setText("Jelsz\u00f3");
        add(label4, "cell 0 1 2 1,alignx right,growx 0");
        add(passwordField, "cell 2 1 2 1");

        //---- label5 ----
        label5.setText("Email");
        add(label5, "cell 0 2 2 1,alignx right,growx 0");
        add(emailField, "cell 2 2 2 1");

        //---- label1 ----
        label1.setText("Ir\u00e1ny\u00edt\u00f3sz\u00e1m");
        add(label1, "cell 0 3 2 1,alignx right,growx 0");
        add(zipField, "cell 2 3 2 1");

        //---- label2 ----
        label2.setText("V\u00e1ros");
        add(label2, "cell 0 4 2 1,alignx right,growx 0");
        add(townField, "cell 2 4 2 1");

        //---- label6 ----
        label6.setText("Lakc\u00edm");
        add(label6, "cell 0 5 2 1,alignx right,growx 0");
        add(addressField, "cell 2 5 2 1");

        //---- label7 ----
        label7.setText("Telefonsz\u00e1m");
        add(label7, "cell 0 6 2 1,alignx right,growx 0");
        add(phoneField, "cell 2 6 2 1");

        //---- storageCheckBox ----
        storageCheckBox.setText("Rakt\u00e1r");
        add(storageCheckBox, "cell 0 7");

        //---- productCheckBox ----
        productCheckBox.setText("Term\u00e9k");
        add(productCheckBox, "cell 1 7");

        //---- workerCheckBox ----
        workerCheckBox.setText("Dolgoz\u00f3");
        add(workerCheckBox, "cell 2 7");

        //---- allergensCheckBox ----
        allergensCheckBox.setText("Allerg\u00e9n");
        add(allergensCheckBox, "cell 3 7");

        //---- machinesCheckBox ----
        machinesCheckBox.setText("G\u00e9pek");
        add(machinesCheckBox, "cell 0 8");

        //---- orderCheckBox ----
        orderCheckBox.setText("Rendel\u00e9s");
        add(orderCheckBox, "cell 1 8");

        //---- adminCheckBox ----
        adminCheckBox.setText("Admin");
        add(adminCheckBox, "cell 2 8");

        //---- saveButton ----
        saveButton.setText("Ment\u00e9s");
        add(saveButton, "cell 0 9 4 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label3;
    private JTextField nameField;
    private JLabel label4;
    private JTextField passwordField;
    private JLabel label5;
    private JTextField emailField;
    private JLabel label1;
    private JTextField zipField;
    private JLabel label2;
    private JTextField townField;
    private JLabel label6;
    private JTextField addressField;
    private JLabel label7;
    private JTextField phoneField;
    private JCheckBox storageCheckBox;
    private JCheckBox productCheckBox;
    private JCheckBox workerCheckBox;
    private JCheckBox allergensCheckBox;
    private JCheckBox machinesCheckBox;
    private JCheckBox orderCheckBox;
    private JCheckBox adminCheckBox;
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
            values.put("username", nameField.getText());
            values.put("password", passwordField.getText());
            values.put("email", emailField.getText());
            values.put("zip", zipField.getText());
            values.put("town", townField.getText());
            values.put("address", addressField.getText());
            values.put("phone", phoneField.getText());
            values.put("storage", storageCheckBox.isSelected());
            values.put("product", productCheckBox.isSelected());
            values.put("worker", workerCheckBox.isSelected());
            values.put("allergens", allergensCheckBox.isSelected());
            values.put("machine", machinesCheckBox.isSelected());
            values.put("order", orderCheckBox.isSelected());
            values.put("admin", adminCheckBox.isSelected());
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
        passwordField.setText((String) values.get("password"));
        emailField.setText((String) values.get("email"));
        zipField.setText((String) values.get("zip"));
        townField.setText((String) values.get("town"));
        addressField.setText((String) values.get("address"));
        phoneField.setText((String) values.get("phone"));
        storageCheckBox.setSelected("t".equals(values.get("storage")));
        productCheckBox.setSelected("t".equals(values.get("products")));
        workerCheckBox.setSelected("t".equals(values.get("workers")));
        allergensCheckBox.setSelected("t".equals(values.get("allergen")));
        machinesCheckBox.setSelected("t".equals(values.get("machines")));
        orderCheckBox.setSelected("t".equals(values.get("orders")));
        adminCheckBox.setSelected("t".equals(values.get("admin")));
    }

}
