package home.krishna.productdata.persistence.repository

import home.krishna.productdata.persistence.entity.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerInterface: CrudRepository<Customer, Int> {
    fun findByNameAndEmail(name: String, email: String): List<Customer>
    fun findByEmailLike(email: String): List<Customer>
    fun findByIdIn(ids: Set<Int>): List<Customer>
}