/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.daoImpl;

import com.EMS.DatabaseConnection.DbConnect;
import com.EMS.dao.FacilitatorDao;
import com.EMS.entities.Facilitator;
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
public class FacilitatorDaoImpl implements FacilitatorDao {

    private List<Facilitator> facilitatorList;
    Facilitator facilitator = new Facilitator();
    DbConnect dbConn = new DbConnect();

    public FacilitatorDaoImpl() {
    }

    public FacilitatorDaoImpl(List<Facilitator> facilitatorList) {
        this.facilitatorList = facilitatorList;
    }

    @Override
    public void insert(Facilitator facilitator) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "insert into tbl_customer(address,first_name,last_name) values(?,?,?)";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, facilitator.getName());
        ps.setDouble(2, facilitator.getSalary());
        int result = ps.executeUpdate();
        System.out.println("rows affected " + result);
        dbConn.close();
    }

    @Override
    public int update(Facilitator facilitator) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "update table tbl_facilitator set facilitator_name=?,salary=? where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, facilitator.getName());
        ps.setDouble(2, facilitator.getSalary());
        ps.setInt(3, facilitator.getFacilitatorId());

        int result = dbConn.executeUpdate(sql);
        System.out.println("updated successfully,\n" + result + "rows affected");

        dbConn.close();
        return result;

    }

    @Override
    public Facilitator getById(int facilitatorId) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "select * from tbl_facilitatorwhere id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, facilitatorId);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {

            facilitator = new Facilitator();
            if (facilitator.getFacilitatorId() == facilitatorId) {
                facilitator = mapData(rs);
            } else {
                System.out.println("no such records");
            }
        }
        System.out.println(facilitator);
        dbConn.close();
        return facilitator;
    }

    @Override
    public int delete(int facilitatorId) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "delete from tbl_facilitator where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, facilitatorId);
        int result = dbConn.executeUpdate(sql);
        dbConn.close();
        return result;
    }

    @Override
    public List<Facilitator> getAll() throws ClassNotFoundException, SQLException {
        dbConn.open();
        List<Facilitator> facilitatorList = new ArrayList<>();
        String sql = "select * from tbl_facilitator";
        PreparedStatement ps = dbConn.initStatement(sql);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            facilitatorList.add(mapData(rs));
        }
        dbConn.close();
        return facilitatorList;
    }

    @Override
    public List<Facilitator> search(String param) throws ClassNotFoundException, SQLException {
        List<Facilitator> facSList = new ArrayList<>();
        dbConn.open();
        String sql = "select * from tbl_facilitator where facilitator_name=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, param);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {

            facSList.add(mapData(rs));

        }
        System.out.println(facSList);

        dbConn.close();
        return facSList;
    }

    @Override
    public void loadData(String path) throws IOException, ClassNotFoundException, SQLException {
        Facilitator fac = new Facilitator();
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            fac.setFacilitatorId(Integer.parseInt(tokenizer.nextToken()));
            fac.setName(tokenizer.nextToken());
            fac.setSalary(Double.parseDouble(tokenizer.nextToken()));
            insert(fac);
        }
        reader.close();
    }

    @Override
    public void exportData(String filename, String content) throws IOException, ClassNotFoundException, SQLException {
        FileWriter fileWriter = new FileWriter(new File(filename));
        fileWriter.write(content);
        fileWriter.close();
    }

    private Facilitator mapData(ResultSet rs) throws ClassNotFoundException, SQLException {
        facilitator = new Facilitator();
        facilitator.setFacilitatorId(rs.getInt("id"));
        facilitator.setName(rs.getString("facilitator_name"));

        return facilitator;
    }
}
