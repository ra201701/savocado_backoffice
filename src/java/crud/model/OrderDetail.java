/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.model;

/**
 *
 * @author edgarrenderos
 */
public class OrderDetail {
    private int id;
    private int idOrden;
    private int quantity;
    private double total;

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public int getIDOrden() { return idOrden; }
    public void setIDOrden(int value) { this.idOrden = value; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int value) { this.quantity = value; }

    public double getTotal() { return total; }
    public void setTotal(double value) { this.total = value; }
}

