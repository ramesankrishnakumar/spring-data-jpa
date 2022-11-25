package home.krishna.productdata.persistence.repository.oneToMany

import home.krishna.productdata.persistence.entity.relationships.oneToMany.CustomerOneToMany
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface OneToManyRepo : CrudRepository<CustomerOneToMany, Int> {
    @Query("select c from CustomerOneToMany c left join fetch c.numbers p  where  c.id = :id", nativeQuery = false)
    fun findCustomerById(@Param("id") id: Int): CustomerOneToMany?


    @EntityGraph("customer-and-phone")
    fun findCustomerOneToManyById( id: Int): CustomerOneToMany?
}