package site.s23.orderservice.utility;

import site.s23.orderservice.dto.OrdersDTO;
import site.s23.orderservice.model.Orders;

public class OrderUtility {

	
		public static Orders getOrdersEntityFromOrdersDTO(final OrdersDTO ordersDTO, Orders ordersEntity) {
			ordersEntity = new Orders(ordersDTO.getId(), ordersDTO.getOrderId()!=null?ordersDTO.getOrderId():AppUtils.generateNewOrderId(), 
					ordersDTO.getFoodItems(), ordersDTO.getRestaurantId(), ordersDTO.getUserId());
			return ordersEntity; 
		}
	
		public static OrdersDTO getOrdersDTOFromOrdersEntity(final Orders orders, OrdersDTO ordersDTO) {
			ordersDTO = new OrdersDTO(orders.getId(), orders.getOrderId(), 
					orders.getFoodItems(), orders.getRestaurantId(), orders.getUserId());
			return ordersDTO; 
		}
		
}
