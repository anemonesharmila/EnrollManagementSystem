/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.dao;

import java.io.IOException;

/**
 *
 * @author sharmila
 */
public interface ExportDataDao {
    
   void toBatchFile(String line,String path) throws IOException;
   void toCustomerFile(String line) throws IOException;
   void toEnquiryFile(String line) throws IOException;
   void toEnrollmentFile(String line) throws IOException;
   void toFacilitatorFile(String line) throws IOException;
   void toFacilitiesFile(String line) throws IOException;
   void toPaymentFile(String line) throws IOException;
}
