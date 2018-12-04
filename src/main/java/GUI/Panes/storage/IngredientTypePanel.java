/*
 * Created by JFormDesigner on Mon Nov 05 22:00:18 CET 2018
 */

package GUI.Panes.storage;

import javax.swing.*;

import Database.DAO;
import bean.Item;
import net.miginfocom.swing.*;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author Dominik
 */
public class IngredientTypePanel extends JPanel {
    public IngredientTypePanel() {
        initComponents();
        fillCombobox();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        label1 = new JLabel();
        nameField = new JTextField();
        label3 = new JLabel();
        allergensComboBox = new JComboBox();
        saveButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[100,grow,fill]" +
            "[100,grow,fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("N\u00e9v");
        add(label1, "cell 0 0,alignx right,growx 0");
        add(nameField, "cell 1 0");

        //---- label3 ----
        label3.setText("Allerg\u00e9n");
        add(label3, "cell 0 1,alignx right,growx 0");
        add(allergensComboBox, "cell 1 1");

        //---- saveButton ----
        saveButton.setText("Ment\u00e9s");
        add(saveButton, "cell 0 2 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dominik
    private JLabel label1;
    private JTextField nameField;
    private JLabel label3;
    private JComboBox allergensComboBox;
    private JButton saveButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private int id = 0;

    public void fillCombobox(){
        DAO dao = new DAO();
        List<Map> values = dao.getAllergensList();
        for(int i = 0; i < values.size(); i++){
            allergensComboBox.addItem(new Item((Integer) (values.get(i)).get("id"),(String) (values.get(i)).get("name")));
        }
    }

    public void setSave(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }

    public Map getValues() {
        Map values = new HashMap();
        try {
            values.put("id", id);
            values.put("name", nameField.getText());
            values.put("allergensType", ((Item)allergensComboBox.getSelectedItem()).getId());
        } catch (Exception e) {
            System.out.println(e);
        }
        return values;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexts(Map values) {
        nameField.setText((String) values.get("name"));
        for(int i = 0; i < allergensComboBox.getItemCount(); i++){
            if(((Item)allergensComboBox.getItemAt(i)).getId() == (Integer) (values.get("allergensType"))){
                allergensComboBox.setSelectedIndex(i);
            }
        }
    }
}
