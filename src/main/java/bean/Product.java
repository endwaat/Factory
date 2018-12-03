package bean;

import java.util.Date;

public class Product {

    int id;
    int productTypeId;
    Date productionDate;
    int weight;
    boolean inStorage;

    public Product(int id, int productTypeId, Date productionDate, int weight, boolean inStorage) {
        this.id = id;
        this.productTypeId = productTypeId;
        this.productionDate = productionDate;
        this.weight = weight;
        this.inStorage = inStorage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isInStorage() {
        return inStorage;
    }

    public void setInStorage(boolean inStorage) {
        this.inStorage = inStorage;
    }
}
