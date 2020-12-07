/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.dao;

import crud.model.Order;
import crud.model.OrderDetail;
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
public class OrderDao {
    private static Connection cn = null;
    
    public static int save(Order o){
        int status = 0;
        try{
            cn = DataBase.getDBConnection();
            int idRandom = (int) (Math.random() * 100) + 1;
            PreparedStatement pst = cn.prepareStatement("insert into orden(id, name, total, dateordered) values(?,?,?,?)");
            pst.setInt(1, idRandom);
            pst.setString(2, o.getName());
            pst.setDouble(3, o.getTotal());
            pst.setString(4, o.getDateordered());
            
            System.out.println(o.getName());
            System.out.println(o.getTotal());
            System.out.println(o.getDateordered());
            
            status = pst.executeUpdate();
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return 8;
            System.out.println("Ocurrio un error al insertar " + ex);
        }
        return status;
    }
    
    public static int delete(int id){
        int status = 0;
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("delete from orden where id = ?");
            pst.setInt(1, id);
            status = pst.executeUpdate();
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return 8;
        }
        return status;
    }
    
    public static int update(Order o){
        int status = 0;
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("update orden set name = ?, total = ? where id = ?");
            pst.setString(1, o.getName());
            pst.setDouble(2, o.getTotal());
            pst.setInt(3, o.getID());
            status = pst.executeUpdate();
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return 8;
        }
        return status;
    }
    
    public static Order getOrder(int id){
        Order o = new Order();
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("select * from orden where id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                o.setID(rs.getInt(1));
                o.setName(rs.getString(2));
                o.setTotal(rs.getDouble(3));
                o.setDateordered(rs.getString(4));
            }
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return null;
        }
        return o;
    }
    
    public static List<Order> getOrders(){
        List<Order> listOrders = new ArrayList<Order>();
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("select * from orden");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Order o = new Order();
                o.setID(rs.getInt(1));
                o.setName(rs.getString(2));
                o.setTotal(rs.getDouble(3));
                o.setDateordered(rs.getString(4));
                listOrders.add(o);
            }
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return null;
        }
        return listOrders;
    }
    
    public static List<OrderDetail> getOrderDetail(){
        List<OrderDetail> listDetail = new ArrayList<OrderDetail>();
        try{
            cn = DataBase.getDBConnection();
            PreparedStatement pst = cn.prepareStatement("select * from orderDetail where idOrder = ?");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                OrderDetail od = new OrderDetail();
                od.setID(rs.getInt(1));
                od.setIDOrden(rs.getInt(2));
                od.setQuantity(rs.getInt(3));
                od.setTotal(rs.getDouble(4));
                listDetail.add(od);
            }
            cn.close();
        } catch(ClassNotFoundException | SQLException ex){
            //return null;
        }
        return listDetail;
    }
    
}
