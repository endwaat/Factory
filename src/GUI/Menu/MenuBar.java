package GUI.Menu;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu storageMenu;
    private JMenu productMenu;
    private JMenu workerMenu;
    private JMenu allergenMenu;
    private JMenu machineMenu;
    private JMenu orderMenu;
    private JMenu adminMenu;

    public MenuBar() {
        super();
        fileMenu = new JMenu("fileMenu");
        this.add(fileMenu);

        storageMenu = new JMenu("storageMenu");
        this.add(storageMenu);

        productMenu = new JMenu("productMenu");
        this.add(productMenu);

        workerMenu = new JMenu("workerMenu");
        this.add(workerMenu);

        allergenMenu = new JMenu("allergenMenu");
        this.add(allergenMenu);

        machineMenu = new JMenu("machineMenu");
        this.add(machineMenu);

        orderMenu = new JMenu("orderMenu");
        this.add(orderMenu);

        adminMenu = new JMenu("adminMenu");
        this.add(adminMenu);
    }
}
