/*
 * Created by JFormDesigner on Tue Nov 27 22:56:26 CET 2018
 */

package GUI.Panes.product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.DAO;
import bean.Item;
import net.miginfocom.swing.*;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.*;

/**
 * @author Dominik
 */
public class ProductPanel extends JTabbedPane {
    public ProductPanel() {
        initComponents();
        fillCombobox();
        setAddIngredientButton();
        setDeleteIngredientButton();
        setCalculateButton();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dominik
        dataPanel = new JPanel();
        label6 = new JLabel();
        nameField = new JTextField();
        label1 = new JLabel();
        productTypeCombo = new JComboBox();
        label3 = new JLabel();
        dateSpinner = new JSpinner();
        label2 = new JLabel();
        weightSpinner = new JSpinner();
        label7 = new JLabel();
        costField = new JTextField();
        label8 = new JLabel();
        valueField = new JTextField();
        label9 = new JLabel();
        expireSpinner = new JSpinner();
        calculateButton = new JButton();
        saveButton = new JButton();
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
                "[]" +
                "[]" +
                "[50]" +
                "[]" +
                "[161]"));

            //---- label6 ----
            label6.setText("Term\u00e9k neve");
            dataPanel.add(label6, "cell 0 0,alignx right,growx 0");
            dataPanel.add(nameField, "cell 1 0");

            //---- label1 ----
            label1.setText("Term\u00e9k t\u00edpus");
            dataPanel.add(label1, "cell 0 1,alignx right,growx 0");
            dataPanel.add(productTypeCombo, "cell 1 1");

            //---- label3 ----
            label3.setText("K\u00e9sz\u00edt\u00e9s d\u00e1tuma");
            dataPanel.add(label3, "cell 0 2,alignx right,growx 0");

            //---- dateSpinner ----
            dateSpinner.setModel(new SpinnerDateModel());
            dataPanel.add(dateSpinner, "cell 1 2");

            //---- label2 ----
            label2.setText("Mennyis\u00e9g (kg)");
            dataPanel.add(label2, "cell 0 3,alignx right,growx 0");

            //---- weightSpinner ----
            weightSpinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
            dataPanel.add(weightSpinner, "cell 1 3");

            //---- label7 ----
            label7.setText("K\u00f6lt\u00e9sg (Ft)");
            dataPanel.add(label7, "cell 0 4,alignx right,growx 0");
            dataPanel.add(costField, "cell 1 4");

            //---- label8 ----
            label8.setText("\u00c9rt\u00e9k (Ft)");
            dataPanel.add(label8, "cell 0 5,alignx right,growx 0");
            dataPanel.add(valueField, "cell 1 5");

            //---- label9 ----
            label9.setText("Lej\u00e1rati D\u00e1tom");
            dataPanel.add(label9, "cell 0 6,alignx right,growx 0");

            //---- expireSpinner ----
            expireSpinner.setModel(new SpinnerDateModel());
            dataPanel.add(expireSpinner, "cell 1 6");

            //---- calculateButton ----
            calculateButton.setText("Kalkul\u00e1l\u00e1s");
            dataPanel.add(calculateButton, "cell 0 7,aligny bottom,growy 0");

            //---- saveButton ----
            saveButton.setText("Gy\u00e1rt\u00e1s");
            dataPanel.add(saveButton, "cell 1 7,aligny bottom,growy 0");
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
    private JLabel label6;
    private JTextField nameField;
    private JLabel label1;
    private JComboBox productTypeCombo;
    private JLabel label3;
    private JSpinner dateSpinner;
    private JLabel label2;
    private JSpinner weightSpinner;
    private JLabel label7;
    private JTextField costField;
    private JLabel label8;
    private JTextField valueField;
    private JLabel label9;
    private JSpinner expireSpinner;
    private JButton calculateButton;
    private JButton saveButton;
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
    private int id = 0;
    private double tempValue = 0;
    private int tempIngredientId = 0;
    private int tempIngredientTypeId = 0;
    DAO dao = new DAO();
    List<Map> ingredientList = new ArrayList<>();

    public void setAddIngredientButton() {
        addIngredientButton.addActionListener(e -> {
            if(tempIngredientId != 0) {
                double maxingred = 0;
                for(int i = 0; i < ingredientList.size(); i++){
                    maxingred += (double) ingredientList.get(i).get("value");
                }
                maxingred += Double.valueOf(weightField.getText().replace(",","."));
                if(maxingred <= (int) weightSpinner.getValue()) {
                    Map tempMap = new HashMap();
                    tempMap.put("id", tempIngredientId);
                    tempMap.put("ingredienType", tempIngredientTypeId);
                    tempMap.put("name", ingredientField.getText());
                    tempMap.put("value", Double.valueOf(weightField.getText().replace(",",".")));
                    tempMap.put("itemValue", Double.valueOf(weightField.getText().replace(",",".")) * tempValue);
                    ingredientList.add(tempMap);
                    setIngredients(ingredientList);
                    tempValue = 0;
                    tempIngredientId = 0;
                    ingredientField.setText("");
                    weightField.setText("");
                }else{
                    JOptionPane.showMessageDialog(this,
                            dao.translate("OVER_100") ,
                            "ERROR",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public void setCalculateButton(){
        calculateButton.addActionListener(e -> {
            int prodTypeId = ((Item)productTypeCombo.getSelectedItem()).getId();
            Map prodTypeMap = dao.getProductType(prodTypeId);
            List<Map> recipe = dao.getIngredientlistByproductId(prodTypeId);
            List<Map> actualRecipe = new ArrayList();
            for(int i = 0; i < recipe.size(); i++){
                Map temp = recipe.get(i);
                temp.put("value", (double) (int) weightSpinner.getValue() * ((double) recipe.get(i).get("value")/100)   );
                actualRecipe.add(temp);
            }
            setReceipt(actualRecipe);
            List<Map> tempIngredientList = dao.getBestIngredients(actualRecipe);
            if(tempIngredientList.size() > 0){
                ingredientList = tempIngredientList;
                setIngredients(ingredientList);
            }else{
                JOptionPane.showMessageDialog(this,
                        dao.translate("NO_BEST_INGREDIENT"),
                        "ERROR",
                        JOptionPane.PLAIN_MESSAGE);
            }
            double cost = 0;
            for(int i = 0;i < ingredientList.size();i++){
                cost += (double) ingredientList.get(i).get("itemValue");
            }
            costField.setText(String.valueOf(cost));
            valueField.setText(String.valueOf(cost * 1.1));
        });
    }

    public void setDeleteIngredientButton() {
        deleteIngredientButton.addActionListener(e -> {
            for(int i = 0; i < ingredientList.size(); i++){
                if(ingredientList.get(i).get("id") == table2.getModel().getValueAt(table2.getSelectedRow(),0)){
                    ingredientList.remove(i);
                }
            }
            setIngredients(ingredientList);
        });
    }

    public void fillCombobox(){
        DAO dao = new DAO();
        List<Map> values = dao.getProductTypeList();
        for(int i = 0; i < values.size(); i++){
            productTypeCombo.addItem(new Item((Integer) (values.get(i)).get("id"),(String) (values.get(i)).get("name")));
        }
    }

    public void setSave(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }

    public void setBrowseIngredientButton(ActionListener actionListener) {
        browseIngredientButton.addActionListener(actionListener);
    }

    public boolean beforeSave(){
        double maxIngred = 0;
        for(int i = 0; i < ingredientList.size(); i++){
            maxIngred += (double) ingredientList.get(i).get("value");
        }
        if((int) weightSpinner.getValue() != maxIngred){
            return false;
        }
        return true;
    }

    public Map getValues() {
        Map values = new HashMap();
        try {
            values.put("id", id);
            values.put("name", nameField.getText());
            values.put("productType", ((Item)productTypeCombo.getSelectedItem()).getId());
            values.put("productionDate", dateSpinner.getValue());
            values.put("weight", weightSpinner.getValue());
            values.put("cost", Double.valueOf(costField.getText()));
            values.put("value", Double.valueOf(valueField.getText()));
            values.put("expireDate", expireSpinner.getValue());
            values.put("ingredients", ingredientList);
        } catch (Exception e) {
            System.out.println(e);
        }
        return values;
    }

    public void setId(int id) {
        this.id = id;
        //TODO LOAD EVERTHING
    }

    public void setReceipt(List<Map> list) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Alapanyag","Mennyiség (kg)"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).get("id"),list.get(i).get("name"), list.get(i).get("value")});
        }
        table1.setModel(model);
        table1.removeColumn(table1.getColumnModel().getColumn(0));
    }

    public void setIngredients(List<Map> list) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Alapanyag","Mennyiség (kg)"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).get("id"),list.get(i).get("name"), list.get(i).get("value")});
        }
        table2.setModel(model);
        table2.removeColumn(table2.getColumnModel().getColumn(0));
    }

    public void setSelectedIngredientItem(Map values){
        ingredientField.setText((String) values.get("name"));
        tempIngredientId = (int) values.get("id");
        tempValue = (double) values.get("itemValue");
    }
}
