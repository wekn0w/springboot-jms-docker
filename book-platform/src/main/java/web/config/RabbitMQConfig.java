package web.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.utils.MQConsts;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue bookAskReviewsQueue() {
        return new Queue(MQConsts.QUEUE_BOOK_ASK_REVIEWS, false);
    }

    @Bean
    public Queue reviewSendReviews() {
        return new Queue(MQConsts.QUEUE_REVIEW_SEND_REVIEWS, false);
    }

    @Bean
    public Queue bookSaveReview() {
        return new Queue(MQConsts.QUEUE_BOOK_SAVE_REVIEW, false);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
