/*
 * Created by JFormDesigner on Sun Nov 18 22:49:00 CET 2018
 */

package GUI.Panes.storage;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Dominik
 */
public class MadeProductsListPanel extends JPanel {
    public MadeProductsListPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        scrollPane1 = new JScrollPane();
        madeProductTable = new JTable();
        button1 = new JButton();
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
            "[grow,fill]" +
            "[grow,fill]",
            // rows
            "[330]" +
            "[]"));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(madeProductTable);
        }
        add(scrollPane1, "cell 0 0 2 1");

        //---- button1 ----
        button1.setText("T\u00f6rl\u00e9s");
        add(button1, "cell 0 1");

        //---- button2 ----
        button2.setText("Szerkeszt\u00e9s");
        add(button2, "cell 1 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JScrollPane scrollPane1;
    private JTable madeProductTable;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
