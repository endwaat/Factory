/*
 * Created by JFormDesigner on Tue Nov 27 22:56:26 CET 2018
 */

package GUI.Panes.product;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Dominik
 */
public class ProductPanel extends JTabbedPane {
    public ProductPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        dataPanel = new JPanel();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label3 = new JLabel();
        spinner1 = new JSpinner();
        label2 = new JLabel();
        spinner2 = new JSpinner();
        button1 = new JButton();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        label4 = new JLabel();
        ingredientField = new JTextField();
        browseIngredientButton = new JButton();
        label5 = new JLabel();
        weightField = new JTextField();
        addIngredientButton = new JButton();
        deleteIngredientButton = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();

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
                "[150,grow,fill]" +
                "[150,grow,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("Term\u00e9k t\u00edpus");
            dataPanel.add(label1, "cell 0 0");
            dataPanel.add(comboBox1, "cell 1 0");

            //---- label3 ----
            label3.setText("K\u00e9sz\u00edt\u00e9s d\u00e1tuma");
            dataPanel.add(label3, "cell 0 1");

            //---- spinner1 ----
            spinner1.setModel(new SpinnerDateModel());
            dataPanel.add(spinner1, "cell 1 1");

            //---- label2 ----
            label2.setText("Mennyis\u00e9g (kg)");
            dataPanel.add(label2, "cell 0 2");

            //---- spinner2 ----
            spinner2.setModel(new SpinnerNumberModel(1, 1, null, 1));
            dataPanel.add(spinner2, "cell 1 2");

            //---- button1 ----
            button1.setText("Gy\u00e1rt\u00e1s");
            dataPanel.add(button1, "cell 0 3 2 1");
        }
        addTab("Term\u00e9k", dataPanel);

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[grow,fill]",
                // rows
                "[grow]"));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1, "cell 0 0");
        }
        addTab("Recept", panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[150,grow,fill]" +
                "[150,grow,fill]" +
                "[150,grow,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[grow]"));

            //---- label4 ----
            label4.setText("Alapanyag");
            panel2.add(label4, "cell 0 0");
            panel2.add(ingredientField, "cell 1 0");

            //---- browseIngredientButton ----
            browseIngredientButton.setText(">>");
            panel2.add(browseIngredientButton, "cell 2 0");

            //---- label5 ----
            label5.setText("Mennyis\u00e9g (kg)");
            panel2.add(label5, "cell 0 1");
            panel2.add(weightField, "cell 1 1 2 1");

            //---- addIngredientButton ----
            addIngredientButton.setText("+");
            panel2.add(addIngredientButton, "cell 1 2");

            //---- deleteIngredientButton ----
            deleteIngredientButton.setText("-");
            panel2.add(deleteIngredientButton, "cell 2 2");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(table2);
            }
            panel2.add(scrollPane2, "cell 0 3 3 1");
        }
        addTab("Alapanyagok", panel2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JPanel dataPanel;
    private JLabel label1;
    private JComboBox comboBox1;
    private JLabel label3;
    private JSpinner spinner1;
    private JLabel label2;
    private JSpinner spinner2;
    private JButton button1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JLabel label4;
    private JTextField ingredientField;
    private JButton browseIngredientButton;
    private JLabel label5;
    private JTextField weightField;
    private JButton addIngredientButton;
    private JButton deleteIngredientButton;
    private JScrollPane scrollPane2;
    private JTable table2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
