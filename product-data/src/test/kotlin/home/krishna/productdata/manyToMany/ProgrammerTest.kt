package home.krishna.productdata.manyToMany

import home.krishna.productdata.persistence.entity.relationships.manyToMany.Programmer
import home.krishna.productdata.persistence.entity.relationships.manyToMany.Project
import home.krishna.productdata.persistence.repository.manyToMany.ProgrammerRepository
import home.krishna.productdata.persistence.repository.manyToMany.ProjectRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProgrammerTest(
    @Autowired private val programmerRepository: ProgrammerRepository,
    @Autowired private val projectRepository: ProjectRepository
) {

    @Test
    fun createManyToManyProgrammer() {
        val programmer = Programmer(
            null, "kk", 198000
        )
        val project = Project(
            null,
            "Area - 54"
        )
        programmer.addProject(projectRepository.save(project))
        programmerRepository.save(programmer)
    }


    @Test
    fun createEntityGraph() {
        val programmer1 = Programmer(
            null, "kk1", 198000
        )
        val programmer2 = Programmer(
            null, "kk2", 400000
        )
        val programmer3 = Programmer(
            null, "kk3", 145000
        )


        val project1 = Project(
            null,
            "Area - 51"
        )
        val project2 = Project(
            null,
            "Lame - Project - 101"
        )

        val project3 = Project(
            null,
            "Avengers - T1"
        )

        programmer1.addProject(projectRepository.save(project1))
        programmerRepository.save(programmer1)

        programmer3.addProject(projectRepository.save(project2))
        programmerRepository.save(programmer3)

        val loadedProject1 = projectRepository.findProjectByName("Area - 51")
        programmer2.addProject(loadedProject1)
        programmer2.addProject(projectRepository.save(project3))
        programmerRepository.save(programmer2)
    }

    @Test
    fun loadEntityGraph() {
        val programmer = programmerRepository.findProgrammerByName("kk2");
        val programmerAndProjectsWithItsProgrammer = programmerRepository.getProgrammerById(programmer.id!!)
        programmerAndProjectsWithItsProgrammer.let {
            println("name: ${it.name}, salary: ${it.salary}")
            it.projects?.forEach { project ->
                println("programmer: ${it.name} works on ${project.name}")
            }
        }

        programmerAndProjectsWithItsProgrammer.projects?.forEach {
            it.programmers?.forEach { programmer ->
                println("project: ${it.name} is assigned to Programmer: ${programmer.name}")
            }
        }
    }

    @Test
    fun loadEntityGraphByAttributeGraphAttribute() {
        val programmer = programmerRepository.findProgrammerByName("kk2");
        val programmerAndProjectsWithItsProgrammer = programmerRepository.findProgrammerById(programmer.id!!)
        programmerAndProjectsWithItsProgrammer.let {
            println("name: ${it.name}, salary: ${it.salary}")
            it.projects?.forEach { project ->
                println("programmer: ${it.name} works on ${project.name}")
            }
        }

        programmerAndProjectsWithItsProgrammer.projects?.forEach {
            it.programmers?.forEach { programmer ->
                println("project: ${it.name} is assigned to Programmer: ${programmer.name}")
            }
        }
    }

    @Test
    fun loadEntityGraphByAttributeGraphAttribute2() {
        val programmer = programmerRepository.findProgrammerByName("kk2");
        val programmerAndProjectsWithItsProgrammer = programmerRepository.findJustProgrammerAndProjectById(programmer.id!!)
        programmerAndProjectsWithItsProgrammer.let {
            println("name: ${it.name}, salary: ${it.salary}")
            it.projects?.forEach { project ->
                println("programmer: ${it.name} works on ${project.name}")
            }
        }
    }
}