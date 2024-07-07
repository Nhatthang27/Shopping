/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.session.entity;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Nhatthang
 */
public class CartEntity implements Serializable{
    private HashMap<String, Integer> items = null;
    
    public CartEntity() {
        items = new HashMap<>();
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }
    
    public void addItemToCart(String itemName) {
        if (items.containsKey(itemName)) {
            int num = items.get(itemName);
            items.put(itemName, num + 1);
        } else {
            items.put(itemName, 1);
        }
    }
    
    public void removeItemFromCart(String itemName) {
        if (items.containsKey(itemName)) {
            items.remove(itemName);
            if (items.isEmpty()) {
                items = null;
            }
        }
    }
}
