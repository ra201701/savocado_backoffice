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
public class Order {
    private int id;
    private String name;
    private double total;
    private String dateordered;

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public double getTotal() { return total; }
    public void setTotal(double value) { this.total = value; }

    public String getDateordered() { return dateordered; }
    public void setDateordered(String value) { this.dateordered = value; }
}
