package com.henriquebarucco.baxoapi.infra.entrypoint.consumer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.henriquebarucco.baxoapi.domain.product.interactor.FindProductByIdInteractor
import com.henriquebarucco.baxoapi.domain.product.interactor.UpdateProductPriceInteractor
import com.henriquebarucco.baxoapi.infra.entrypoint.consumer.dto.MessageDto
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class ProcessedProductConsumer(
    private val findProductByIdInteractor: FindProductByIdInteractor,
    private val updateProductPriceInteractor: UpdateProductPriceInteractor,
) {
    private val log = LoggerFactory.getLogger(ProcessedProductConsumer::class.java)
    private val mapper = jacksonObjectMapper()

    @RabbitListener(
        autoStartup = "\${rabbitmq.processed.enabled}",
        queues = ["\${rabbitmq.processed.queue}"],
    )
    fun processedProduct(message: Message) {
        try {
            val (id, value) = this.mapper.readValue(message.body, MessageDto::class.java)

            val product = this.findProductByIdInteractor.execute(id)

            if (product.price == null || product.price > value) {
                log.info("Product price is null or greater than the new value")
            }

            this.updateProductPriceInteractor.execute(id, value)
        } catch (ex: Exception) {
            log.error("Error while trying to consume the message :: Exception: ${ex.message}")
        }
    }
}
