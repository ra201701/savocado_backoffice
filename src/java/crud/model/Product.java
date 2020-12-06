/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.model;

public class Product {
    private int id;
    private String name;
    private int stock;
    private double price;
    private String dateadded;

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public int getStock() { return stock; }
    public void setStock(int value) { this.stock = value; }

    public double getPrice() { return price; }
    public void setPrice(double value) { this.price = value; }

    public String getDateadded() { return dateadded; }
    public void setDateadded(String value) { this.dateadded = value; }
}

