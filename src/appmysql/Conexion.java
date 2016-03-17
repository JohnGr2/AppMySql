package appmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author John Granados
 */
public class Conexion {
   
    //****** DATOS DE LA CONEXION **********************
    public String servidor = "localhost";
    public String nameDB = "agenda";
    public String login = "root";
    public String password = "123";
    //**************************************************
    
    public String url = "jdbc:mysql://"+servidor+":3306/"+nameDB;
    public Connection Link = null;
    
    //METODO CONECTAR A LA BASE DE DATOS
    public boolean CONECTAR()
    {   try
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.Link = DriverManager.getConnection(this.url, this.login, this.password);
            if(this.Link != null)
            {
                return true;
            }
        }    
        catch(SQLException ex)
        {
            //JOptionPane.showInputDialog("ERROR DE CONEXION A: "+this.url);
            System.out.println("ERROR DE CONEXION A: "+this.url);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex);
        }
        return false;
    }
    
    //METODO RESULTSET CONSULTAR
    public ResultSet CONSULTAR(String SQL)
    {   try
        {
            PreparedStatement Query = this.GetConection().prepareStatement(SQL);
            ResultSet Resultado = Query.executeQuery();
            return Resultado;
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR: "+ex);
            return null;
        }
    }

//METODO DESCONECTAR DE LA BASE DE DATOS
    public void CERRAR()
    {
        this.Link = null;
    }
    public Connection GetConection()
    {
        return this.Link;
    }

//METODO EJECUTAR
    public boolean EJECUTAR(String SQL)
    {
        try
        {
            PreparedStatement Query = this.GetConection().prepareStatement(SQL);
            Query.execute();
            return true;
        }
        catch(SQLException ex)
        {
            return false;
        }
    }
}