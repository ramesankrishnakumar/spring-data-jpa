package home.krishna.productdata

import home.krishna.productdata.persistence.entity.singletable.Cheque
import home.krishna.productdata.persistence.entity.singletable.CreditCard
import home.krishna.productdata.persistence.repository.PaymentRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InheritanceSingleTablePaymentRepositoryTest(
    @Autowired val repository: PaymentRepository
) {

    @Test
    fun createCardPayment() {
        repository.saveAll(
            mutableListOf(
                CreditCard(null, 100.68, "123-111-8967"),
                CreditCard(null, 999.18, "267-111-8967"),
                CreditCard(null, 546.88, "897-657-4554")
            )

        )
    }

    @Test
    fun createCheckPayment() {
        repository.saveAll(
            mutableListOf(
                Cheque(null, 20000.00, "101"),
                Cheque(null, 10000.00, "102"),
                Cheque(null, 14700.56, "103")
            )
        )
    }
}