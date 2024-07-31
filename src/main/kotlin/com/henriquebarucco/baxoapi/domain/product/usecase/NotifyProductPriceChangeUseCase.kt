package com.henriquebarucco.baxoapi.domain.product.usecase

import com.henriquebarucco.baxoapi.domain.product.entity.Product
import com.henriquebarucco.baxoapi.domain.product.gateway.SendMessageGateway
import com.henriquebarucco.baxoapi.domain.product.interactor.NotifyProductPriceChangeInteractor
import org.springframework.stereotype.Service

@Service
class NotifyProductPriceChangeUseCase(
    private val sendMessageGateway: SendMessageGateway,
) : NotifyProductPriceChangeInteractor {
    override fun execute(
        product: Product,
        value: Double,
    ) {
        val message =
            if (product.price == null) {
                """
                O ${product.name} está custando R${'$'} $value!
                Link: ${product.url}
                """.trimIndent()
            } else {
                """
                O ${product.name} estava custando R${'$'} ${product.price} e agora está custando R${'$'} $value!
                Link: ${product.url}
                """.trimIndent()
            }

        this.sendMessageGateway.send(
            message = message,
            phone = product.user.phone,
        )
    }
}
