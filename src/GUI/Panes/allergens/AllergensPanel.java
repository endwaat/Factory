/*
 * Created by JFormDesigner on Mon Nov 05 22:01:45 CET 2018
 */

package GUI.Panes.allergens;

import javax.swing.*;

import net.miginfocom.swing.*;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dominik
 */
public class AllergensPanel extends JPanel {

    public AllergensPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        label1 = new JLabel();
        allergenField = new JTextField();
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
            "[89,fill]" +
            "[83,fill]",
            // rows
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Allerg\u00e9n");
        add(label1, "cell 0 0,alignx right,growx 0");
        add(allergenField, "cell 1 0");

        //---- saveButton ----
        saveButton.setText("Save");
        add(saveButton, "cell 0 1 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label1;
    private JTextField allergenField;
    private JButton saveButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private int id = 0;
    public void setSave(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }

    public HashMap getValues() {
        HashMap values = new HashMap();
        try {
            values.put("id", id);
            values.put("name", allergenField.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
        return values;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexts(Map values) {
        allergenField.setText((String) values.get("name"));
    }
}
