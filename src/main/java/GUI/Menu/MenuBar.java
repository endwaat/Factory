package GUI.Menu;

import javax.swing.*;
import java.awt.event.ActionListener;

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

        fileMenu = new JMenu("File");
        this.add(fileMenu);
        JMenuItem profile = new JMenuItem("Profil");
        JMenuItem logout = new JMenuItem("Kijelentkezés");
        JMenuItem exit = new JMenuItem("Kilépés");
        fileMenu.add(profile);
        fileMenu.add(logout);
        fileMenu.add(exit);

        storageMenu = new JMenu("Raktár");
        this.add(storageMenu);
        JMenu ingredients = new JMenu("Alapanyag");
        JMenuItem newIngredient = new JMenuItem("Új alapanyag");
        JMenuItem listIngredient = new JMenuItem("Alapanyagok listázása");
        ingredients.add(newIngredient);
        ingredients.add(listIngredient);
        JMenu ingredientType = new JMenu("Alapanyag típus");
        JMenuItem newIngredienType = new JMenuItem("Új alapanyag típus");
        JMenuItem listIngredienType = new JMenuItem("Alapanyag típusok listázása");
        ingredientType.add(newIngredienType);
        ingredientType.add(listIngredienType);
        storageMenu.add(ingredients);
        storageMenu.add(ingredientType);

        productMenu = new JMenu("Termék");
        this.add(productMenu);
        JMenu productType = new JMenu("Termék típus");
        JMenuItem newPoduct = new JMenuItem("Új terméktípus");
        JMenuItem listPoducts = new JMenuItem("Terméktípusok listázása");
        productType.add(newPoduct);
        productType.add(listPoducts);
        JMenuItem production = new JMenuItem("Gyártás");
        JMenuItem completedProduction = new JMenuItem("Gyártott termékek");
        productMenu.add(productType);
        productMenu.add(production);
        productMenu.add(completedProduction);

        workerMenu = new JMenu("Dolgozó");
        this.add(workerMenu);
        JMenu worker = new JMenu("Dolgozó");
        JMenuItem newWorker = new JMenuItem("Új dolgozó");
        JMenuItem listWorkers = new JMenuItem("Dolgozók listázása");
        worker.add(newWorker);
        worker.add(listWorkers);
        JMenu attendance = new JMenu("Jelenlét");
        JMenuItem newAttendance = new JMenuItem("Új jelenlét");
        JMenuItem listAttendance = new JMenuItem("Jelenléti lista");
        attendance.add(newAttendance);
        attendance.add(listAttendance);
        workerMenu.add(worker);
        workerMenu.add(attendance);

        allergenMenu = new JMenu("Allergének");
        this.add(allergenMenu);
        JMenuItem newAllergent = new JMenuItem("Új allergén");
        JMenuItem listAllergents = new JMenuItem("Allergének listázása");
        allergenMenu.add(newAllergent);
        allergenMenu.add(listAllergents);

        machineMenu = new JMenu("Gépek");
        this.add(machineMenu);
        JMenuItem newMachine = new JMenuItem("Új gép");
        JMenuItem listMachines = new JMenuItem("Gépek listázása");
        machineMenu.add(newMachine);
        machineMenu.add(listMachines);

        orderMenu = new JMenu("Rendelés");
        this.add(orderMenu);
        JMenu order = new JMenu("Rendelés");
        JMenuItem newOrder = new JMenuItem("Új rendelés");
        JMenuItem listorders = new JMenuItem("Rendelések listázása");
        order.add(newOrder);
        order.add(listorders);
        JMenu supplier = new JMenu("Szállítók");
        JMenuItem newSupplier = new JMenuItem("Új szállító");
        JMenuItem listSupplier = new JMenuItem("Szállítók listázása");
        supplier.add(newSupplier);
        supplier.add(listSupplier);
        orderMenu.add(order);
        orderMenu.add(supplier);

        adminMenu = new JMenu("Admin");
        this.add(adminMenu);
        JMenuItem newUser = new JMenuItem("Új felhasználó");
        JMenuItem listUser = new JMenuItem("Felhasználók listázása");
        adminMenu.add(newUser);
        adminMenu.add(listUser);
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public JMenu getStorageMenu() {
        return storageMenu;
    }

    public void setStorageMenu(JMenu storageMenu) {
        this.storageMenu = storageMenu;
    }

    public JMenu getProductMenu() {
        return productMenu;
    }

    public void setProductMenu(JMenu productMenu) {
        this.productMenu = productMenu;
    }

    public JMenu getWorkerMenu() {
        return workerMenu;
    }

    public void setWorkerMenu(JMenu workerMenu) {
        this.workerMenu = workerMenu;
    }

    public JMenu getAllergenMenu() {
        return allergenMenu;
    }

    public void setAllergenMenu(JMenu allergenMenu) {
        this.allergenMenu = allergenMenu;
    }

    public JMenu getMachineMenu() {
        return machineMenu;
    }

    public void setMachineMenu(JMenu machineMenu) {
        this.machineMenu = machineMenu;
    }

    public JMenu getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(JMenu orderMenu) {
        this.orderMenu = orderMenu;
    }

    public JMenu getAdminMenu() {
        return adminMenu;
    }

    public void setAdminMenu(JMenu adminMenu) {
        this.adminMenu = adminMenu;
    }

    public void addListener(String menu, ActionListener actionListener) {

        switch (menu) {
            case "profile":
                ((JMenuItem) fileMenu.getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "logout":
                ((JMenuItem) fileMenu.getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "close":
                ((JMenuItem) fileMenu.getMenuComponent(2)).addActionListener(actionListener);
                break;
            case "newAllergens":
                ((JMenuItem) allergenMenu.getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listAllergens":
                ((JMenuItem) allergenMenu.getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "newUser":
                ((JMenuItem) adminMenu.getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listUsers":
                ((JMenuItem) adminMenu.getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "newMachine":
                ((JMenuItem) machineMenu.getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listMachine":
                ((JMenuItem) machineMenu.getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "newIngredientType":
                ((JMenuItem) ((JMenu) storageMenu.getMenuComponent(1)).getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listIngredientType":
                ((JMenuItem) ((JMenu) storageMenu.getMenuComponent(1)).getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "newIngredient":
                ((JMenuItem) ((JMenu) storageMenu.getMenuComponent(0)).getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listIngredient":
                ((JMenuItem) ((JMenu) storageMenu.getMenuComponent(0)).getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "newSupplier":
                ((JMenuItem) ((JMenu) orderMenu.getMenuComponent(1)).getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listSupplier":
                ((JMenuItem) ((JMenu) orderMenu.getMenuComponent(1)).getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "newWorker":
                ((JMenuItem) ((JMenu) workerMenu.getMenuComponent(0)).getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listWorker":
                ((JMenuItem) ((JMenu) workerMenu.getMenuComponent(0)).getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "newAttendance":
                ((JMenuItem) ((JMenu) workerMenu.getMenuComponent(1)).getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listAttendance":
                ((JMenuItem) ((JMenu) workerMenu.getMenuComponent(1)).getMenuComponent(1)).addActionListener(actionListener);
                break;
            case "newProductType":
                ((JMenuItem) ((JMenu) productMenu.getMenuComponent(0)).getMenuComponent(0)).addActionListener(actionListener);
                break;
            case "listProductType":
                ((JMenuItem) ((JMenu) productMenu.getMenuComponent(0)).getMenuComponent(1)).addActionListener(actionListener);
                break;
        }
    }
}
