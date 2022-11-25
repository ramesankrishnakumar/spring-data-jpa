package home.krishna.productdata.persistence.repository

import home.krishna.productdata.persistence.entity.Employee
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository: CrudRepository<Employee, Int> {
}