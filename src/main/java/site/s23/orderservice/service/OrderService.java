package site.s23.orderservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import site.s23.orderservice.dto.FoodItemDTO;
import site.s23.orderservice.dto.OrderDetailsDTO;
import site.s23.orderservice.dto.OrdersDTO;
import site.s23.orderservice.dto.RestaurantDTO;
import site.s23.orderservice.dto.UserDTO;
import site.s23.orderservice.model.Orders;
import site.s23.orderservice.repo.OrderRepo;
import site.s23.orderservice.utility.OrderUtility;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	RestTemplate restTemplate;

	public OrdersDTO addOrder(OrdersDTO orderDTO) {
		
		Orders order = orderRepo.save(OrderUtility.getOrdersEntityFromOrdersDTO(orderDTO, new Orders()));
		
		return OrderUtility.getOrdersDTOFromOrdersEntity(order, new OrdersDTO());
	}

	public OrderDetailsDTO fetchOrderDetails(String orderId) {
		Orders orderData = orderRepo.findByOrderId(orderId);
		
		List<FoodItemDTO> foodItemDetails = getFoodItemDetails(orderData.getFoodItems());
		RestaurantDTO restaurant = getRestaurantInfoById(orderData.getRestaurantId());
		UserDTO user = getUserInfoById(orderData.getUserId());
		OrderDetailsDTO orderDetails = new OrderDetailsDTO(orderData.getId(), orderData.getOrderId(), foodItemDetails, restaurant, user);
		return orderDetails;
	}

	public List<OrderDetailsDTO> fetchAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<FoodItemDTO> getFoodItemDetails(List<Integer> foodItems) {
		
		//return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, RestaurantDTO.class);
		String requestUrl = "http://FOOD-CATALOGUE-SERVICE";
		String foodMsEndpoint = "/foodcatalogue/getItem/";
		
		
		return foodItems.stream().map(foodItemId -> restTemplate.getForObject(requestUrl+foodMsEndpoint+foodItemId,FoodItemDTO.class))
								.collect(Collectors.toList());
	}
	
	private RestaurantDTO getRestaurantInfoById(int restaurantId) {
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, RestaurantDTO.class);
	}
	
	private UserDTO getUserInfoById(int userId) {
		return restTemplate.getForObject("http://USER-SERVICE/user/id/"+userId, UserDTO.class);
	}
}
