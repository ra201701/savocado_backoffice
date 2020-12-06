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
    private long id;
    private long idOrden;
    private long quantity;
    private double total;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public long getIDOrden() { return idOrden; }
    public void setIDOrden(long value) { this.idOrden = value; }

    public long getQuantity() { return quantity; }
    public void setQuantity(long value) { this.quantity = value; }

    public double getTotal() { return total; }
    public void setTotal(double value) { this.total = value; }
}

