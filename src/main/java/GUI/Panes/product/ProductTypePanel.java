/*
 * Created by JFormDesigner on Tue Nov 27 22:38:22 CET 2018
 */

package GUI.Panes.product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.DAO;
import bean.Item;
import net.miginfocom.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dominik
 */
public class ProductTypePanel extends JTabbedPane {
    public ProductTypePanel() {
        initComponents();
        fillCombobox();
        setAddIngredientButton();
        setDeleteIngredientButton();
        setAddMachineButton();
        setDeleteMachineButton();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        asd = new JPanel();
        label1 = new JLabel();
        nameField = new JTextField();
        label2 = new JLabel();
        allergenCombo = new JComboBox();
        label3 = new JLabel();
        weightField = new JTextField();
        label4 = new JLabel();
        productionTimeField = new JTextField();
        label5 = new JLabel();
        valueField = new JTextField();
        label6 = new JLabel();
        costField = new JTextField();
        saveButton = new JButton();
        panel1 = new JPanel();
        label7 = new JLabel();
        ingredientTypeField = new JTextField();
        browseIngredientButton = new JButton();
        label8 = new JLabel();
        ingredientweightField = new JTextField();
        addIngredientButton = new JButton();
        deleteIngredientButton = new JButton();
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
            asd.add(nameField, "cell 1 0");

            //---- label2 ----
            label2.setText("Allerg\u00e9n");
            asd.add(label2, "cell 0 1");
            asd.add(allergenCombo, "cell 1 1");

            //---- label3 ----
            label3.setText("Mennyis\u00e9g (kg)");
            asd.add(label3, "cell 0 2");
            asd.add(weightField, "cell 1 2");

            //---- label4 ----
            label4.setText("Elk\u00e9sz\u00edt\u00e9si Id\u0151 (perc)");
            asd.add(label4, "cell 0 3");
            asd.add(productionTimeField, "cell 1 3");

            //---- label5 ----
            label5.setText("\u00c1r (elad\u00e1si)");
            asd.add(label5, "cell 0 4");
            asd.add(valueField, "cell 1 4");

            //---- label6 ----
            label6.setText("Gy\u00e1rt\u00e1si \u00e1r");
            asd.add(label6, "cell 0 5");
            asd.add(costField, "cell 1 5");

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
            label8.setText("Mennyis\u00e9g (%)");
            panel1.add(label8, "cell 0 1");
            panel1.add(ingredientweightField, "cell 1 1 2 1");

            //---- addIngredientButton ----
            addIngredientButton.setText("+");
            panel1.add(addIngredientButton, "cell 1 2");

            //---- deleteIngredientButton ----
            deleteIngredientButton.setText("-");
            panel1.add(deleteIngredientButton, "cell 2 2");

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
    private JTextField nameField;
    private JLabel label2;
    private JComboBox allergenCombo;
    private JLabel label3;
    private JTextField weightField;
    private JLabel label4;
    private JTextField productionTimeField;
    private JLabel label5;
    private JTextField valueField;
    private JLabel label6;
    private JTextField costField;
    private JButton saveButton;
    private JPanel panel1;
    private JLabel label7;
    private JTextField ingredientTypeField;
    private JButton browseIngredientButton;
    private JLabel label8;
    private JTextField ingredientweightField;
    private JButton addIngredientButton;
    private JButton deleteIngredientButton;
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
    private int id = 0;
    private int tempIngredientTypeId = 0;
    private int tempMachineId = 0;
    DAO dao = new DAO();
    List<Map> ingredientTypeList = new ArrayList<>();
    List<Map> machineList = new ArrayList<>();

    public void setAddIngredientButton() {
        addIngredientButton.addActionListener(e -> {
            if(tempIngredientTypeId != 0) {
                double maxingred = 0;
                for(int i = 0; i < ingredientTypeList.size(); i++){
                    maxingred += (double) ingredientTypeList.get(i).get("value");
                }
                maxingred += Double.valueOf(ingredientweightField.getText().replace(",","."));
                if(maxingred <= 100) {
                    Map tempMap = new HashMap();
                    tempMap.put("id", tempIngredientTypeId);
                    tempMap.put("name", ingredientTypeField.getText());
                    tempMap.put("value", Double.valueOf(ingredientweightField.getText().replace(",",".")));
                    ingredientTypeList.add(tempMap);
                    setIngredients(ingredientTypeList);
                    tempIngredientTypeId = 0;
                    ingredientTypeField.setText("");
                    ingredientweightField.setText("");
                }else{
                    JOptionPane.showMessageDialog(this,
                            dao.translate("OVER_100") ,
                            "ERROR",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public void setDeleteIngredientButton() {
        deleteIngredientButton.addActionListener(e -> {
            for(int i = 0; i < ingredientTypeList.size(); i++){
                if(ingredientTypeList.get(i).get("id") == table1.getModel().getValueAt(table1.getSelectedRow(),0)){
                    ingredientTypeList.remove(i);
                }
            }
            setIngredients(ingredientTypeList);
        });
    }

    public void setAddMachineButton() {
        addMachineButton.addActionListener(e -> {
            if(tempMachineId != 0) {
                Map tempMap = new HashMap();
                tempMap.put("id", tempMachineId);
                tempMap.put("name", machineField.getText());
                machineList.add(tempMap);
                setMachines(machineList);
                tempMachineId = 0;
                machineField.setText("");
            }
        });
    }

    public void setDeleteMachineButton() {
        deleteMachineButton.addActionListener(e -> {
            for(int i = 0; i < machineList.size(); i++){
                if(machineList.get(i).get("id") == table2.getModel().getValueAt(table2.getSelectedRow(),0)){
                    machineList.remove(i);
                }
            }
            setMachines(machineList);
        });
    }

    public void fillCombobox(){
        DAO dao = new DAO();
        List<Map> values = dao.getAllergensList();
        for(int i = 0; i < values.size(); i++){
            allergenCombo.addItem(new Item((Integer) (values.get(i)).get("id"),(String) (values.get(i)).get("name")));
        }
    }

    public void setSave(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }
    public void setBrowseIngredientButton(ActionListener actionListener) {
        browseIngredientButton.addActionListener(actionListener);
    }
    public void setBrowseMachineButton(ActionListener actionListener) {
        browseMachineButton.addActionListener(actionListener);
    }

    public Map getValues() {
        Map values = new HashMap();
        try {
            values.put("id", id);
            values.put("name", nameField.getText());
            values.put("allergensType", ((Item)allergenCombo.getSelectedItem()).getId());
            values.put("weight", weightField.getText());
            values.put("productionTime", productionTimeField.getText());
            values.put("value", valueField.getText());
            values.put("cost", costField.getText());
            values.put("ingredients", ingredientTypeList);
            values.put("machines", machineList);
        } catch (Exception e) {
            System.out.println(e);
        }
        return values;
    }

    public void setId(int id) {
        this.id = id;
        setIngredients(dao.getIngredientlistByproductId(id));
        ingredientTypeList = dao.getIngredientlistByproductId(id);
        setMachines(dao.getMachinesByproductId(id));
        machineList = dao.getMachinesByproductId(id);
    }

    public void setTexts(Map values) {
        nameField.setText((String) values.get("name"));
        for(int i = 0; i < allergenCombo.getItemCount(); i++){
            if(((Item)allergenCombo.getItemAt(i)).getId() == (Integer) (values.get("allergensType"))){
                allergenCombo.setSelectedIndex(i);
            }
        }
        weightField.setText(String.valueOf(values.get("weight")));
        productionTimeField.setText(String.valueOf(values.get("productionTime")));
        valueField.setText(String.valueOf(values.get("value")));
        costField.setText(String.valueOf(values.get("cost")));
    }

    public void setIngredients(List<Map> list) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Alapanyagtípus","Mennyiség (%)"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).get("id"),list.get(i).get("name"), list.get(i).get("value")});
        }
        table1.setModel(model);
        table1.removeColumn(table1.getColumnModel().getColumn(0));
    }

    public void setMachines(List<Map> list) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Gép"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).get("id"), list.get(i).get("name")});
        }
        table2.setModel(model);
        table2.removeColumn(table2.getColumnModel().getColumn(0));
    }

    public void setSelectedIngredientTypeItem(Map values){
        ingredientTypeField.setText((String) values.get("name"));
        tempIngredientTypeId = (int) values.get("id");
    }

    public void setSelectedMachineItem(Map values){
        machineField.setText((String) values.get("name"));
        tempMachineId = (int) values.get("id");
    }
}
