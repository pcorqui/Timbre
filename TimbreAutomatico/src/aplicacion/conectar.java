package aplicacion;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conectar {
    String usuario="root";
        String pwd="ALEJANDRO";
        String url="jdbc:mysql://localhost:3306/Timbre";
        
    Connection conectar=null;
    public Connection conexion(){
        try{
            
            
        
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost:3306/Timbre","root","ALEJANDRO");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
            return conectar;
    }

}
