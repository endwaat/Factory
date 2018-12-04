/*
 * Created by JFormDesigner on Sun Nov 18 22:55:29 CET 2018
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
public class PresencePanel extends JPanel {
    public PresencePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        label1 = new JLabel();
        barcodeField = new JTextField();
        label2 = new JLabel();
        dateSpinner = new JSpinner();
        label3 = new JLabel();
        hourSpinner = new JSpinner();
        saveButton = new JButton();

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
        label1.setText("Dolgoz\u00f3 azonos\u00edt\u00f3ja");
        add(label1, "cell 0 0,alignx right,growx 0");
        add(barcodeField, "cell 1 0");

        //---- label2 ----
        label2.setText("Munkanap");
        add(label2, "cell 0 1,alignx right,growx 0");

        //---- dateSpinner ----
        dateSpinner.setModel(new SpinnerDateModel());
        add(dateSpinner, "cell 1 1");

        //---- label3 ----
        label3.setText("Dolgozott \u00f3ra");
        add(label3, "cell 0 2,alignx right,growx 0");

        //---- hourSpinner ----
        hourSpinner.setModel(new SpinnerNumberModel(8, 0, 12, 0));
        add(hourSpinner, "cell 1 2");

        //---- saveButton ----
        saveButton.setText("Ment\u00e9s");
        add(saveButton, "cell 0 3 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label1;
    private JTextField barcodeField;
    private JLabel label2;
    private JSpinner dateSpinner;
    private JLabel label3;
    private JSpinner hourSpinner;
    private JButton saveButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void setSave(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }

    public Map getValues() {
        Map values = new HashMap();
        try {
            values.put("barcode", barcodeField.getText());
            values.put("date", dateSpinner.getValue());
            values.put("hour", hourSpinner.getValue());
        } catch (Exception e) {
            System.out.println(e);
        }
        return values;
    }

    public void setTexts(Map values) {
        barcodeField.setText((String) values.get("barcode"));
    }
}
