package org.alejandria.bookapp.model;

import jakarta.persistence.*;
import org.hibernate.mapping.Set;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long orderId;

    @Column(name = "order_date",nullable = false)
    private Date orderDate;

    @Column(name = "total",nullable = false,columnDefinition = "DECIMAL(10,2)")
    private BigDecimal total;

    @Column(name = "payment_Method",nullable = false)
    private Set payment_Method;

    @Column(name = "status",nullable = false)
    private Set status;

    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id_user")
    private UserEntity user;

    public OrderEntity(Long orderId, Date orderDate, BigDecimal total, Set payment_Method, Set status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.total = total;
        this.payment_Method = payment_Method;
        this.status = status;
    }

    public OrderEntity() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Set getPayment_Method() {
        return payment_Method;
    }

    public void setPayment_Method(Set payment_Method) {
        this.payment_Method = payment_Method;
    }

    public Set getStatus() {
        return status;
    }

    public void setStatus(Set status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", total=" + total +
                ", payment_Method=" + payment_Method +
                ", status=" + status +
                '}';
    }
}
