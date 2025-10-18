package com.tp5;

import com.tp5.dao.IDao;
import com.tp5.entities.Category;
import com.tp5.entities.Product;
import com.tp5.util.HibernateConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Category> categoryDao = context.getBean("categoryDaoImpl", IDao.class);
        IDao<Product> productDao = context.getBean("productDaoImpl", IDao.class);

        Category category = new Category("Électronique");
        categoryDao.create(category);

        Product product = new Product();
        product.setName("Téléphone");
        product.setPrice(1500.0);
        product.setCategory(category);

        productDao.create(product);

        System.out.println("Produit sauvegardé avec catégorie : " + product.getName() + " → " + product.getCategory().getName());
    }
}
