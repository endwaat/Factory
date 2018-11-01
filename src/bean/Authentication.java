package bean;

public class Authentication {

    boolean storeage;
    boolean products;
    boolean allergen;
    boolean machines;
    boolean orders;
    boolean workers;
    boolean admin;

    public Authentication(boolean storeage, boolean products, boolean allergen, boolean machines, boolean orders, boolean workers, boolean admin) {
        this.storeage = storeage;
        this.products = products;
        this.allergen = allergen;
        this.machines = machines;
        this.orders = orders;
        this.workers = workers;
        this.admin = admin;
    }

    public boolean isStoreage() {
        return storeage;
    }

    public void setStoreage(boolean storeage) {
        this.storeage = storeage;
    }

    public boolean isProducts() {
        return products;
    }

    public void setProducts(boolean products) {
        this.products = products;
    }

    public boolean isAllergen() {
        return allergen;
    }

    public void setAllergen(boolean allergen) {
        this.allergen = allergen;
    }

    public boolean isMachines() {
        return machines;
    }

    public void setMachines(boolean machines) {
        this.machines = machines;
    }

    public boolean isOrders() {
        return orders;
    }

    public void setOrders(boolean orders) {
        this.orders = orders;
    }

    public boolean isWorkers() {
        return workers;
    }

    public void setWorkers(boolean workers) {
        this.workers = workers;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
