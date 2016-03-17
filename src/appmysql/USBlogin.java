/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appmysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Expression autor is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class USBlogin {
    
    public void usblogin(){
        
         String s = "";
         String line = null;
 
        try {
            Process p = Runtime.getRuntime().exec("cmd /C vol G:");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            while ((line = in.readLine()) != null) {
                s = line;
            }
            p.destroy();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        s = s.replace("Volume Serial Number is ", "");
        s = s.trim();
        System.out.println(s);
        
        if (s.equals("A86B-A918")) {
           new Login().setVisible(true);
       }
        else{
             JOptionPane.showMessageDialog(null, "Usb Key no válido", "Error",JOptionPane.ERROR_MESSAGE);
        }

        //new Registro().setVisible(true);
       
    }
    }

