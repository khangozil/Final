package entity;

/**
 *
 * @author ADMIN
 */
public class Voucher {

    private String voucher_id;
    private String voucher_code;
    private float discount_percentage;

    public Voucher() {
    }

    public Voucher(String voucher_id, String voucher_code, float discount_percentage) {
        this.voucher_id = voucher_id;
        this.voucher_code = voucher_code;
        this.discount_percentage = discount_percentage;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(String voucher_id) {
        this.voucher_id = voucher_id;
    }

    public String getVoucher_code() {
        return voucher_code;
    }

    public void setVoucher_code(String voucher_code) {
        this.voucher_code = voucher_code;
    }

    public float getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(float discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

}
