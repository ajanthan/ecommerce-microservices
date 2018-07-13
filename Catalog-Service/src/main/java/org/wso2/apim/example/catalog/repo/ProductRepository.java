package org.wso2.apim.example.catalog.repo;

import org.wso2.apim.example.catalog.model.Product;
import org.wso2.apim.example.persistance.AbstractRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductRepository extends AbstractRepository<Product> {
    public ProductRepository(EntityManagerFactory emf) {
        super(emf);
    }


    public void create(Product product) {
        super.create(product);
    }

    public void update(Product product) {
        super.update(product);
    }


    public void remove(Product product) {
        super.remove(product);
    }


    public Product find(long id, Class<Product> productClass) {
        return super.find(id, productClass);
    }


    public List<Product> findAll(Class<Product> clazz) {
        return super.findAll(clazz);
    }
}
