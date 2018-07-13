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

import io.swagger.annotations.*;
import org.wso2.apim.example.catalog.model.Product;
import org.wso2.apim.example.catalog.repo.ProductRepository;

import javax.ws.rs.*;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1-SNAPSHOT
 */
@Api(value = "Catalog Service")
@SwaggerDefinition(
    info = @Info(
        title = "Catalog Service Swagger Definition", version = "1.0",
        description = "Catalog Service",
        license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"),
        contact = @Contact(
            name = "Ajanthan Balachandran",
            email = "ajanthan@wso2.com",
            url = "http://wso2.com"
        ))
)
@Path("/catalog")
public class CatalogService {
    private ProductRepository repository;

    public CatalogService(ProductRepository repository) {
        this.repository = repository;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    @ApiOperation(
        value = "Returns Product by id",
        notes = "Returns HTTP 404 if Product id is not found")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Valid product  found"),
        @ApiResponse(code = 404, message = "Product not found")})
    public Product get(@PathParam("id") long id) {

        return repository.find(id, Product.class);
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    @ApiOperation(
        value = "Saves Product",
        notes = "Product id will be auto generated")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Product is saved successfully"),
        @ApiResponse(code = 500, message = "An Issue in saving product")})
    public void post(Product product) {
        repository.create(product);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @ApiOperation(
        value = "Updates Product by id",
        notes = "Returns HTTP 404 if Product id is not found")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Valid product  found and updated successfully"),
        @ApiResponse(code = 404, message = "Product not found"),
        @ApiResponse(code = 500, message = "Error in updating Product")})
    public void put(Product product) {
        repository.update(product);
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(
        value = "Deletes Product by id",
        notes = "Returns HTTP 404 if Product id is not found")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Valid product found and deleted"),
        @ApiResponse(code = 404, message = "Product not found"),
        @ApiResponse(code = 500, message = "Error in deleting Product")})
    public void delete(@PathParam("id") long id) {
        Product product = repository.find(id, Product.class);
        repository.remove(product);
    }
}
