package site.s23.orderservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {

	private int id;
	private String orderId;
    private List<Integer> foodItems;
    private int restaurantId;
    private int userId;
	
}
