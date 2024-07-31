package com.henriquebarucco.baxoapi.infra.dataprovider.http

import com.henriquebarucco.baxoapi.domain.product.gateway.SendMessageGateway
import com.henriquebarucco.baxoapi.infra.dataprovider.http.easywhatsapp.EasyWhatsAppClient
import com.henriquebarucco.baxoapi.infra.dataprovider.http.easywhatsapp.dto.MessageDto
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SendWhatsAppMessageDataProvider(
    private val easyWhatsAppClient: EasyWhatsAppClient,
    @Value("\${easywhatsapp.token}")
    private val token: String,
) : SendMessageGateway {
    private val log = LoggerFactory.getLogger(SendWhatsAppMessageDataProvider::class.java)

    override fun send(
        phone: String,
        message: String,
    ) {
        try {
            val messageDto =
                MessageDto(
                    token = this.token,
                    phone = phone,
                    message = message,
                )

            this.easyWhatsAppClient.sendMessage(messageDto)
        } catch (e: Exception) {
            log.error("Error while trying to send the message :: Exception: ${e.message}")
        }
    }
}
