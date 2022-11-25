package home.krishna.productdata.persistence.repository.manyToMany

import home.krishna.productdata.persistence.entity.relationships.manyToMany.Programmer
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.CrudRepository

interface ProgrammerRepository: CrudRepository<Programmer, Int> {

    @EntityGraph(value = "programmer-and-projects")
    fun getProgrammerById(id: Int): Programmer

    fun findProgrammerByName(name: String): Programmer

    @EntityGraph(attributePaths = [
        "projects.programmers"
    ])
    fun findProgrammerById(id: Int): Programmer


    @EntityGraph(attributePaths = [
        "projects"
    ])
    fun findJustProgrammerAndProjectById(id: Int): Programmer

}