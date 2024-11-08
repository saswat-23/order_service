package site.s23.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.s23.orderservice.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {

	Orders findByOrderId(String orderId);
	
}
