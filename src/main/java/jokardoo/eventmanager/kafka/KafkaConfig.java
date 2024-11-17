package jokardoo.eventmanager.kafka;

import jokardoo.eventmanager.kafka.notification.EventChangeNotification;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public ConsumerFactory<Long, EventChangeNotification> consumerFactory(KafkaProperties kafkaProperties) {

        var props = kafkaProperties.buildConsumerProperties(new DefaultSslBundleRegistry());
        var factory = new DefaultKafkaConsumerFactory<Long, EventChangeNotification>(props);
        factory.setValueDeserializer(new JsonDeserializer<>(EventChangeNotification.class, false));

        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Long, EventChangeNotification>
    containerFactory(ConsumerFactory<Long, EventChangeNotification> consumerFactory) {

        var factory = new ConcurrentKafkaListenerContainerFactory<Long, EventChangeNotification>();

        factory.setConsumerFactory(consumerFactory);

        return factory;
    }

}
