/*
 * Created by JFormDesigner on Tue Nov 27 22:54:19 CET 2018
 */

package GUI.Panes.product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

import java.util.List;
import java.util.Map;

/**
 * @author Dominik
 */
public class ProductTypeListPanel extends JPanel {
    public ProductTypeListPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
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
            "[150,grow,fill]" +
            "[150,grow,fill]",
            // rows
            "[grow]" +
            "[]"));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
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
    private JTable table1;
    private JButton deleteButton;
    private JButton editButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void setTableValues(List<Map> list){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Terméktípus"}, 0);
        for(int i = 0; i < list.size(); i++){
            model.addRow(new Object[]{list.get(i).get("id"), list.get(i).get("name")});
        }
        table1.setModel(model);
        table1.removeColumn(table1.getColumnModel().getColumn(0));
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public void setScrollPane1(JScrollPane scrollPane1) {
        this.scrollPane1 = scrollPane1;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }
}