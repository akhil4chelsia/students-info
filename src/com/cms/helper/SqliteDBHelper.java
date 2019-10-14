package com.cms.helper;

import com.cms.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteDBHelper implements DBHelper {

    private String DB_URL;

    public SqliteDBHelper(String db) {
        this.DB_URL = db;
        try {
            init();
        } catch (Exception ex) {
            Logger.getLogger(SqliteDBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:" + DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean execute(String query) {
        Connection conn = getConnection();
        Statement stmt;
        try {
            stmt = conn.createStatement();
            return stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(SqliteDBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void init() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students (\n"
                + "    adminssion_no text PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    class text NOT NULL,\n"
                + "    fees text NOT NULL"
                + ");";

        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    @Override
    public <T> List<T> query(String query, Class<T> clazz) {
        List<T> data = new ArrayList<>();
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {              
                Student student = new Student();
                student.setAdmissionNumber(rs.getString("adminssion_no"));
                student.setName(rs.getString("name"));
                student.setGrade(rs.getString("class"));
                student.setFess(rs.getString("fees"));
                data.add((T) student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

}
