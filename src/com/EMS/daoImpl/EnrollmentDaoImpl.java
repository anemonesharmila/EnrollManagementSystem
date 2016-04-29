/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.daoImpl;

import com.EMS.DatabaseConnection.DbConnect;
import com.EMS.dao.EnrollmentDao;
import com.EMS.entities.Enrollment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author sharmila
 */
public class EnrollmentDaoImpl implements EnrollmentDao {

    private List<Enrollment> enrollmentList;
    DbConnect dbConn = new DbConnect();
    Enrollment enrollment = new Enrollment();

    public EnrollmentDaoImpl() {
    }

    public EnrollmentDaoImpl(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    @Override
    public void insert(Enrollment enrollment) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "insert into tbl_enrollment(enrollment_type) values(?)";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, enrollment.getEnrollmentType());
        int result = dbConn.executeUpdate(sql);
        System.out.println(result + " rows affected");
        dbConn.close();
    }

    @Override
    public int update(Enrollment enrollment) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "update table tbl_enrollment set enrollment_type=? where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, enrollment.getEnrollmentType());
        ps.setInt(2, enrollment.getEnrollmentId());
        int result = dbConn.executeUpdate(sql);
        dbConn.close();
        return result;
    }

    @Override
    public Enrollment getById(int enrollmentId) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "select * from tbl_enrollment where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, enrollmentId);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            enrollment = new Enrollment();
            enrollment.setEnrollmentId(rs.getInt("id"));
            enrollment.setEnrollmentDate(rs.getDate("enquiry_date"));
            enrollment.setEnrollmentType(rs.getString("enquiry_type"));
        }
        dbConn.close();
        System.out.println(enrollment);
        return enrollment;
    }

    @Override
    public int delete(int enrollmentId) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "delete from tbl_enrollment where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, enrollmentId);
        int result = dbConn.executeUpdate(sql);
        System.out.println(result + " row affected");
        dbConn.close();
        return result;
    }

    @Override
    public List<Enrollment> getAll() throws ClassNotFoundException, SQLException {
        dbConn.open();
        List<Enrollment> enrollmentList = new ArrayList<>();
        String sql = "select * from tbl_enrollment";
        PreparedStatement ps = dbConn.initStatement(sql);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            enrollmentList.add(mapData(rs));
        }
        dbConn.close();
        return enrollmentList;
    }

    @Override
    public List<Enrollment> search(String param) throws ClassNotFoundException, SQLException {
        dbConn.open();
        List<Enrollment> enrollSearchList = new ArrayList<>();
        String sql = "select * from tbl_enrollment where enrollment_type=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, param);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {

            enrollSearchList.add(mapData(rs));

        }
        System.out.println(enrollSearchList);

        dbConn.close();
        return enrollSearchList;
    }

    @Override
    public void loadData(String path) throws IOException, ClassNotFoundException, SQLException {
        Enrollment enrollment = new Enrollment();
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            enrollment.setEnrollmentId(Integer.parseInt(tokenizer.nextToken()));
            enrollment.setEnrollmentType(tokenizer.nextToken());

            insert(enrollment);
        }
        reader.close();
    }

    @Override
    public void exportData(String filename, String content) throws IOException, ClassNotFoundException, SQLException {
        FileWriter fileWriter = new FileWriter(new File(filename));
        fileWriter.write(content);
        fileWriter.close();
    }

    private Enrollment mapData(ResultSet rs) throws SQLException, ClassNotFoundException {
        enrollment = new Enrollment();
        enrollment.setEnrollmentId(rs.getInt("id"));
        enrollment.setEnrollmentDate(rs.getDate("enrollment_Date"));
        enrollment.setEnrollmentType(rs.getString("enrollment_type"));
        return enrollment;
    }
}
