package bean;

public class IngredientType {

    int id;
    String name;
    int allergeticId;

    public IngredientType(int id, String name, int allergeticId) {
        this.id = id;
        this.name = name;
        this.allergeticId = allergeticId;
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
}
