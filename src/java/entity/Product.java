/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author tuan5
 */
public class Product {
    private int id;
    private String name;
    private String desp;

    public Product() {
    }

    public Product(int id, String name, String desp) {
        this.id = id;
        this.name = name;
        this.desp = desp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    @Override
    public String toString() {
        return "Product{"+"id= "+id+" ,name= "+name+" ,desp= "+desp+ "}";
    }
    
}
