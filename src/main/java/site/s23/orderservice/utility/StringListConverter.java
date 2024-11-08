package site.s23.orderservice.utility;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null) {
            return "";
        }
        return String.join(",", attribute);  // Convert list to CSV string
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return Arrays.asList();  // Return empty list if null or empty
        }
        return Arrays.stream(dbData.split(","))
                     .collect(Collectors.toList());  // Convert CSV string back to list
    }
}
