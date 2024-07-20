/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Cart;
import entity.CartItem;
import entity.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class OrderItemDAO extends DBContext {

    public void insertOrderItems(Cart cart, int orderId) {
        try {
            Connection connection = new DBContext().connect();
            String sql = "INSERT INTO OrderItem (pro_id, pro_name, pro_price, quantity, total_price, order_id) " + "VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement
                    = connection.prepareStatement(sql);

            for (CartItem item : cart.getItems()) {
                statement.setString(1, item.getProduct().getPro_id());
                statement.setString(2, item.getProduct().getPro_name());
                statement.setDouble(3, item.getProduct().getPro_price());
                statement.setDouble(4, item.getQuantity());
                statement.setDouble(5, item.getQuantity() * item.getProduct().getPro_price());
                statement.setObject(6, orderId);
                statement.executeUpdate();
            }

            for (CartItem item : cart.getItems()) {
                connection = new DBContext().connect();

                sql = "UPDATE [dbo].[product]\n"
                        + "   SET\n"
                        + "      [pro_quantity] = [pro_quantity] - ?\n"
                        + "      \n"
                        + " WHERE pro_id = ?";
                statement
                        = connection.prepareStatement(sql);
                statement.setObject(1, item.getQuantity());
                statement.setObject(2, item.getProduct().getPro_id());
                statement.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        List<OrderItem> orderItems = new ArrayList<>();
        try {
            Connection connection = new DBContext().connect();
            String sql = "SELECT * FROM orderItem WHERE order_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItem_id(resultSet.getString("orderItem_id"));
                orderItem.setPro_id(resultSet.getString("pro_id"));
                orderItem.setPro_name(resultSet.getString("pro_name"));
                orderItem.setPro_price(resultSet.getDouble("pro_price"));
                orderItem.setPro_quantity(resultSet.getDouble("quantity"));
                orderItem.setTotal_price(resultSet.getFloat("total_price"));
                orderItem.setOrder_id(resultSet.getString("order_id"));
                orderItems.add(orderItem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderItems;
    }
    
    public static void main(String[] args) {
        System.out.println(new OrderItemDAO().getOrderItemsByOrderId(6));
    }
}
