/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.dao;

import crud.model.Empleado;
import crud.ra201701.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edgarrenderos
 */
public class EmpleadoDao {
    private static Connection cn = null;
    
    public static int save(Empleado e){
        int status = 0;
        try{
            cn = DataBase.getDBConnection();
            int idRandom = (int) (Math.random() * 100) + 1;
            PreparedStatement pst = cn.prepareStatement("insert into merchant(id, name, password, email, country) values(?,?,?,?,?)");
            pst.setInt(1, idRandom);
            pst.setString(2, e.getName());
            pst.setString(3, e.getPassword());
            pst.setString(4, e.getEmail());
            pst.setString(5, e.getCountry());
            
            System.out.println(e.getName());
            System.out.println(e.getPassword());
            System.out.println(e.getEmail());
            System.out.println(e.getCountry());
            
            status = pst.executeUpdate();
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return 8;
            System.out.println("Ocurrio un error al insertar");
        }
        return status;
    }
    
    public static int delete(int id){
        int status = 0;
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("delete from merchant where id = ?");
            pst.setInt(1, id);
            status = pst.executeUpdate();
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return 8;
        }
        return status;
    }
    
    public static int update(Empleado e){
        int status = 0;
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("update merchant set name = ?, password = ?, email = ?, country = ? where id = ?");
            pst.setString(1, e.getName());
            pst.setString(2, e.getPassword());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getCountry());
            pst.setInt(5, e.getId());
            status = pst.executeUpdate();
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return 8;
        }
        return status;
    }
    
    public static Empleado getEmployee(int id){
        Empleado e = new Empleado();
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("select * from merchant where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
            }
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return null;
        }
        return e;
    }
    
    public static List<Empleado> getEmployees(){
        List<Empleado> listEmpleados = new ArrayList<Empleado>();
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("select * from merchant");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Empleado e = new Empleado();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                listEmpleados.add(e);
            }
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return null;
        }
        return listEmpleados;
    }
    
}
