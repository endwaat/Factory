/*
 * Created by JFormDesigner on Sun Nov 04 17:26:38 CET 2018
 */

package GUI.Panes;

import javax.swing.*;

import Controller.Controller;
import Database.DAO;
import net.miginfocom.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * @author Dominik
 */
public class ProfilePane {

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        panel1 = new JPanel();
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
        saveButton = new JButton();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new MigLayout(
                "fillx,hidemode 3,align center center",
                // columns
                "[fill]" +
                "[fill]",
                // rows
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
            panel1.add(label3, "cell 0 0,alignx right,growx 0");
            panel1.add(nameField, "cell 1 0");

            //---- label4 ----
            label4.setText("Jelsz\u00f3");
            panel1.add(label4, "cell 0 1,alignx right,growx 0");
            panel1.add(passwordField, "cell 1 1");

            //---- label5 ----
            label5.setText("Email");
            panel1.add(label5, "cell 0 2,alignx right,growx 0");
            panel1.add(emailField, "cell 1 2");

            //---- label1 ----
            label1.setText("Ir\u00e1ny\u00edt\u00f3sz\u00e1m");
            panel1.add(label1, "cell 0 3,alignx right,growx 0");
            panel1.add(zipField, "cell 1 3");

            //---- label2 ----
            label2.setText("V\u00e1ros");
            panel1.add(label2, "cell 0 4,alignx right,growx 0");
            panel1.add(townField, "cell 1 4");

            //---- label6 ----
            label6.setText("Lakc\u00edm");
            panel1.add(label6, "cell 0 5,alignx right,growx 0");
            panel1.add(addressField, "cell 1 5");

            //---- label7 ----
            label7.setText("Telefonsz\u00e1m");
            panel1.add(label7, "cell 0 6,alignx right,growx 0");
            panel1.add(phoneField, "cell 1 6");

            //---- saveButton ----
            saveButton.setText("Save");
            panel1.add(saveButton, "cell 0 7 2 1");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JPanel panel1;
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
    private JButton saveButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public ProfilePane() {
        initComponents();
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public HashMap getValues() {
        HashMap values = new HashMap();
        try {
            values.put("username", nameField.getText());
            values.put("password", passwordField.getText());
            values.put("email", emailField.getText());
            values.put("zip", zipField.getText());
            values.put("town", townField.getText());
            values.put("address", addressField.getText());
            values.put("phone", phoneField.getText());
        }catch (Exception e){
            System.out.println(e);
        }
        return values;
    }

    public void setTexts(HashMap values) {
        nameField.setText((String)values.get("username"));
        passwordField.setText((String)values.get("password"));
        emailField.setText((String)values.get("email"));
        zipField.setText((String)values.get("zip"));
        townField.setText((String)values.get("town"));
        addressField.setText((String)values.get("address"));
        phoneField.setText((String)values.get("phone"));
    }

    public void setSave(ActionListener actionListener){
        saveButton.addActionListener(actionListener);
    }
}
