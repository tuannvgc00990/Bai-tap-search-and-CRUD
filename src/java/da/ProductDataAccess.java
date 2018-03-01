/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuan5
 */
public class ProductDataAccess {

    private PreparedStatement seachStatement;

    private PreparedStatement getSeachStatement() throws ClassNotFoundException, SQLException {
        if (seachStatement == null) {
            Connection connection = new DBConnection().getConnection();
            seachStatement = connection.prepareStatement("Select * from PRODUCT where NAMEP like ?");
        }
        return seachStatement;
    }

    public List<Product> getProductByName(String name) {
        try {
            PreparedStatement sta = getSeachStatement();
            sta.setString(1, "%" + name + "%");
            ResultSet rs = sta.executeQuery();
            List<Product> lp = new LinkedList<>();
            while (rs.next()) {
                lp.add(new Product(rs.getInt("IDP"), rs.getString("NAMEP"), rs.getString("DESP")));
            }
            return lp;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    private PreparedStatement vviewStatement;

    private PreparedStatement getViewStatement() throws ClassNotFoundException, SQLException {
        if (seachStatement == null) {
            Connection connection = new DBConnection().getConnection();
            seachStatement = connection.prepareStatement("Select * from PRODUCT");
        }
        return seachStatement;
    }

    public List<Product> getProduct() {
        try {
            PreparedStatement sta = getSeachStatement();

            ResultSet rs = sta.executeQuery();
            List<Product> lp = new LinkedList<>();
            while (rs.next()) {
                lp.add(new Product(rs.getInt("IDP"), rs.getString("NAMEP"), rs.getString("DESP")));
            }
            return lp;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    private PreparedStatement createStatement;

    private PreparedStatement getCreateStatement() throws ClassNotFoundException, SQLException {
        if (createStatement == null) {
            Connection connection = new DBConnection().getConnection();
            createStatement = connection.prepareStatement("Insert into PRODUCT Values(?,?,?)");
        }
        return createStatement;
    }

    public boolean createProduct(Product p) throws SQLException {
        try {
            PreparedStatement sta = getCreateStatement();
            sta.setInt(1, p.getId());
            sta.setString(2, p.getName());
            sta.setString(3, p.getDesp());
            return sta.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    private PreparedStatement updateStatement;

    private PreparedStatement getUpdateStatement() throws ClassNotFoundException, SQLException {
        if (updateStatement == null) {
            Connection connection = new DBConnection().getConnection();
            updateStatement = connection.prepareStatement("Update PRODUCT set NAMEP=?, DESP=? where IDP=?");
        }
        return updateStatement;
    }

    public boolean updateProduct(Product p) throws SQLException {
        try {
            PreparedStatement sta = getCreateStatement();
            sta.setInt(3, p.getId());
            sta.setString(1, p.getName());
            sta.setString(2, p.getDesp());
            return sta.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
