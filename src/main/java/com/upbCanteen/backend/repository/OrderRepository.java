package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.Order;
import com.upbCanteen.backend.model.User;
import com.upbCanteen.backend.projection.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    List<OrderView> findAllBy();

    Optional<Order> findOrderByTimeAndUser(Date time, User user);
}
