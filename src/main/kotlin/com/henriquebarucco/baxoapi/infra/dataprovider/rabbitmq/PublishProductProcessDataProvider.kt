package com.henriquebarucco.baxoapi.infra.dataprovider.rabbitmq

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.henriquebarucco.baxoapi.domain.product.dto.PublishProductInput
import com.henriquebarucco.baxoapi.domain.product.gateway.PublishProductProcessGateway
import org.slf4j.LoggerFactory
import org.springframework.amqp.AmqpException
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageBuilder
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class PublishProductProcessDataProvider(
    @Value("\${rabbitmq.process.exchange}")
    private val exchange: String,
    @Value("\${rabbitmq.process.routing-key}")
    private val routingKey: String,
    private val rabbitTemplate: RabbitTemplate,
) : PublishProductProcessGateway {
    private val log = LoggerFactory.getLogger(PublishProductProcessDataProvider::class.java)

    override fun publish(input: PublishProductInput) {
        try {
            this.rabbitTemplate.convertAndSend(
                exchange,
                routingKey,
                this.buildMessage(input),
            )
        } catch (ex: AmqpException) {
            log.error("Error while trying to publish the message :: Exception: ${ex.message}")
        }
    }

    private fun buildMessage(input: PublishProductInput): Message {
        val properties = MessageProperties()

        val message =
            MessageBuilder
                .withBody(
                    GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()
                        .toJson(input)
                        .toByteArray(),
                ).andProperties(properties)
                .build()

        return message
    }
}
