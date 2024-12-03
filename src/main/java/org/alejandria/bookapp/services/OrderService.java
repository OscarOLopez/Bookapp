package org.alejandria.bookapp.services;


import org.alejandria.bookapp.model.OrderEntity;
import org.alejandria.bookapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //GetAllOrders()
    public List<OrderEntity> getOrders(){
        return  this.orderRepository.findAll();
    }

    //Crear una orden que este relacionado con un User (dto)
    //Crear un OrderDto para recibir los datos de la orden asociados al idUser
    public OrderEntity createOrder(SpringDataJaxb.OrderDto dto){

    }

}