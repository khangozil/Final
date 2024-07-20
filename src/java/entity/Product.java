package entity;

/**
 *
 * @author ADMIN
 */
public class Product {

    private String pro_id;
    private String pro_name;
    private String pro_image;
    private String pro_date;
    private double pro_price;
    private double pro_quantity;
    private String pro_description;
    private int cate_id;

    public Product() {
    }

    public Product(String pro_id, String pro_name, String pro_image, String pro_date, double pro_price, double pro_quantity, String pro_description, int cate_id) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_image = pro_image;
        this.pro_date = pro_date;
        this.pro_price = pro_price;
        this.pro_quantity = pro_quantity;
        this.pro_description = pro_description;
        this.cate_id = cate_id;
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

    public String getPro_image() {
        return pro_image;
    }

    public void setPro_image(String pro_image) {
        this.pro_image = pro_image;
    }

    public String getPro_date() {
        return pro_date;
    }

    public void setPro_date(String pro_date) {
        this.pro_date = pro_date;
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

    public String getPro_description() {
        return pro_description;
    }

    public void setPro_description(String pro_description) {
        this.pro_description = pro_description;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    @Override
    public String toString() {
        return pro_name + pro_price + pro_quantity;
    }

}
