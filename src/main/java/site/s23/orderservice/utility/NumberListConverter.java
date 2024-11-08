package site.s23.orderservice.utility;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class NumberListConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        if (attribute == null) {
            return "";
        }
        return attribute.stream().map(String::valueOf).collect(Collectors.joining(","));
//        return String.join(",", String.valueOf(attribute));  // Convert list to CSV string
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return Arrays.asList();  // Return empty list if null or empty
        }
        return Arrays.stream(dbData.split(","))
        				.map(strVal -> Integer.valueOf(strVal))
        				.collect(Collectors.toList());  // Convert CSV string back to list
    }
}
