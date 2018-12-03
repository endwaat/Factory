package bean;

import java.util.Date;

public class Orders {

    int id;
    String name;
    String costumer;
    int price;
    boolean done;
    Date orderTime;
    Date endTime;

    public Orders(int id, String name, String costumer, int price, boolean done, Date orderTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.costumer = costumer;
        this.price = price;
        this.done = done;
        this.orderTime = orderTime;
        this.endTime = endTime;
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

    public String getCostumer() {
        return costumer;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
