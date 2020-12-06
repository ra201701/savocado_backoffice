/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.dao;

import crud.model.Product;
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
public class ProductDao {
    private static Connection cn = null;
    
    public static int save(Product p){
        int status = 0;
        try{
            cn = DataBase.getDBConnection();
            int idRandom = (int) (Math.random() * 100) + 1;
            PreparedStatement pst = cn.prepareStatement("insert into product(id, name, price, stock, dateadded) values(?,?,?,?,?)");
            pst.setInt(1, idRandom);
            pst.setString(2, p.getName());
            pst.setDouble(3, p.getPrice());
            pst.setInt(4, p.getStock());
            pst.setString(5, p.getDateadded());
            
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
            PreparedStatement pst = cn.prepareStatement("delete from product where id = ?");
            pst.setInt(1, id);
            status = pst.executeUpdate();
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return 8;
        }
        return status;
    }
    
    public static int update(Product p){
        int status = 0;
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("update product set name = ?, price = ?, stock = ? where id = ?");
            pst.setString(1, p.getName());
            pst.setDouble(2, p.getPrice());
            pst.setDouble(3, p.getStock());
            pst.setInt(4, p.getID());
            status = pst.executeUpdate();
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return 8;
        }
        return status;
    }
    
    public static Product getProduct(int id){
        Product p = new Product();
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("select * from product where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                p.setID(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setDateadded(rs.getString(5));
            }
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return null;
        }
        return p;
    }
    
    public static List<Product> getProducts(){
        List<Product> listProducts = new ArrayList<Product>();
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("select * from product");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setID(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setDateadded(rs.getString(5));
                listProducts.add(p);
            }
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return null;
        }
        return listProducts;
    }
}
