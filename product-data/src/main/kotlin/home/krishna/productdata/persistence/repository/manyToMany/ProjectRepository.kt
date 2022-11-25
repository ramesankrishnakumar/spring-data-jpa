package home.krishna.productdata.persistence.repository.manyToMany

import home.krishna.productdata.persistence.entity.relationships.manyToMany.Project
import org.springframework.data.repository.CrudRepository

interface ProjectRepository: CrudRepository<Project, Int> {

    fun findProjectByName(name: String): Project
}