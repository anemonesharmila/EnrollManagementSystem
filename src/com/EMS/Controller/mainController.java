/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.Controller;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author sharmila
 */
public abstract class mainController {

    public mainController() {
    }
    
    public abstract void menu();
    public abstract void process() throws SQLException,ClassNotFoundException,IOException;
}
