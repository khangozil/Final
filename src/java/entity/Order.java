package entity;

/**
 *
 * @author ADMIN
 */
public class Order {

    private String order_id;
    private String order_date;
    private float total_price;
    private String acc_id;
    private String voucher_id;

    public Order() {
    }

    public Order(String order_id, String order_date, float total_price, String acc_id, String voucher_id) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.total_price = total_price;
        this.acc_id = acc_id;
        this.voucher_id = voucher_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(String voucher_id) {
        this.voucher_id = voucher_id;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", order_date=" + order_date + ", total_price=" + total_price + ", acc_id=" + acc_id + ", voucher_id=" + voucher_id + '}';
    }
    
    
}
