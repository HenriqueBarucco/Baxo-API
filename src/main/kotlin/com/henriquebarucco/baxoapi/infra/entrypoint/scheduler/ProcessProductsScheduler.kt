package com.henriquebarucco.baxoapi.infra.entrypoint.scheduler

import com.henriquebarucco.baxoapi.domain.product.interactor.FetchEnabledProductsInteractor
import com.henriquebarucco.baxoapi.domain.product.interactor.PublishProductProcessInteractor
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class ProcessProductsScheduler(
    private val fetchEnabledProductsInteractor: FetchEnabledProductsInteractor,
    private val publishProductProcessInteractor: PublishProductProcessInteractor,
) {
    @Scheduled(cron = "\${schedule.cron}")
    fun process() {
        val products = this.fetchEnabledProductsInteractor.execute()

        products.forEach {
            this.publishProductProcessInteractor.execute(it)
        }
    }
}
