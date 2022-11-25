package home.krishna.productdata

import home.krishna.productdata.persistence.entity.tableperclass.BankCheque
import home.krishna.productdata.persistence.entity.tableperclass.CreditCard2
import home.krishna.productdata.persistence.repository.Payment2Repository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InheritanceTablePerClassPaymentRepositoryTest(
    @Autowired val repository: Payment2Repository
) {

    @Test
    fun createCreditCard() {
        repository.saveAll(
            mutableListOf(
                CreditCard2(null, 100.37, "111-11-9000"),
                CreditCard2(null, 110.37, "121-11-9000")
            )
        )
    }

    @Test
    fun createBankCheck() {
        repository.saveAll(
            mutableListOf(
                BankCheque(null, 100.37, "111"),
                BankCheque(null, 110.37, "121")
            )
        )
    }
}