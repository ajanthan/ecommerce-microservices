package org.wso2.apim.example.order.repo;

import org.wso2.apim.example.order.model.Order;
import org.wso2.apim.example.order.model.OrderDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private Map<String, List<Order>> orderDetailsMap;

    public OrderRepository() {
        orderDetailsMap = new HashMap<>();
        Order order=new Order();
        List<Order> orders=new ArrayList<>();
        order.setId(1l);
        order.setUserId("john");
        List<OrderDetails> orderDetails=new ArrayList<>();
        orderDetails.add(new OrderDetails(1l,2l,2));
        orderDetails.add(new OrderDetails(2l,1l,3));
        orderDetails.add(new OrderDetails(3l,3l,1));
        order.setOrderDetails(orderDetails);
        orders.add(order);
        orderDetailsMap.put("john",orders);

    }

    public List<Order> getOrdersByUser(String username) {
        return orderDetailsMap.get(username);
    }

    public void addOrder(String username, Order order) {
        List<Order> orders = orderDetailsMap.get(username);
        orders.add(order);
        orderDetailsMap.put(username, orders);
    }

    public void cancelOrder(String username, long orderId) {
        List<Order> orders = orderDetailsMap.get(username);
        Order order = null;

        for (Order o : orders
            ) {
            if (o.getId() == orderId) {
                order = o;
                break;
            }
        }
        orders.remove(order);
        orderDetailsMap.put(username, orders);
    }

    public void updateOrder(String username, long orderId, Order newOrder) {
        List<Order> orders = orderDetailsMap.get(username);
        Order order = null;

        for (Order o : orders
            ) {
            if (o.getId() == orderId) {
                order = o;
                break;
            }
        }
        orders.remove(order);
        orders.add(newOrder);
        orderDetailsMap.put(username, orders);
    }


}
