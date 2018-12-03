/*
 * Created by JFormDesigner on Mon Nov 05 22:11:25 CET 2018
 */

package GUI.Panes.orders;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Dominik
 */
public class OrderPanel extends JTabbedPane {
    public OrderPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        panel = new JPanel();
        label1 = new JLabel();
        nameField = new JTextField();
        label2 = new JLabel();
        costumerField = new JTextField();
        label3 = new JLabel();
        priceField = new JTextField();
        label4 = new JLabel();
        orderDateSpinner = new JSpinner();
        label5 = new JLabel();
        endDateSpinner = new JSpinner();
        doneCheckBox = new JCheckBox();
        exchangeButton = new JButton();
        saveButton = new JButton();
        panel1 = new JPanel();
        label6 = new JLabel();
        productTypeField = new JTextField();
        browseOrderButton = new JButton();
        label7 = new JLabel();
        orderWeightSpinner = new JSpinner();
        addOrderButton = new JButton();
        deleteOrderButton = new JButton();
        scrollPane1 = new JScrollPane();
        orderdProductsTable = new JTable();
        panel2 = new JPanel();
        label8 = new JLabel();
        productField = new JTextField();
        browseProductButton = new JButton();
        label9 = new JLabel();
        productWeightSpinner = new JSpinner();
        addProdutButton = new JButton();
        deleteProductButton = new JButton();
        scrollPane2 = new JScrollPane();
        doneProductsTable = new JTable();

        //======== this ========

        //======== panel ========
        {

            // JFormDesigner evaluation mark
            panel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel.getBorder())); panel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel.setLayout(new MigLayout(
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
            panel.add(label1, "cell 0 0,alignx right,growx 0");
            panel.add(nameField, "cell 1 0");

            //---- label2 ----
            label2.setText("Megrendel\u0151");
            panel.add(label2, "cell 0 1,alignx right,growx 0");
            panel.add(costumerField, "cell 1 1");

            //---- label3 ----
            label3.setText("\u00c1r");
            panel.add(label3, "cell 0 2,alignx right,growx 0");
            panel.add(priceField, "cell 1 2");

            //---- label4 ----
            label4.setText("Rendel\u00e9s d\u00e1tuma");
            panel.add(label4, "cell 0 3,alignx right,growx 0");

            //---- orderDateSpinner ----
            orderDateSpinner.setModel(new SpinnerDateModel());
            panel.add(orderDateSpinner, "cell 1 3");

            //---- label5 ----
            label5.setText("Hat\u00e1rid\u0151");
            panel.add(label5, "cell 0 4,alignx right,growx 0");

            //---- endDateSpinner ----
            endDateSpinner.setModel(new SpinnerDateModel());
            endDateSpinner.setEnabled(false);
            panel.add(endDateSpinner, "cell 1 4");

            //---- doneCheckBox ----
            doneCheckBox.setText("Teljes\u00edtve");
            doneCheckBox.setEnabled(false);
            panel.add(doneCheckBox, "cell 1 5");

            //---- exchangeButton ----
            exchangeButton.setText("Lez\u00e1r\u00e1s");
            panel.add(exchangeButton, "cell 0 6");

            //---- saveButton ----
            saveButton.setText("Ment\u00e9s");
            panel.add(saveButton, "cell 1 6");
        }
        addTab("Rendel\u00e9s", panel);

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[50,grow,fill]" +
                "[100,grow,fill]" +
                "[20,grow,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label6 ----
            label6.setText("Rendel\u00e9si t\u00e9tel");
            panel1.add(label6, "cell 0 0");
            panel1.add(productTypeField, "cell 1 0");

            //---- browseOrderButton ----
            browseOrderButton.setText(">>");
            panel1.add(browseOrderButton, "cell 2 0");

            //---- label7 ----
            label7.setText("Mennyis\u00e9g (kg)");
            panel1.add(label7, "cell 0 1");

            //---- orderWeightSpinner ----
            orderWeightSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
            panel1.add(orderWeightSpinner, "cell 1 1 2 1");

            //---- addOrderButton ----
            addOrderButton.setText("+");
            panel1.add(addOrderButton, "cell 1 2");

            //---- deleteOrderButton ----
            deleteOrderButton.setText("-");
            panel1.add(deleteOrderButton, "cell 2 2");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(orderdProductsTable);
            }
            panel1.add(scrollPane1, "cell 0 3 3 1");
        }
        addTab("Rendel\u00e9si t\u00e9telek", panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[50,grow,fill]" +
                "[100,grow,fill]" +
                "[20,grow,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label8 ----
            label8.setText("Legy\u00e1rtott t\u00e9tel");
            panel2.add(label8, "cell 0 0");
            panel2.add(productField, "cell 1 0");

            //---- browseProductButton ----
            browseProductButton.setText(">>");
            panel2.add(browseProductButton, "cell 2 0");

            //---- label9 ----
            label9.setText("Mennyis\u00e9g (kg)");
            panel2.add(label9, "cell 0 1");

            //---- productWeightSpinner ----
            productWeightSpinner.setModel(new SpinnerNumberModel(1, 0, null, 1));
            panel2.add(productWeightSpinner, "cell 1 1 2 1");

            //---- addProdutButton ----
            addProdutButton.setText("+");
            panel2.add(addProdutButton, "cell 1 2");

            //---- deleteProductButton ----
            deleteProductButton.setText("-");
            panel2.add(deleteProductButton, "cell 2 2");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(doneProductsTable);
            }
            panel2.add(scrollPane2, "cell 0 3 3 1");
        }
        addTab("Legy\u00e1rtott term\u00e9kek", panel2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JPanel panel;
    private JLabel label1;
    private JTextField nameField;
    private JLabel label2;
    private JTextField costumerField;
    private JLabel label3;
    private JTextField priceField;
    private JLabel label4;
    private JSpinner orderDateSpinner;
    private JLabel label5;
    private JSpinner endDateSpinner;
    private JCheckBox doneCheckBox;
    private JButton exchangeButton;
    private JButton saveButton;
    private JPanel panel1;
    private JLabel label6;
    private JTextField productTypeField;
    private JButton browseOrderButton;
    private JLabel label7;
    private JSpinner orderWeightSpinner;
    private JButton addOrderButton;
    private JButton deleteOrderButton;
    private JScrollPane scrollPane1;
    private JTable orderdProductsTable;
    private JPanel panel2;
    private JLabel label8;
    private JTextField productField;
    private JButton browseProductButton;
    private JLabel label9;
    private JSpinner productWeightSpinner;
    private JButton addProdutButton;
    private JButton deleteProductButton;
    private JScrollPane scrollPane2;
    private JTable doneProductsTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
