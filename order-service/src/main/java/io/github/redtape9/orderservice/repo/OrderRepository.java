package io.github.redtape9.orderservice.repo;

import io.github.redtape9.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
