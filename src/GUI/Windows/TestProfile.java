/*
 * Created by JFormDesigner on Wed Oct 31 15:50:41 CET 2018
 */

package GUI.Windows;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class TestProfile extends JPanel {
    public TestProfile() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        panel1 = new JPanel();
        label3 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        textField3 = new JTextField();
        button2 = new JButton();
        button1 = new JButton();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
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
                "[]"));

            //---- label3 ----
            label3.setText("Name");
            panel1.add(label3, "cell 0 0,alignx right,growx 0");
            panel1.add(textField1, "cell 1 0");

            //---- label4 ----
            label4.setText("PW");
            panel1.add(label4, "cell 0 1,alignx right,growx 0");
            panel1.add(textField2, "cell 1 1");

            //---- label5 ----
            label5.setText("email");
            panel1.add(label5, "cell 0 2,alignx right,growx 0");
            panel1.add(textField3, "cell 1 2");

            //---- button2 ----
            button2.setText("Cancel");
            panel1.add(button2, "cell 0 3");

            //---- button1 ----
            button1.setText("Save");
            panel1.add(button1, "cell 1 3");
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JPanel panel1;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label5;
    private JTextField textField3;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
