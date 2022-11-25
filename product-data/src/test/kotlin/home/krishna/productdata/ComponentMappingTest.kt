package home.krishna.productdata

import home.krishna.productdata.persistence.entity.component.mapping.Address
import home.krishna.productdata.persistence.entity.component.mapping.Employee2
import home.krishna.productdata.persistence.repository.Employee2Repository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ComponentMappingTest(
    @Autowired val repository: Employee2Repository,
) {

    @Test
    fun createEmployee() {
        repository.saveAll(
            mutableListOf(
                Employee2(null, "krishna", Address("street1", "city1", "state1", "1234", "usa"))
            )

        )
    }
}