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

package org.wso2.apim.example.order;

import io.swagger.annotations.*;
import org.wso2.apim.example.order.model.Order;
import org.wso2.apim.example.order.repo.OrderRepository;

import javax.ws.rs.*;
import java.util.List;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1-SNAPSHOT
 */
@Api(value = "Order Service")
@SwaggerDefinition(
    info = @Info(
        title = "Order Service Swagger Definition", version = "1.0",
        description = "Catalog Service",
        license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"),
        contact = @Contact(
            name = "Ajanthan Balachandran",
            email = "ajanthan@wso2.com",
            url = "http://wso2.com"
        ))
)
@Path("/order")
public class OrderService {
    private OrderRepository repository=new OrderRepository();

    @GET
    @Path("/{username}")
    @Produces("application/json")
    public List<Order> getUserOrdersByName(@PathParam("username") String username) {
        return repository.getOrdersByUser(username);

    }

    @POST
    @Path("/{username}")
    public void addOrder(@PathParam("username") String username, Order order) {
 repository.addOrder(username,order);
    }

    @PUT
    @Path("/{username}/{orderId}")
    public void updateOrder(@PathParam("username") String username,@PathParam("orderId") long orderId, Order order) {
repository.updateOrder(username,orderId,order);
    }

    @DELETE
    @Path("/{username}/{orderId}")
    public void delete(@PathParam("username") String username,@PathParam("orderId") long orderId) {
  repository.cancelOrder(username,orderId);
    }
}
