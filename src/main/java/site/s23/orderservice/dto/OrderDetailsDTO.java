package site.s23.orderservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {

	private int id;
	private String orderId;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
    private UserDTO user;
	
}
