/*
 * Created by JFormDesigner on Mon Nov 05 22:11:25 CET 2018
 */

package GUI.Panes.orders;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Dominik
 */
public class OrderPanel extends JPanel {
    public OrderPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        tabbedPane1 = new JTabbedPane();
        label1 = new JLabel();
        nameField = new JTextField();
        label2 = new JLabel();
        costumerField = new JTextField();
        label3 = new JLabel();
        priceField = new JTextField();
        label4 = new JLabel();
        orderDate = new JFormattedTextField();
        label5 = new JLabel();
        endDate = new JFormattedTextField();
        doneCheckBox = new JCheckBox();
        exchangeButton = new JButton();
        saveButton = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== tabbedPane1 ========
        {

            //======== this ========
            {

                // JFormDesigner evaluation mark
                this.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), this.getBorder())); this.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                this.setLayout(new MigLayout(
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
                    "[]" +
                    "[]"));

                //---- label1 ----
                label1.setText("Rendel\u00e9s neve");
                this.add(label1, "cell 0 0,alignx right,growx 0");
                this.add(nameField, "cell 1 0");

                //---- label2 ----
                label2.setText("Megrendel\u0151");
                this.add(label2, "cell 0 1,alignx right,growx 0");
                this.add(costumerField, "cell 1 1");

                //---- label3 ----
                label3.setText("\u00c1r");
                this.add(label3, "cell 0 2,alignx right,growx 0");
                this.add(priceField, "cell 1 2");

                //---- label4 ----
                label4.setText("Rendel\u00e9s d\u00e1tuma");
                this.add(label4, "cell 0 3,alignx right,growx 0");
                this.add(orderDate, "cell 1 3");

                //---- label5 ----
                label5.setText("Hat\u00e1rid\u0151");
                this.add(label5, "cell 0 4,alignx right,growx 0");
                this.add(endDate, "cell 1 4");

                //---- doneCheckBox ----
                doneCheckBox.setText("Teljes\u00edtve");
                this.add(doneCheckBox, "cell 1 5");

                //---- exchangeButton ----
                exchangeButton.setText("Lez\u00e1r\u00e1s");
                this.add(exchangeButton, "cell 0 6");

                //---- saveButton ----
                saveButton.setText("Ment\u00e9s");
                this.add(saveButton, "cell 1 6");
            }
            tabbedPane1.addTab("Rendel\u00e9s", this);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            tabbedPane1.addTab("Rendel\u00e9si t\u00e9telek", scrollPane1);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JTabbedPane tabbedPane1;
    private JLabel label1;
    private JTextField nameField;
    private JLabel label2;
    private JTextField costumerField;
    private JLabel label3;
    private JTextField priceField;
    private JLabel label4;
    private JFormattedTextField orderDate;
    private JLabel label5;
    private JFormattedTextField endDate;
    private JCheckBox doneCheckBox;
    private JButton exchangeButton;
    private JButton saveButton;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
