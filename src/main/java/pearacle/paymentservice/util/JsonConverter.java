package pearacle.paymentservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class JsonConverter {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T toObject(String json, Class <T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            log.error("Json deserializing exception: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
