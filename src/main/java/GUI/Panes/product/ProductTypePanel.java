/*
 * Created by JFormDesigner on Tue Nov 27 22:38:22 CET 2018
 */

package GUI.Panes.product;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Dominik
 */
public class ProductTypePanel extends JTabbedPane {
    public ProductTypePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        asd = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        label3 = new JLabel();
        textField6 = new JTextField();
        label4 = new JLabel();
        textField5 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        textField3 = new JTextField();
        saveButton = new JButton();
        panel1 = new JPanel();
        label7 = new JLabel();
        ingredientTypeField = new JTextField();
        browseIngredientButton = new JButton();
        label8 = new JLabel();
        ingredientweightField = new JTextField();
        addIngredientButton = new JButton();
        deleteINgredientButton = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        label9 = new JLabel();
        machineField = new JTextField();
        browseMachineButton = new JButton();
        addMachineButton = new JButton();
        deleteMachineButton = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();

        //======== this ========

        //======== asd ========
        {

            // JFormDesigner evaluation mark
            asd.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), asd.getBorder())); asd.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            asd.setLayout(new MigLayout(
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
            label1.setText("Term\u00e9kt\u00edpus neve");
            asd.add(label1, "cell 0 0");
            asd.add(textField1, "cell 1 0");

            //---- label2 ----
            label2.setText("Allerg\u00e9n");
            asd.add(label2, "cell 0 1");
            asd.add(comboBox1, "cell 1 1");

            //---- label3 ----
            label3.setText("Mennyis\u00e9g (kg)");
            asd.add(label3, "cell 0 2");
            asd.add(textField6, "cell 1 2");

            //---- label4 ----
            label4.setText("Elk\u00e9sz\u00edt\u00e9si Id\u0151 (perc)");
            asd.add(label4, "cell 0 3");
            asd.add(textField5, "cell 1 3");

            //---- label5 ----
            label5.setText("\u00c1r (elad\u00e1si)");
            asd.add(label5, "cell 0 4");
            asd.add(textField4, "cell 1 4");

            //---- label6 ----
            label6.setText("Gy\u00e1rt\u00e1si \u00e1r");
            asd.add(label6, "cell 0 5");
            asd.add(textField3, "cell 1 5");

            //---- saveButton ----
            saveButton.setText("Ment\u00e9s");
            asd.add(saveButton, "cell 0 6 2 1");
        }
        addTab("Term\u00e9k t\u00edpus adatai", asd);

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
                "[grow]"));

            //---- label7 ----
            label7.setText("Alapanyag t\u00edpus");
            panel1.add(label7, "cell 0 0");
            panel1.add(ingredientTypeField, "cell 1 0");

            //---- browseIngredientButton ----
            browseIngredientButton.setText(">>");
            panel1.add(browseIngredientButton, "cell 2 0");

            //---- label8 ----
            label8.setText("Mennyis\u00e9g (kg)");
            panel1.add(label8, "cell 0 1");
            panel1.add(ingredientweightField, "cell 1 1 2 1");

            //---- addIngredientButton ----
            addIngredientButton.setText("+");
            panel1.add(addIngredientButton, "cell 1 2");

            //---- deleteINgredientButton ----
            deleteINgredientButton.setText("-");
            panel1.add(deleteINgredientButton, "cell 2 2");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1, "cell 0 3 3 1");
        }
        addTab("Alapanyagok", panel1);

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
                "[grow]"));

            //---- label9 ----
            label9.setText("G\u00e9p");
            panel2.add(label9, "cell 0 0");
            panel2.add(machineField, "cell 1 0");

            //---- browseMachineButton ----
            browseMachineButton.setText(">>");
            panel2.add(browseMachineButton, "cell 2 0");

            //---- addMachineButton ----
            addMachineButton.setText("+");
            panel2.add(addMachineButton, "cell 1 1");

            //---- deleteMachineButton ----
            deleteMachineButton.setText("-");
            panel2.add(deleteMachineButton, "cell 2 1");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(table2);
            }
            panel2.add(scrollPane2, "cell 0 2 3 1");
        }
        addTab("G\u00e9pek", panel2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JPanel asd;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JLabel label3;
    private JTextField textField6;
    private JLabel label4;
    private JTextField textField5;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField3;
    private JButton saveButton;
    private JPanel panel1;
    private JLabel label7;
    private JTextField ingredientTypeField;
    private JButton browseIngredientButton;
    private JLabel label8;
    private JTextField ingredientweightField;
    private JButton addIngredientButton;
    private JButton deleteINgredientButton;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JLabel label9;
    private JTextField machineField;
    private JButton browseMachineButton;
    private JButton addMachineButton;
    private JButton deleteMachineButton;
    private JScrollPane scrollPane2;
    private JTable table2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
