package site.s23.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.s23.orderservice.dto.OrderDetailsDTO;
import site.s23.orderservice.dto.OrdersDTO;
import site.s23.orderservice.service.OrderService;


@RestController
@RequestMapping(path = "/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping(path = "/add")
	public OrdersDTO addOrder(@RequestBody OrdersDTO order){
		
		return orderService.addOrder(order);
	}
	
	@GetMapping(path = "/fetch/{orderId}")
	public OrderDetailsDTO fetchOrderDetails(@PathVariable String orderId){
		
		return orderService.fetchOrderDetails(orderId);
	}
	
	@GetMapping(path = "/fetchAll")
	public List<OrderDetailsDTO> fetchAllOrders(){
		
		return orderService.fetchAllOrders();
	}
	
}
