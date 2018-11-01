package bean;

public class ProductType {

    int id;
    String name;
    int allergeticId;
    int weight;
    int time;
    int value;
    int cost;

    public ProductType(int id, String name, int allergeticId, int weight, int time, int value, int cost) {
        this.id = id;
        this.name = name;
        this.allergeticId = allergeticId;
        this.weight = weight;
        this.time = time;
        this.value = value;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllergeticId() {
        return allergeticId;
    }

    public void setAllergeticId(int allergeticId) {
        this.allergeticId = allergeticId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
