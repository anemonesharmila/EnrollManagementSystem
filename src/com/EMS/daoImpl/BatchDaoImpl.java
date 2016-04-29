/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.daoImpl;

import com.EMS.DatabaseConnection.DbConnect;
import com.EMS.dao.BatchDao;
import com.EMS.entities.Batch;
import com.EMS.views.BatchView;
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
public class BatchDaoImpl implements BatchDao {

    protected List<Batch> batchList;
    DbConnect dbConn = new DbConnect();
    BatchView bv = new BatchView();

    public BatchDaoImpl() {
    }

    public BatchDaoImpl(List<Batch> batchList) {
        this.batchList = batchList;
    }

    @Override
    public void insert(Batch batch) throws ClassNotFoundException, SQLException {
        //batchList.add(batch);
        dbConn.open();
        String sql = "insert into tbl_batch(batch_name) values(?)";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, batch.getBatchName());
        int result = dbConn.executeUpdate(sql);
        System.out.println(result + " rows inserted");
        dbConn.close();
    }

    @Override
    public int update(Batch batch) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "update tbl_batch set batch_name=? where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, batch.getBatchName());
        ps.setInt(2, batch.getBatchId());

        int result = dbConn.executeUpdate(sql);
        System.out.println(result + "row's affected");
        dbConn.close();
        return result;
    }

    @Override
    public Batch getById(int id) throws ClassNotFoundException, SQLException {
        dbConn.open();
        Batch batch = null;
        String sql = "select * from tbl_batch where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            batch = new Batch();
            batch.setBatchId(rs.getInt("id"));
            batch.setBatchName(rs.getString("batch_name"));

        }
        System.out.println(batch);
        dbConn.close();
        return batch;

    }

    @Override
    public int delete(int batchId) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "delete from tbl_batch where id=?";
        PreparedStatement stmt = dbConn.initStatement(sql);
        stmt.setInt(1, batchId);
        int result = dbConn.executeUpdate(sql);
        System.out.println("deleted " + result);
        return result;
    }

    @Override
    public List<Batch> getAll() throws ClassNotFoundException, SQLException {
        dbConn.open();
        List<Batch> batchList = new ArrayList<>();

        String sql = "select * from tbl_batch";
        PreparedStatement ps = dbConn.initStatement(sql);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            batchList.add(mapData(rs));
        }
        dbConn.close();
        return batchList;
    }

    @Override
    public List<Batch> search(String param) throws ClassNotFoundException, SQLException {
        Batch batch = null;
        List<Batch> searchList = new ArrayList<>();
        dbConn.open();
        String sql = "select * from tbl_batch where batch_name=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, param);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            // batch=new Batch();
            searchList.add(mapData(rs));
        }
        System.out.println(searchList);
//        if (param.equalsIgnoreCase(batch.getBatchName())) {
//            return batchList;
//        }
        return searchList;
    }

    @Override
    public void loadData(String path) throws IOException, ClassNotFoundException ,SQLException{
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while ((line = reader.readLine()) != null) {
            Batch batch = new Batch();
            StringTokenizer token = new StringTokenizer(line, ",");
            batch.setBatchId(Integer.parseInt(token.nextToken()));
            batch.setBatchName(token.nextToken());

            insert(batch);
            System.out.println(batch);

        }

        reader.close();
    }

    @Override
    public void exportData(String filename, String content) throws IOException, ClassNotFoundException {

        FileWriter fileWriter = new FileWriter(new File(filename));
        fileWriter.write(content);
        fileWriter.close();
    }

    private Batch mapData(ResultSet rs) throws SQLException, ClassNotFoundException {
        Batch batch = new Batch();
        batch.setBatchId(rs.getInt("id"));
        batch.setBatchName(rs.getString("batch_name"));
        return batch;

    }
}
