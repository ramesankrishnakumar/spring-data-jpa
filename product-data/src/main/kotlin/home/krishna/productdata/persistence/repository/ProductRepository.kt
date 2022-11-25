package home.krishna.productdata.persistence.repository

import home.krishna.productdata.persistence.entity.Product
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

interface ProductRepository: PagingAndSortingRepository<Product, Int> {
    fun findByName(name: String): Product
    fun findByNameAndDesc(name: String, desc: String): Product
    fun findByPriceGreaterThanEqual(price: Double): List<Product>
    fun findByDescContains(desc: String): List<Product>
    fun findByPriceBetween(price1: Double, price2: Double): List<Product>
    fun findByDescLike(desc: String): List<Product>
    fun findByIdIn(ids: Set<Int>): List<Product>
    fun findByIdIn(ids: Set<Int>, page: Pageable): List<Product>
}