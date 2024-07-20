package DAO;

import context.DBContext;
import entity.Category;
import entity.Product;
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
public class ProductDAO extends DBContext {

    Connection conn;//ket noi voi database
    PreparedStatement ps;//thuc thi cau lenh sql
    ResultSet rs;// luu gia tri lay tu database

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getTop3() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT TOP 3 * \n"
                + "FROM product\n"
                + "ORDER BY pro_date DESC;";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where cate_id = ?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Product getProductByID(String cid) {
        String query = "select * from product\n"
                + "where pro_id = ?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Product> searchByName(String textSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where pro_name like ?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + textSearch + "%"); //%name% chứa name
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> searchByNameHaveCateID(String textSearch, String id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where pro_name like ? and cate_id= ?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + textSearch + "%"); //%name% chứa name
            ps.setString(2, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    //for admin
    public void createProduct(String id, String name, String image, String date, Double price, Double quantity, String description, Integer category) {
        String query = "insert into product\n"
                + "values(?, ?, ?, ?, ?, ?,?, ?)";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setString(4, date);
            ps.setDouble(5, price);
            ps.setDouble(6, quantity);
            ps.setString(7, description);
            ps.setInt(8, category);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    //for admin
    public boolean checkProductExistByID(String id) {
        String query = "SELECT * FROM product WHERE pro_id = ?";
        boolean exists = false;

        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
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
    
    public boolean checkProductExistByName(String id) {
        String query = "SELECT * FROM product WHERE pro_name = ?";
        boolean exists = false;

        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
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

    public void updateProduct(String id, String name, String image, String date, Double price, Double quantity, String description, Integer category) {
        String query = "UPDATE product\n"
                + "SET pro_name=?, pro_image=? , pro_date=?, pro_price=?, pro_quantity=?,pro_description=?,cate_id=?\n"
                + "WHERE pro_id =?";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, date);
            ps.setDouble(4, price);
            ps.setDouble(5, quantity);
            ps.setString(6, description);
            ps.setInt(7, category);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteProduct(String id) {
        String query = "DELETE FROM product WHERE pro_id = ? ";
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

   public static void main(String[] args) {
       
    }
}
