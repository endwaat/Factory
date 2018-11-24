/*
 * Created by JFormDesigner on Sun Nov 18 22:34:54 CET 2018
 */

package GUI.Panes.storage;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Dominik
 */
public class IngredientListPanel extends JPanel {
    public IngredientListPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        scrollPane1 = new JScrollPane();
        ingredientTable = new JTable();
        deleteButton = new JButton();
        editButton = new JButton();

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
            "[grow,fill]" +
            "[grow,fill]",
            // rows
            "[]" +
            "[]"));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(ingredientTable);
        }
        add(scrollPane1, "cell 0 0 2 1");

        //---- deleteButton ----
        deleteButton.setText("T\u00f6rl\u00e9s");
        add(deleteButton, "cell 0 1");

        //---- editButton ----
        editButton.setText("Szerkeszt\u00e9s");
        add(editButton, "cell 1 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JScrollPane scrollPane1;
    private JTable ingredientTable;
    private JButton deleteButton;
    private JButton editButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
