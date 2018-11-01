package bean;

import java.util.Date;

public class Ingredient {

    int id;
    String name;
    int ingredientTypeId;
    Date arrive;
    Date expired;
    int weight;
    String source;
    int value;

    public Ingredient(int id, String name, int ingredientTypeId, Date arrive, Date expired, int weight, String source, int value) {
        this.id = id;
        this.name = name;
        this.ingredientTypeId = ingredientTypeId;
        this.arrive = arrive;
        this.expired = expired;
        this.weight = weight;
        this.source = source;
        this.value = value;
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

    public int getIngredientTypeId() {
        return ingredientTypeId;
    }

    public void setIngredientTypeId(int ingredientTypeId) {
        this.ingredientTypeId = ingredientTypeId;
    }

    public Date getArrive() {
        return arrive;
    }

    public void setArrive(Date arrive) {
        this.arrive = arrive;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
