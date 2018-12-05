/*
 * Created by JFormDesigner on Mon Nov 05 22:11:25 CET 2018
 */

package GUI.Panes.orders;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.DAO;
import net.miginfocom.swing.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dominik
 */
public class OrderPanel extends JTabbedPane {
    public OrderPanel() {
        initComponents();
        setAddProductTypeButton();
        setAddProductButton();
        setDeleteProductTypeButton();
        setDeleteProductButton();
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
        saveButton = new JButton();
        panel1 = new JPanel();
        label6 = new JLabel();
        productTypeField = new JTextField();
        browseProductTypeButton = new JButton();
        label7 = new JLabel();
        productTypeWeightField = new JTextField();
        addProductTypeButton = new JButton();
        deleteProductTypeButton = new JButton();
        scrollPane1 = new JScrollPane();
        productTypeTable = new JTable();
        panel2 = new JPanel();
        label8 = new JLabel();
        productField = new JTextField();
        browseProductButton = new JButton();
        label9 = new JLabel();
        productWeightField = new JTextField();
        addProductButton = new JButton();
        deleteProductButton = new JButton();
        scrollPane2 = new JScrollPane();
        productTable = new JTable();

        //======== this ========

        //======== panel ========
        {

            // JFormDesigner evaluation mark
            panel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
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
            panel.add(endDateSpinner, "cell 1 4");

            //---- doneCheckBox ----
            doneCheckBox.setText("Teljes\u00edtve");
            panel.add(doneCheckBox, "cell 1 5");

            //---- saveButton ----
            saveButton.setText("Ment\u00e9s");
            panel.add(saveButton, "cell 0 6 2 1");
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

            //---- browseProductTypeButton ----
            browseProductTypeButton.setText(">>");
            panel1.add(browseProductTypeButton, "cell 2 0");

            //---- label7 ----
            label7.setText("Mennyis\u00e9g (kg)");
            panel1.add(label7, "cell 0 1");
            panel1.add(productTypeWeightField, "cell 1 1 2 1");

            //---- addProductTypeButton ----
            addProductTypeButton.setText("+");
            panel1.add(addProductTypeButton, "cell 1 2");

            //---- deleteProductTypeButton ----
            deleteProductTypeButton.setText("-");
            panel1.add(deleteProductTypeButton, "cell 2 2");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(productTypeTable);
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
            panel2.add(productWeightField, "cell 1 1 2 1");

            //---- addProductButton ----
            addProductButton.setText("+");
            panel2.add(addProductButton, "cell 1 2");

            //---- deleteProductButton ----
            deleteProductButton.setText("-");
            panel2.add(deleteProductButton, "cell 2 2");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(productTable);
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
    private JButton saveButton;
    private JPanel panel1;
    private JLabel label6;
    private JTextField productTypeField;
    private JButton browseProductTypeButton;
    private JLabel label7;
    private JTextField productTypeWeightField;
    private JButton addProductTypeButton;
    private JButton deleteProductTypeButton;
    private JScrollPane scrollPane1;
    private JTable productTypeTable;
    private JPanel panel2;
    private JLabel label8;
    private JTextField productField;
    private JButton browseProductButton;
    private JLabel label9;
    private JTextField productWeightField;
    private JButton addProductButton;
    private JButton deleteProductButton;
    private JScrollPane scrollPane2;
    private JTable productTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private int id = 0;
    private int tempProductTypeId = 0;
    private int tempProductId = 0;
    DAO dao = new DAO();
    List<Map> productTypeList = new ArrayList<>();
    List<Map> productList = new ArrayList<>();

    public void setAddProductTypeButton() {
        addProductTypeButton.addActionListener(e -> {
            if (tempProductTypeId != 0) {
                Map tempMap = new HashMap();
                tempMap.put("id", tempProductTypeId);
                tempMap.put("name", productTypeField.getText());
                tempMap.put("value", Double.valueOf(productTypeWeightField.getText().replace(",", ".")));
                productTypeList.add(tempMap);
                setProductTypes(productTypeList);
                tempProductTypeId = 0;
                productTypeField.setText("");
                productTypeWeightField.setText("");
            }
        });
    }


    public void setAddProductButton() {
        addProductButton.addActionListener(e -> {
            if (tempProductId != 0) {
                Map tempMap = new HashMap();
                tempMap.put("id", tempProductId);
                tempMap.put("name", productField.getText());
                tempMap.put("value", Double.valueOf(productWeightField.getText().replace(",", ".")));
                productList.add(tempMap);
                setProducts(productList);
                tempProductId = 0;
                productField.setText("");
                productWeightField.setText("");
            }
        });
    }

    public void setDeleteProductTypeButton() {
        deleteProductTypeButton.addActionListener(e -> {
            for (int i = 0; i < productTypeList.size(); i++) {
                if (productTypeList.get(i).get("id") == productTypeTable.getModel().getValueAt(productTypeTable.getSelectedRow(), 0)) {
                    productTypeList.remove(i);
                }
            }
            setProductTypes(productTypeList);
        });
    }

    public void setDeleteProductButton() {
        deleteProductButton.addActionListener(e -> {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).get("id") == productTable.getModel().getValueAt(productTable.getSelectedRow(), 0)) {
                    productList.remove(i);
                }
            }
            setProducts(productList);
        });
    }

    public void setSave(ActionListener actionListener) {
        saveButton.addActionListener(actionListener);
    }

    public void setBrowseProductTypeButton(ActionListener actionListener) {
        browseProductTypeButton.addActionListener(actionListener);
    }

    public void setBrowseProductButton(ActionListener actionListener) {
        browseProductButton.addActionListener(actionListener);
    }

    public Map getValues() {
        Map values = new HashMap();
        try {
            values.put("id", id);
            values.put("name", nameField.getText());
            values.put("costumer", costumerField.getText());
            values.put("price", Double.parseDouble(priceField.getText().replace(",",".")));
            values.put("orderDate", orderDateSpinner.getValue());
            values.put("endDate", endDateSpinner.getValue());
            values.put("done", doneCheckBox.isSelected());
            values.put("productTypes", productTypeList);
            values.put("products", productList);
        } catch (Exception e) {
            System.out.println(e);
        }
        return values;
    }

    public void setId(int id) {
        this.id = id;
        setTexts(dao.getOrder(id));
        setProductTypes(dao.getProductTypeByOrderId(id));
        productTypeList = dao.getProductTypeByOrderId(id);
        setProducts(dao.getProductByOrderId(id));
        productList = dao.getProductByOrderId(id);
    }

    public void setTexts(Map values) {
        nameField.setText((String) values.get("name"));
        costumerField.setText(String.valueOf(values.get("costumer")));
        priceField.setText(String.valueOf(values.get("price")));
        orderDateSpinner.setValue(values.get("orderDate"));
        endDateSpinner.setValue(values.get("endDate"));
        doneCheckBox.setSelected((Boolean) values.get("done"));
    }

    public void setProductTypes(List<Map> list) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Terméktípus", "Mennyiség (kg)"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).get("id"), list.get(i).get("name"), list.get(i).get("value")});
        }
        productTypeTable.setModel(model);
        productTypeTable.removeColumn(productTypeTable.getColumnModel().getColumn(0));
    }

    public void setProducts(List<Map> list) {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Terméknév", "Mennyiség (kg)"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).get("id"), list.get(i).get("name"), list.get(i).get("value")});
        }
        productTable.setModel(model);
        productTable.removeColumn(productTable.getColumnModel().getColumn(0));
    }

    public void setSelectedProductTypeItem(Map values) {
        productTypeField.setText((String) values.get("name"));
        tempProductTypeId = (int) values.get("id");
    }

    public void setSelectedProductItem(Map values) {
        productField.setText((String) values.get("name"));
        tempProductId = (int) values.get("id");
    }

}
