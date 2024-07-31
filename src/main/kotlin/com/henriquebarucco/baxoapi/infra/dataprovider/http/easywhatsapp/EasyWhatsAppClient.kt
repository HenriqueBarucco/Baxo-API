package com.henriquebarucco.baxoapi.infra.dataprovider.http.easywhatsapp

import com.henriquebarucco.baxoapi.infra.dataprovider.http.easywhatsapp.dto.MessageDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "easy-whatsapp-api",
    url = "\${easywhatsapp.url}",
)
interface EasyWhatsAppClient {
    @PostMapping("/message/text")
    fun sendMessage(
        @RequestBody message: MessageDto,
    ): ResponseEntity<Void>
}
