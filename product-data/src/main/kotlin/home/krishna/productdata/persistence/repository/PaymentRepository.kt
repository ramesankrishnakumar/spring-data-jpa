package home.krishna.productdata.persistence.repository

import home.krishna.productdata.persistence.entity.singletable.Payment
import org.springframework.data.repository.CrudRepository

interface PaymentRepository: CrudRepository<Payment, Int> {

}