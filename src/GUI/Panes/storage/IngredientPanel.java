/*
 * Created by JFormDesigner on Sun Nov 18 22:36:26 CET 2018
 */

package GUI.Panes.storage;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Dominik
 */
public class IngredientPanel extends JPanel {
    public IngredientPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        label7 = new JLabel();
        nameField = new JTextField();
        label6 = new JLabel();
        typeCombo = new JComboBox();
        label5 = new JLabel();
        arrivedSpinner = new JSpinner();
        label4 = new JLabel();
        expireSpinner = new JSpinner();
        label3 = new JLabel();
        weightSpinner = new JSpinner();
        label2 = new JLabel();
        sourceField = new JTextField();
        label1 = new JLabel();
        valueSpinner = new JSpinner();
        button2 = new JButton();

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

        //---- label7 ----
        label7.setText("Alapanyag n\u00e9v");
        add(label7, "cell 0 0,alignx right,growx 0");
        add(nameField, "cell 1 0");

        //---- label6 ----
        label6.setText("Alapanyag t\u00edpus");
        add(label6, "cell 0 1,alignx right,growx 0");

        //---- typeCombo ----
        typeCombo.setMaximumRowCount(90);
        add(typeCombo, "cell 1 1");

        //---- label5 ----
        label5.setText("Beszerz\u00e9si d\u00e1tum");
        add(label5, "cell 0 2,alignx right,growx 0");

        //---- arrivedSpinner ----
        arrivedSpinner.setModel(new SpinnerDateModel());
        add(arrivedSpinner, "cell 1 2");

        //---- label4 ----
        label4.setText("Lej\u00e1rati d\u00e1tum");
        add(label4, "cell 0 3,alignx right,growx 0");

        //---- expireSpinner ----
        expireSpinner.setModel(new SpinnerDateModel(new java.util.Date(1542578820000L), new java.util.Date((System.currentTimeMillis()/60000)*60000), null, java.util.Calendar.DAY_OF_MONTH));
        add(expireSpinner, "cell 1 3");

        //---- label3 ----
        label3.setText("Mennyis\u00e9g (kg)");
        add(label3, "cell 0 4,alignx right,growx 0");

        //---- weightSpinner ----
        weightSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
        add(weightSpinner, "cell 1 4");

        //---- label2 ----
        label2.setText("Beszerz\u0151");
        add(label2, "cell 0 5,alignx right,growx 0");
        add(sourceField, "cell 1 5");

        //---- label1 ----
        label1.setText("\u00c9rt\u00e9k (Ft)");
        add(label1, "cell 0 6,alignx right,growx 0");

        //---- valueSpinner ----
        valueSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
        add(valueSpinner, "cell 1 6");

        //---- button2 ----
        button2.setText("Ment\u00e9s");
        add(button2, "cell 0 7 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label7;
    private JTextField nameField;
    private JLabel label6;
    private JComboBox typeCombo;
    private JLabel label5;
    private JSpinner arrivedSpinner;
    private JLabel label4;
    private JSpinner expireSpinner;
    private JLabel label3;
    private JSpinner weightSpinner;
    private JLabel label2;
    private JTextField sourceField;
    private JLabel label1;
    private JSpinner valueSpinner;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
