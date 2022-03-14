/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.OrderDAO;

/**
 *
 * @author t.manh
 */
public class test {
    public static void main(String[] args) throws Exception {
        OrderDAO db = new OrderDAO();
        System.out.println(db.insertOrder("CUS1", "2012/11/11"));
    }
    
}
