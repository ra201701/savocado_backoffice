/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.ra201701;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author edgarrenderos
 */
public class DataBase {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:8889/savocado";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static Connection dbConnection = null;
    
    public static Connection getDBConnection() throws ClassNotFoundException{
        try{
            Class.forName(DB_DRIVER);
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            System.out.println("Conexion exitosa");
        } catch(SQLException e){
            //System.out.println("Error al conectar la base");
        }
        return dbConnection;
    }
}
