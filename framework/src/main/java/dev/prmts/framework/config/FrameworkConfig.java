package dev.prmts.framework.config;

import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

@Configuration
@EnableJpaRepositories(basePackages = {"dev.prmts.common"})
@EntityScan(basePackages = {"dev.prmts.common"})
@ComponentScan(basePackages = {"dev.prmts.common"})
public class FrameworkConfig {

    @Value("${framework.messaging.url}")
    private String brokerUrl;
    @Value("${framework.messaging.username}")
    private String username;
    @Value("${framework.messaging.password}")
    private String password;

    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setCleanSession(true);
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{brokerUrl});
        return mqttConnectOptions;
    }

    @Bean
    public MqttPahoClientFactory mqttPahoClientFactory() {
        DefaultMqttPahoClientFactory mqttPahoClientFactory = new DefaultMqttPahoClientFactory();
        mqttPahoClientFactory.setConnectionOptions(mqttConnectOptions());
        return mqttPahoClientFactory;
    }

    @Bean(name = "logIngest")
    public MessageProducerSupport detectorUnitLogAdapter() {
        String clientId = String.format("logs-client-%s", MqttAsyncClient.generateClientId());
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                clientId, mqttPahoClientFactory(), "logs");
        adapter.setQos(1);
        return adapter;
    }
}
