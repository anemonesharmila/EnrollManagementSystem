/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.daoImpl;

import com.EMS.DatabaseConnection.DbConnect;
import com.EMS.dao.FacilitiesDao;
import com.EMS.entities.Facilities;
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
public class FacilitiesDaoImpl implements FacilitiesDao {

    private List<Facilities> facilitiesList;
    Facilities facilities = new Facilities();
    DbConnect dbConn = new DbConnect();

    public FacilitiesDaoImpl() {
    }

    public FacilitiesDaoImpl(List<Facilities> facilitiesList) {
        this.facilitiesList = facilitiesList;
    }

    @Override
    public void insert(Facilities facilities) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "insert into tbl_facilities(facility_name,facility_fee,facility_duration) values(?,?,?)";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, facilities.getName());
        ps.setDouble(2, facilities.getFee());
        ps.setInt(3, facilities.getFacilitiesDuration());

        int result = ps.executeUpdate();
        System.out.println("rows affected " + result);
        dbConn.close();
    }

    @Override
    public int update(Facilities facilities) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "update table tbl_facilities set facility_name=?,facility_fee=?,facility_duration=? where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, facilities.getName());
        ps.setDouble(2, facilities.getFee());
        ps.setInt(3, facilities.getFacilitiesDuration());
        ps.setInt(4, facilities.getFacilityId());

        int result = dbConn.executeUpdate(sql);
        System.out.println("updated successfully,\n" + result + "rows affected");

        dbConn.close();
        return result;
    }

    @Override
    public Facilities getById(int facilityId) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "select * from tbl_facilities where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, facilityId);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {

            facilities = new Facilities();
            facilities.setFacilityId(rs.getInt("id"));
            facilities.setName(rs.getString("facility_name"));
            facilities.setFee(rs.getDouble("facility_fee"));
            facilities.setFacilitiesDuration(rs.getInt("facility_duration"));
        }
        System.out.println(facilities);
        dbConn.close();
        return facilities;
    }

    @Override
    public int delete(int facilitiesId) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "delete from tbl_facilities where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, facilitiesId);
        int result = dbConn.executeUpdate(sql);
        dbConn.close();
        return result;
    }

    @Override
    public List<Facilities> getAll() throws ClassNotFoundException, SQLException {
        dbConn.open();
        List<Facilities> facilitiesList = new ArrayList<>();
        String sql = "select * from tbl_customer";
        PreparedStatement ps = dbConn.initStatement(sql);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            facilities = new Facilities();
            facilities.setFacilityId(rs.getInt("id"));
            facilities.setName(rs.getString("facility_name"));
            facilities.setFee(rs.getInt("facility_fee"));
            facilities.setFacilitiesDuration(rs.getInt("facility_duration"));
            facilitiesList.add(facilities);
        }
        dbConn.close();
        return facilitiesList;
    }

    @Override
    public List<Facilities> search(String param) throws ClassNotFoundException, SQLException {
        dbConn.open();
        List<Facilities> facSearchList = new ArrayList<>();
        String sql = "select * from tbl_facilities where facility_name=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, param);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            facilities = new Facilities();
            facilities.setFacilityId(rs.getInt("id"));
            facilities.setName(rs.getString("facility_name"));
            facilities.setFee(rs.getInt("facility_fee"));
            facilities.setFacilitiesDuration(rs.getInt("facility_duration"));
            facilitiesList.add(facilities);

        }
        System.out.println(facSearchList);

        dbConn.close();
        return facSearchList;
    }

    @Override
    public void loadData(String path) throws IOException, ClassNotFoundException, SQLException {
        Facilities fa = new Facilities();
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            fa.setFacilityId(Integer.parseInt(tokenizer.nextToken()));
            fa.setName(tokenizer.nextToken());
            fa.setFee(Double.parseDouble(tokenizer.nextToken()));
            insert(fa);
        }
        reader.close();
    }

    @Override
    public void exportData(String filename, String content) throws IOException, ClassNotFoundException, SQLException {
        FileWriter fileWriter = new FileWriter(new File(filename));
        fileWriter.write(content);
        fileWriter.close();
    }

}
