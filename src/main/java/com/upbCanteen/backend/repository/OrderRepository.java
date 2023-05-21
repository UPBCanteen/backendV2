package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
