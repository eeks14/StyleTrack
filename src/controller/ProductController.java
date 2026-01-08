/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Product;
import model.ProductInventory;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deekshyarai
 */
public class ProductController {
    private ProductInventory inventory;
    

    public ProductController(ProductInventory inventory) {
        this.inventory = inventory;
        
    }

    // CREATE
    /* =========================
       ADD PRODUCT
       ========================= */
    public void addProduct(Product product) {
        inventory.addProduct(product);
    }

    // READ
    public List<Product> getAllProducts() {
        return inventory.getAll();
    }

    // UPDATE
    public void updateProduct(int index, Product product) {
        inventory.updateProduct(index, product);
    }

    // DELETE
    public void deleteProduct(int index) {
        inventory.deleteProduct(index);
    }
    public void loadProductTable(JTable table) {
        String[] columns = {"Name", "Brand", "Category", "Expiry Year", "Quantity", "Suitability"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Product p : inventory.getAll()) {
            Object[] row = {
                p.getProductName(),
                p.getBrand(),
                p.getCategory(),
                p.getExpiryYear(),
                p.getQuantity(),
                p.getSuitability()
            };
            model.addRow(row);
        }

        table.setModel(model);
    }
}
