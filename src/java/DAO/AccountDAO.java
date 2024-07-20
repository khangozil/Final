/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import controller.LoginController;
import entity.Account;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
 * @author Admin
 */
public class AccountDAO {

    Connection conn;//ket noi voi database
    PreparedStatement ps;//thuc thi cau lenh sql
    ResultSet rs;// luu gia tri lay tu database

    //dùng để login, nếu trả về 1 account thì đăng nhập thành công
    //ngược lại, nếu trả về null thì đăng nhập không thành công
    public Account login(String user, String pass) {
        String query = "select * from account\n"
                + " where acc_id = ?\n"
                + "and [password] = ?";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    //dùng để đăng ký tài khoản mới
    //insert dữ liệu vào db
    public void singup(String account, String pass, String name, String phone, String address, String mail, String gender) {
        String query = "insert into account\n"
                + "values(?, ?, ?, ?, ?, ?,?,0)";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, account);
            ps.setString(2, hashPasswordMD5(pass));
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, mail);
            ps.setString(7, gender);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    //for admin
    public void createAccount(String account, String pass, String name, String phone, String address, String mail, String gender, Integer role) {
        String query = "insert into account\n"
                + "values(?, ?, ?, ?, ?, ?,?, ?)";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, account);
            ps.setString(2, hashPasswordMD5(pass));
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, mail);
            ps.setString(7, gender);
            ps.setInt(8, role);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public boolean checkAccountExist(String user) {
        String query = "SELECT * FROM account WHERE acc_id = ?";
        boolean exists = false;

        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();

            if (rs.next()) {
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

    public boolean checkPhoneExist(String phone) {
        String query = "SELECT * FROM account WHERE acc_phone = ?";
        boolean exists = false;

        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            rs = ps.executeQuery();

            if (rs.next()) {
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

    public boolean checkMailExist(String mail) {
        String query = "SELECT * FROM account WHERE mail = ?";
        boolean exists = false;

        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();

            if (rs.next()) {
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

    public String hashPasswordMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] passwordBytes = password.getBytes();
            byte[] hashBytes = md.digest(passwordBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //dùng để lấy thông tin của account
    public Account getAccount(String user) {
        String query = "select * from account\n"
                + "where acc_id = ?";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    //kiểm tra xem tài khoản đăng nhập có phải là admin hay không?
    public boolean isAdminExist(String username) {
        Account a = getAccount(username);
        return a != null && a.getIsAdmin() == 1;
    }

    //dùng cho forgot password
    public boolean checkProfile(String user, String name, String phone, String address, String mail, String gender) {
        AccountDAO dao = new AccountDAO();
        boolean c = dao.checkAccountExist(user);
        Account a = dao.getAccount(user);
        boolean isValid;
        //không tồn tại
        if (!c) {
            isValid = false;
        } else {
            //trùng khớp
            if (name.equalsIgnoreCase(a.getAcc_name()) && user.equals(a.getAcc_id())
                    && address.equalsIgnoreCase(a.getAddress())
                    && phone.equals(a.getPhone())
                    && gender.equalsIgnoreCase(a.getGender())
                    && mail.equalsIgnoreCase(a.getMail())) {
                isValid = true;
            } else {//không trừng khớp
                isValid = false;
            }
        }
        return isValid;
    }

    public void updatePassword(String user, String password) {
        if (user == null || password == null) {
//            LOGGER.log(Level.WARNING, "Tên người dùng hoặc mật khẩu mới là null");
            System.out.println("Tên người dùng hoặc mật khẩu mới là null");
            return;
        }

        String query = "UPDATE account\n"
                + "SET password=?\n"
                + "WHERE mail = ?;";
        try {
            conn = new DBContext().connect();
            if (conn == null) {
                System.out.println("Error connection");
                return;
            }
            ps = conn.prepareStatement(query);
            ps.setString(1, hashPasswordMD5(password));
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    public void updatePasswordForUser(String user, String password) {
        if (user == null || password == null) {
//            LOGGER.log(Level.WARNING, "Tên người dùng hoặc mật khẩu mới là null");
            System.out.println("Tên người dùng hoặc mật khẩu mới là null");
            return;
        }

        String query = "UPDATE account\n"
                + "SET password=?\n"
                + "WHERE acc_id = ?;";
        try {
            conn = new DBContext().connect();
            if (conn == null) {
                System.out.println("Error connection");
                return;
            }
            ps = conn.prepareStatement(query);
            ps.setString(1, hashPasswordMD5(password));
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    //for User
    public void updateProfile(String id, String name, String phone, String address, String gender) {
        String query = "UPDATE account\n"
                + "SET acc_name=?, acc_phone=?  , acc_address=?, gender=? \n"
                + "WHERE acc_id = ?";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, gender);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateProfileForAdmin(String id, String name, String phone, String address, String gender) {
        String query = "UPDATE account\n"
                + "SET acc_name=?, acc_phone=?  , acc_address=?, gender=?\n"
                + "WHERE acc_id = ?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, gender);
            ps.setString(5, id);
            ps.executeUpdate();
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
    }

    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        String query = "select * from account";// test ben SQL
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    //for admin
    public void deleteAccount(String id) {
        String query = "DELETE FROM account WHERE acc_id = ? ";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
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
    }

    //for admin
    public Account searchAccountsById(String id) {
        String query = "select * from account\n"
                + "where acc_id=?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    //for admin
    public List<Account> searchAccountsByName(String textSearch) {
        List<Account> list = new ArrayList<>();
        String query = "select * from account\n"
                + "where acc_name like ?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + textSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
