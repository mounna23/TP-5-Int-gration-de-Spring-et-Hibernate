

import com.tp5.dao.IDao;
import com.tp5.entities.Product;
import com.tp5.util.HibernateConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDaoTest {

    @Test
    public void testCreateProduct() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        IDao<Product> dao = context.getBean("productDaoImpl", IDao.class);

        Product p = new Product();
        p.setName("Test JUnit");
        p.setPrice(50.0);

        boolean result = dao.create(p);
        assertTrue(result);
        assertNotNull(p.getId());

        System.out.println("✅ Test réussi : produit créé avec ID = " + p.getId());
    }
}
