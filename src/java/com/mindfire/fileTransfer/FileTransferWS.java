/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindfire.fileTransfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author Vishal Prasad
 */
@WebService(serviceName = "FileTransferWS")
public class FileTransferWS {

    /**
     * This is a sample web service operation
     */
     @WebMethod
    public void upload(String fileName, byte[] imageBytes) {
         
        String filePath = "C:/Users/Vishal Prasad/Desktop/Upload/" + fileName;
         
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(imageBytes);
            outputStream.close();
             
            System.out.println("Received file: " + filePath);
             
        } catch (IOException ex) {
            System.err.println(ex);
            throw new WebServiceException(ex);
        }
    }
     
    @WebMethod
    public byte[] download(String fileName) {
        String filePath = "C:/Users/Vishal Prasad/Desktop/Upload/" + fileName;
        System.out.println("Sending file: " + filePath);
         
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();
             
            return fileBytes;
        } catch (IOException ex) {
            System.err.println(ex);
            throw new WebServiceException(ex);
        }      
    }
}
