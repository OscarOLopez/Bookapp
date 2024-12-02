package org.alejandria.bookapp.DTO;

import java.math.BigDecimal;
import java.util.Date;

// Aquí vamos a construir la clase con los atributos que si reciben información de Order y el atributo relacionado de User
public class OrderDTO {

    private Date orderDate;
    private BigDecimal total;
    private Long idUser;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
