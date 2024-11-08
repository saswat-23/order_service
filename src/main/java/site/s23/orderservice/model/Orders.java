package site.s23.orderservice.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.s23.orderservice.utility.NumberListConverter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String orderId;
	
	@Convert(converter = NumberListConverter.class)
	@Column(columnDefinition = "VARCHAR(255)")
    private List<Integer> foodItems;
    private int restaurantId;
    private int userId;
	
}
