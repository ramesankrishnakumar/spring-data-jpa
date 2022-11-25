package home.krishna.productdata

import home.krishna.productdata.persistence.repository.EmployeeRepository
import home.krishna.productdata.persistence.repository.ProductRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

@SpringBootTest
class ProductDataApplicationTests(
    @Autowired val repository: ProductRepository,
    @Autowired val empRepository: EmployeeRepository
) {

    @Test
    fun contextLoads() {
    }

    @Test
    fun delete() {
        if (repository.existsById(2))
            repository.deleteById(2)

    }

    @Test
    fun findProductByName() {
        val product = repository.findByName("Apple Watch")
        println("product : $product")
    }

    @Test
    fun findProductByNameAndDesc() {
        val product = repository.findByNameAndDesc("LG washer", "LG washer")
        println("product : $product")
    }

    @Test
    fun findProductPriceGreaterThan() {
        repository.findByPriceGreaterThanEqual(1000.00).forEach {
            println("product : $it")
        }

    }

    @Test
    fun findProductByDescContains() {
        repository.findByDescContains("Tv").forEach {
            println("product : $it")
        }

    }

    @Test
    fun findProductByPriceBetween() {
        repository.findByPriceBetween(1500.00, 3000.00).forEach {
            println("product : $it")
        }

    }

    @Test
    fun findProductByDescLike() {
        repository.findByDescLike("%TV%").forEach {
            println("product : $it")
        }

    }

    @Test
    fun findProductIdsIn() =
        repository.findByIdIn(setOf(1, 2, 3)).forEach {
            println("product : $it")
        }

    @Test
    fun testFindAllByPaging() = repository.findAll(
        PageRequest.of(0, 10)
    ).forEach {
        println("product: $it")
    }

    @Test
    fun testFindAllByPaging2() = repository.findAll(
        Pageable.ofSize(1)
    ).forEach {
        println("product: $it")
    }

    @Test
    fun testFindAllBySorting() = repository.findAll(
        Sort.by("name")
    ).forEach {
        println("product: $it")
    }

    @Test
    fun testFindAllBySortingDesc() = repository.findAll(
        Sort.by(Sort.Direction.DESC, "name")
    ).forEach {
        println("product: $it")
    }

    @Test
    fun testFindAllBySortingMultipleFieldDesc() = repository.findAll(
        Sort.by(Sort.Direction.DESC, "name", "price")
    ).forEach {
        println("product: $it")
    }

    @Test
    fun testFindAllBySortingMultipleFieldsAndMultipleOrder() = repository.findAll(
        Sort.by(listOf(Sort.Order.desc("name"), Sort.Order.asc("price")))
    ).forEach {
        println("product: $it")
    }

    @Test
    fun testFindAllByPagingAndSorting() = repository.findAll(
        PageRequest.of(0, 2, Sort.Direction.DESC, "price")
    ).forEach {
        println("product: $it")
    }

    @Test
    fun testFindAllByPagingAndSorting2() = repository.findAll(
        PageRequest.of(
            0, 2, Sort.by(
                listOf(Sort.Order.asc("price"), Sort.Order.desc("name"))
            )
        )
    ).forEach {
        println("product: $it")
    }

    @Test
    fun findProductIdsInPages() =
        repository.findByIdIn(setOf(1, 2, 3), PageRequest.of(1, 2))
            .forEach {
                println("product : $it")
            }

}
