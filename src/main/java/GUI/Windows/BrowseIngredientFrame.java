package GUI.Windows;

import Database.DAO;
import GUI.Panes.browse.BrowsePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrowseIngredientFrame extends JInternalFrame {
    private BrowsePanel browsePanel;

    public BrowseIngredientFrame(String title, boolean resizable, boolean closable,
                                 boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
            this.setBounds(10, 10, 500, 320);
        this.setFrameIcon(new ImageIcon("frame:/gfg.jpg"));
        browsePanel = new BrowsePanel();
        this.setVisible(true);
        this.add(browsePanel);
    }
    public void setSelect(ActionListener actionListener){
        browsePanel.setSelectButton(actionListener);
    }

    public void setTableValues(List<Map> list){
        DAO dao = new DAO();
        List<Map> temp = dao.getIngredientListForBrowse();
        Map types = new HashMap();
        for(int i = 0; i < temp.size(); i++){
            types.put(temp.get(i).get("id"),temp.get(i).get("name"));
        }
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Alapanyag név", "Alapanyag típus", "Beérkezett", "Lejárati dátum","Mennyiség (kg)","Ár"}, 0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{
                    list.get(i).get("id"),
                    list.get(i).get("name"),
                    temp.get(i).get("type"),
                    list.get(i).get("arrived"),
                    list.get(i).get("expire"),
                    list.get(i).get("weight"),
                    list.get(i).get("value")
            });
        }
        browsePanel.getTable1().setModel(model);
        browsePanel.getTable1().removeColumn(browsePanel.getTable1().getColumnModel().getColumn(0));
    }

    public Map getSelectedItem(){
        Map values = new HashMap();
        values.put("id",browsePanel.getTable1().getModel().getValueAt(browsePanel.getTable1().getSelectedRow(),0));
        values.put("name",browsePanel.getTable1().getModel().getValueAt(browsePanel.getTable1().getSelectedRow(),1));
        values.put("itemValue",browsePanel.getTable1().getModel().getValueAt(browsePanel.getTable1().getSelectedRow(),6));
        return  values;
    }

}
