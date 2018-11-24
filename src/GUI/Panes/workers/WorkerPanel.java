/*
 * Created by JFormDesigner on Sun Nov 18 23:03:47 CET 2018
 */

package GUI.Panes.workers;

import javax.swing.*;
import net.miginfocom.swing.*;

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
                    java.awt.Color.red), dataPanel.getBorder())); dataPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

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
                "[]"));

            //---- label1 ----
            label1.setText("N\u00e9v");
            dataPanel.add(label1, "cell 0 0,alignx right,growx 0");
            dataPanel.add(nameField, "cell 1 0");

            //---- label2 ----
            label2.setText("Email");
            dataPanel.add(label2, "cell 0 1,alignx right,growx 0");
            dataPanel.add(emailField, "cell 1 1");

            //---- label3 ----
            label3.setText("Fizet\u00e9s");
            dataPanel.add(label3, "cell 0 2,alignx right,growx 0");
            dataPanel.add(salaryField, "cell 1 2");

            //---- label4 ----
            label4.setText("Ir\u00e1ny\u00edt\u00f3sz\u00e1m");
            dataPanel.add(label4, "cell 0 3,alignx right,growx 0");
            dataPanel.add(zipField, "cell 1 3");

            //---- label5 ----
            label5.setText("V\u00e1ros");
            dataPanel.add(label5, "cell 0 4,alignx right,growx 0");
            dataPanel.add(townField, "cell 1 4");

            //---- label6 ----
            label6.setText("Lakc\u00edm");
            dataPanel.add(label6, "cell 0 5,alignx right,growx 0");
            dataPanel.add(addressField, "cell 1 5");

            //---- label7 ----
            label7.setText("Telefonsz\u00e1m");
            dataPanel.add(label7, "cell 0 6,alignx right,growx 0");
            dataPanel.add(phoneField, "cell 1 6");

            //---- saveButton ----
            saveButton.setText("Ment\u00e9s");
            dataPanel.add(saveButton, "cell 0 7 2 1");
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
}
