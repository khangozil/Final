package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DUY KHANG
 */
public class Cart {

    private List<CartItem> items;
    private double discount;
    private double totalfinal;
    private Voucher appliedVoucher;
    private Map<String, CartItem> item;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalfinal() {
        return totalfinal;
    }

    public void setTotalfinal(double totalfinal) {
        this.totalfinal = totalfinal;
    }

    public Cart() {
        items = new ArrayList<>();
        this.discount = 0;
        this.totalfinal = 0;
    }

    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getPro_id().equals(product.getPro_id())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
        updateFinalTotal();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void removeItem(String pro_id) {
        for (Iterator<CartItem> it = items.iterator(); it.hasNext();) {
            CartItem item = it.next();
            if (item.getProduct().getPro_id().equals(pro_id)) {
                it.remove();
                break;
            }
        }
        updateFinalTotal();
    }

    public void increaseQuantity(String pro_id) {
        for (CartItem item : items) {
            if (item.getProduct().getPro_id().equals(pro_id)) {
                item.setQuantity(item.getQuantity() + 1);
                break;
            }
        }
        updateFinalTotal();
    }

    public void decreaseQuantity(String pro_id) {
        for (CartItem item : items) {
            if (item.getProduct().getPro_id().equals(pro_id)) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                }
                break;
            }
        }
        updateFinalTotal();
    }

    public void updateQuantity(String pro_id, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getPro_id().equals(pro_id)) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(quantity);
                }
                break;
            }
        }
        updateFinalTotal();
    }

    public void clearCart() {
        items.clear();
    }

    public void applyVoucher(Voucher voucher) {
        if (voucher != null) {
            this.appliedVoucher = voucher;
            updateFinalTotal();
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getQuantity() * item.getProduct().getPro_price();
        }

        return total;
    }

    private void updateFinalTotal() {
        double total = getTotalPrice();
        if (appliedVoucher != null) {
            this.discount = total * (appliedVoucher.getDiscount_percentage());
        } else {
            this.discount = 0;
        }
        this.totalfinal = Math.round(total - discount);
    }

    public Voucher getAppliedVoucher() {
        return appliedVoucher;
    }

}
