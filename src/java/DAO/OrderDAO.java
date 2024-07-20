/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quynhh Nhuu
 */
public class OrderDAO {

    Connection conn;//ket noi voi database
    PreparedStatement ps;//thuc thi cau lenh sql
    ResultSet rs;// luu gia tri lay tu database

    LocalDate date = java.time.LocalDate.now();
    LocalTime time = java.time.LocalTime.now();

    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        String query = "SELECT * FROM [order]\n"
                + "ORDER BY order_date DESC;";// test ben SQL
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public int insertOrder(Order order) {
        String query = "INSERT INTO [order] (order_date, total_price, acc_id, voucher_id) VALUES ( ?, ?, ?, ?)";
        int generatedId = -1;
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, order.getOrder_date());
            ps.setFloat(2, order.getTotal_price());
            ps.setString(3, order.getAcc_id());
            ps.setString(4, order.getVoucher_id());

            ps.executeUpdate(); // Retrieve the generated order ID     
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return generatedId;
    }

    public List<Order> getOrdersByAccountId(String accountId) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM [order] WHERE acc_id = ?\n"
                + "ORDER BY order_date DESC;";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return orders;
    }

    public static void main(String[] args) {

    }
}
