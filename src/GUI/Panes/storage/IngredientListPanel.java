/*
 * Created by JFormDesigner on Sun Nov 18 22:34:54 CET 2018
 */

package GUI.Panes.storage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.DAO;
import net.miginfocom.swing.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

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
    public void setTableValues(List<Map> list) {
        DAO dao = new DAO();
        List<Map> temp = dao.getIngredientTypeList();
        Map types = new HashMap();
        for(int i = 0; i < temp.size(); i++){
            types.put(temp.get(i).get("id"),temp.get(i).get("name"));
        }
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Alapanyag név", "Alapanyag típus", "Beérkezett", "Lejárati dátum","Mennyiség (kg)"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                    list.get(i).get("id"),
                    list.get(i).get("name"),
                    types.get(list.get(i).get("type")),
                    list.get(i).get("arrived"),
                    list.get(i).get("expire"),
                    list.get(i).get("weight")
            });
        }
        ingredientTable.setModel(model);
        ingredientTable.removeColumn(ingredientTable.getColumnModel().getColumn(0));
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public void setScrollPane1(JScrollPane scrollPane1) {
        this.scrollPane1 = scrollPane1;
    }

    public JTable getIngredientTable() {
        return ingredientTable;
    }

    public void setIngredientTable(JTable ingredientTable) {
        this.ingredientTable = ingredientTable;
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
