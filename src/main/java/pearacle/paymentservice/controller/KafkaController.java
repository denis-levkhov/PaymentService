package pearacle.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pearacle.paymentservice.service.KafkaProducerService;

@RequiredArgsConstructor
@RestController
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaProducerService.sendMessage(message);
        return "Message sent successfully";
    }
}
