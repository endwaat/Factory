/*
 * Created by JFormDesigner on Thu Nov 15 21:10:52 CET 2018
 */

package GUI.Panes.machines;

import javax.swing.*;
import net.miginfocom.swing.*;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dominik
 */
public class MachinePanel extends JPanel {
    public MachinePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        label1 = new JLabel();
        nameField = new JTextField();
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
            "[93,grow,fill]" +
            "[176,grow,fill]",
            // rows
            "[]" +
            "[33]"));

        //---- label1 ----
        label1.setText("G\u00e9p n\u00e9v:");
        add(label1, "cell 0 0,alignx right,growx 0");
        add(nameField, "cell 1 0,growx");

        //---- saveButton ----
        saveButton.setText("Ment\u00e9s");
        add(saveButton, "cell 0 1 2 1,aligny center,grow 100 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label1;
    private JTextField nameField;
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
    }

}
