/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FeedbackDAO {

    Connection conn;//ket noi voi database
    PreparedStatement ps;//thuc thi cau lenh sql
    ResultSet rs;// luu gia tri lay tu database

    LocalDate date = java.time.LocalDate.now();
    LocalTime time = java.time.LocalTime.now();

    public void addFeedback(String fb_id, String content, String date, String username) {
        String query = "INSERT INTO feedback \n"
                + "VALUES (?, ?, ?,?)";
        try {
            conn = new DBContext().connect();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, fb_id);
            ps.setString(2, content);
            ps.setString(3, date);
            ps.setString(4, username);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Feedback> getAllFeedbacks() {
        List<Feedback> listF1 = new ArrayList<>();
        String query = "select * from feedback\n"
                + "ORDER BY fb_date DESC;";// test ben SQL
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listF1.add(new Feedback(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException e) {
        }
        return listF1;
    }

    public void deleteFeedback(String fid) {
        String sql = "Delete from feedback where fb_id=?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(sql);
            ps.setString(1, fid);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Feedback getFeedbackByFBID(String fbid) {
        String query = "  select * from feedback where fb_id= ?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, fbid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Feedback(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Feedback> getFeedbackByAccID(String accid) {
        List<Feedback> listF = new ArrayList<>();
        String query = "select * from feedback where acc_id =?\n"
                + "ORDER BY fb_date DESC;";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, accid);
            rs = ps.executeQuery();
            while (rs.next()) {
                listF.add(new Feedback(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }

        } catch (SQLException e) {

        }
        return listF;
    }

    public void updateFeedback(String content, String date, String id) {
        String query = "update feedback set fb_content =? , fb_date =? where fb_id =?";
        try {
            conn = new DBContext().connect();
            ps = conn.prepareStatement(query);
            ps.setString(1, content);
            ps.setString(2, date);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public static void main(String[] args) {
        FeedbackDAO dao = new FeedbackDAO();

    }
}
