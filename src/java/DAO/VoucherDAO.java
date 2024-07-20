/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.Voucher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class VoucherDAO {

    Connection conn;//ket noi voi database
    PreparedStatement ps;//thuc thi cau lenh sql
    ResultSet rs;// luu gia tri lay tu database

    public List<Voucher> getAllVouchers() {
        List<Voucher> list = new ArrayList<>();
        String query = "select * from voucher";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Voucher(rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public boolean checkVoucherExist(String id) {
        String query = "SELECT * FROM voucher WHERE voucher_id = ?";
        boolean exists = false;

        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            // Kiểm tra nếu ResultSet không rỗng và cột đầu tiên không là null
            if (rs.next() && rs.getObject(1) != null) {
                exists = true;
            }
        } catch (SQLException e) {
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection để tránh rò rỉ tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return exists;
    }

    public Voucher searchVouchersByCode(String text) {
        String query = "select * from voucher\n"
                + "where voucher_code=?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, text);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Voucher(rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Voucher> searchVouchersByRate(String text) {
        List<Voucher> list = new ArrayList<>();
        String query = "select * from voucher\n"
                + "where discount_percentage=?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, text);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Voucher(rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void createVoucher(String id, String code, Double discount) {
        String query = "INSERT INTO voucher\n"
                + "VALUES (?, ?, ?)";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, code);
            ps.setDouble(3, discount);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateVoucher(String id, String code, Double discount) {
        String query = "UPDATE voucher\n"
                + "SET voucher_code=?, discount_percentage=? \n"
                + "WHERE voucher_id = ?";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, code);
            ps.setDouble(2, discount);
            ps.setString(3, id);

            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteVoucher(String id) {
        String query = "DELETE FROM voucher WHERE voucher_id = ? ";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ khi gặp lỗi thực thi câu lệnh SQL          
        } finally {
            // Đóng kết nối và tài nguyên
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
    }

    public Voucher getVoucherByCode(String voucherCode) {
        Voucher voucher = null;
//        String query = "SELECT * FROM Voucher WHERE voucher_code = ?";
//        phân biệt hoa thường
        String query = "select * from voucher where voucher_code  "
                + "COLLATE SQL_Latin1_General_Cp850_CS_AS like ? \n"
                + "COLLATE SQL_Latin1_General_Cp850_CS_AS;";

        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, voucherCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                voucher = new Voucher(
                        rs.getString("voucher_id"),
                        rs.getString("voucher_code"),
                        rs.getFloat("discount_percentage")
                );
            }
        } catch (SQLException e) {
        }
        return voucher;
    }

    public Voucher getVoucherByID(String id) {
        Voucher voucher = null;
        String query = "SELECT * FROM Voucher WHERE voucher_id = ?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                voucher = new Voucher(
                        rs.getString("voucher_id"),
                        rs.getString("voucher_code"),
                        rs.getFloat("discount_percentage")
                );
            }
        } catch (SQLException e) {
        }
        return voucher;
    }

    public Voucher getVoucherRandom() {
        Voucher voucher = null;
        String query = "SELECT TOP 1 * FROM voucher\n"
                + "ORDER BY NEWID();";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                voucher = new Voucher(
                        rs.getString("voucher_id"),
                        rs.getString("voucher_code"),
                        rs.getFloat("discount_percentage")
                );
            }
        } catch (SQLException e) {
        }
        return voucher;
    }

    public static void main(String[] args) {
     
    }
}
