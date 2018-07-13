package org.wso2.apim.example.order.model;

public class OrderDetails {

    private Long Id;
    private Long productId;
    private int quantity;

    public OrderDetails(Long id, Long productId, int quantity) {
        Id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
            "Id=" + Id +
            ", productId=" + productId +
            ", quantity=" + quantity +
            '}';
    }
}
