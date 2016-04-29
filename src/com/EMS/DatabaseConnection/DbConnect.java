/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.DatabaseConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sharmila
 */
public class DbConnect {

    Connection conn = null;
    PreparedStatement ps = null;

    public void open() throws ClassNotFoundException, SQLException {
        Class.forName(DbConstant.driver);
        conn = DriverManager.getConnection(DbConstant.url, DbConstant.user, DbConstant.password);

    }

    public PreparedStatement initStatement(String sql) throws ClassNotFoundException, SQLException {
       ps=conn.prepareStatement(sql);
       return ps;
    }

    public int executeUpdate(String sql) throws ClassNotFoundException, SQLException {
        return ps.executeUpdate();
    }

    public ResultSet executeQuery() throws ClassNotFoundException, SQLException {
        return ps.executeQuery();

    }

    public void close() throws SQLException,ClassNotFoundException {
        if(conn!=null && !conn.isClosed())
        {
            conn.close();
            conn=null;
        }

    }

}
