/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import da.ProductDataAccess;
import entity.Product;
import java.util.List;

/**
 *
 * @author tuan5
 */
public class ProductFinderBean {
    private String keyword;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public List<Product> getProduct(){
    return new ProductDataAccess().getProductByName(keyword);
    }
    public List<Product> getAllProduct(){
    return new ProductDataAccess().getProduct();
    }
    
}
