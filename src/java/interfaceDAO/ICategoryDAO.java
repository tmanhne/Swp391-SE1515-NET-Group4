/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author Thongchu
 */
public interface ICategoryDAO {

    public List<Category> getAllCategories();

    public ArrayList<Category> getCategory();
}