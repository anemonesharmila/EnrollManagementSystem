/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.views;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author sharmila
 */
public abstract class View {

    public View() {
    }
    
    public abstract void insert()throws ClassNotFoundException,SQLException;
    public abstract void delete()throws ClassNotFoundException,SQLException;
    public abstract void search()throws ClassNotFoundException,SQLException;
    public abstract void searchById()throws ClassNotFoundException,SQLException;
    public abstract void viewAll()throws ClassNotFoundException,SQLException;
    public abstract void update()throws ClassNotFoundException,SQLException;
    public abstract void loadData()throws ClassNotFoundException,SQLException,IOException;
    public abstract void exportData()throws ClassNotFoundException,SQLException,IOException;
    
}
