/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.dao;

import com.EMS.entities.Facilitator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sharmila
 */
public interface FacilitatorDao {
    void insert(Facilitator facilitator)throws ClassNotFoundException,SQLException;
    int update(Facilitator facilitator) throws ClassNotFoundException,SQLException;
    Facilitator getById(int facilitatorId) throws ClassNotFoundException,SQLException;
    int delete(int facilitatorId) throws ClassNotFoundException,SQLException;
    List<Facilitator> getAll() throws ClassNotFoundException,SQLException;
    List<Facilitator> search(String param) throws ClassNotFoundException,SQLException;
    void loadData(String path) throws IOException, ClassNotFoundException,SQLException;
    void exportData(String filename,String content) throws IOException, ClassNotFoundException,SQLException;
}
