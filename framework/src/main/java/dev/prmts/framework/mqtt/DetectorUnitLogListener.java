package dev.prmts.framework.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.prmts.common.model.dto.DetectorUnitLogDto;
import dev.prmts.common.model.entity.DetectorUnitLog;
import dev.prmts.common.service.DetectorUnitLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.messaging.Message;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DetectorUnitLogListener {
    private final ObjectMapper objectMapper;
    private final DetectorUnitLogService detectorUnitLogService;
    @Qualifier("logIngest")
    private final MessageProducerSupport messageProducerSupport;

    @Bean
    public IntegrationFlow detectorUnitLogInbound() {
        return IntegrationFlow.from(messageProducerSupport)
                .handle(this::handleLog)
                .get();
    }

    private void handleLog(Message<?> message) {
        String payload = message.getPayload().toString();
        DetectorUnitLogDto detectorUnitLogDto;
        try {
            detectorUnitLogDto = objectMapper.readValue(payload, DetectorUnitLogDto.class);
            detectorUnitLogService.save(detectorUnitLogDto);
        } catch (RuntimeException | JsonProcessingException e) {
            System.err.println(e);
            System.err.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
