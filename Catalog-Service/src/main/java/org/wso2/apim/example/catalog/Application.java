/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.apim.example.catalog;

import org.wso2.apim.example.catalog.model.Product;
import org.wso2.apim.example.catalog.repo.ProductRepository;
import org.wso2.msf4j.MicroservicesRunner;

import javax.persistence.Persistence;

/**
 * Application entry point.
 *
 * @since 0.1-SNAPSHOT
 */
public class Application {
    public static void main(String[] args) {
        ProductRepository repository = getUserRepository();
        addProduct(repository, "Chair", 65.15, "Chair for living room", new String[]{ "furniture", "living" });
        addProduct(repository, "Sun Glass", 34.69, "Summer sun glass", new String[]{ "clothe", "fashion" });
        addProduct(repository, "Hat", 30.50, "Hat for men", new String[]{ "clothes", "fashion" });
        addProduct(repository, "Running Shoe", 69.90, "Durable running shoe", new String[]{ "clothe", "sport" });
        addProduct(repository, "Watch", 55.50, "Watch for men", new String[]{ "clothe", "fashion" });
        new MicroservicesRunner()
            .deploy(new CatalogService(repository),new Healthz())
            .start();
    }

    public static ProductRepository getUserRepository() {
        return new ProductRepository(Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa"));
    }

    public static void addProduct(ProductRepository repository, String name, double price, String description, String[] tags) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setTags(tags);
        repository.create(product);
    }
}
