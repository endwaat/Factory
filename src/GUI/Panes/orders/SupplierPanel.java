/*
 * Created by JFormDesigner on Mon Nov 05 22:48:07 CET 2018
 */

package GUI.Panes.orders;

import javax.swing.*;
import net.miginfocom.swing.*;

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
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        button1 = new JButton();

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
            "[136,fill]" +
            "[136,fill]",
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
        add(textField1, "cell 1 0");

        //---- label2 ----
        label2.setText("Telefonsz\u00e1m");
        add(label2, "cell 0 1,alignx right,growx 0");
        add(textField2, "cell 1 1");

        //---- label3 ----
        label3.setText("Ir\u00e1ny\u00edt\u00f3sz\u00e1m");
        add(label3, "cell 0 2,alignx right,growx 0");
        add(textField3, "cell 1 2");

        //---- label4 ----
        label4.setText("V\u00e1ros");
        add(label4, "cell 0 3,alignx right,growx 0");
        add(textField4, "cell 1 3");

        //---- label5 ----
        label5.setText("C\u00edm");
        add(label5, "cell 0 4,alignx right,growx 0");
        add(textField5, "cell 1 4");

        //---- button1 ----
        button1.setText("Ment\u00e9s");
        add(button1, "cell 0 5 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
