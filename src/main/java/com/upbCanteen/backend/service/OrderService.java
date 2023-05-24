package com.upbCanteen.backend.service;

import com.upbCanteen.backend.model.Order;
import com.upbCanteen.backend.model.User;
import com.upbCanteen.backend.projection.OrderView;
import com.upbCanteen.backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }

    public List<OrderView> getAllOrders(){
        return orderRepository.findAllBy();
    }

    public Optional<Order> findByTimeAndUser(Date time, User user){
        return orderRepository.findOrderByTimeAndUser(time, user);
    }
}
