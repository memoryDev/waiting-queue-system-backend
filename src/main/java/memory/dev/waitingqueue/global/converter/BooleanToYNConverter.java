package memory.dev.waitingqueue.global.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        // true면 "Y", false거나 null이면 "N" 저장
        return (attribute != null && attribute) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        // "Y"면 true, 아니면 false 로딩
        return "Y".equalsIgnoreCase(dbData);
    }
}
