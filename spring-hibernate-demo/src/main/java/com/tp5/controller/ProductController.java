package com.tp5.controller;



import com.tp5.dao.IDao;
import com.tp5.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IDao<Product> productDao;

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productDao.findAll();
        model.addAttribute("products", products);
        return "products"; // -> src/main/resources/templates/products.html
    }
}

