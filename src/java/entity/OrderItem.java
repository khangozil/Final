package entity;

/**
 *
 * @author ADMIN
 */
public class OrderItem {

    private String orderItem_id;
    private String pro_id;
    private String pro_name;
    private double pro_price;
    private double pro_quantity;
    private float total_price;
    private String order_id;

    public OrderItem() {
    }

    public OrderItem(String orderItem_id, String pro_id, String pro_name, double pro_price, double pro_quantity, float total_price, String order_id) {
        this.orderItem_id = orderItem_id;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_quantity = pro_quantity;
        this.total_price = total_price;
        this.order_id = order_id;
    }

    public String getOrderItem_id() {
        return orderItem_id;
    }

    public void setOrderItem_id(String orderItem_id) {
        this.orderItem_id = orderItem_id;
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public double getPro_price() {
        return pro_price;
    }

    public void setPro_price(double pro_price) {
        this.pro_price = pro_price;
    }

    public double getPro_quantity() {
        return pro_quantity;
    }

    public void setPro_quantity(double pro_quantity) {
        this.pro_quantity = pro_quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

}
