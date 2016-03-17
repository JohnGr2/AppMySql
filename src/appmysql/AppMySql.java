package appmysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author John Granados
 */
public class AppMySql {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
   public static void main(String[] args) throws SQLException, IOException {
       
        String s = "";
 
        try {
            Process p = Runtime.getRuntime().exec("cmd /C vol G:");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String line = null;
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


   
  

    

