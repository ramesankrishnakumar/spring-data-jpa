package home.krishna.productdata

import home.krishna.productdata.persistence.entity.Student
import home.krishna.productdata.persistence.repository.StudentRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.test.annotation.Rollback
import javax.transaction.Transactional

@SpringBootTest
class StudentRepositoryTest(
    @Autowired val repository: StudentRepository
) {

    @Test
    fun createStudent() {
        repository.saveAll(mutableListOf(
            Student(null, "krishnakumar", "ramesan", 97),
            Student(null, "Apeksha", "Villath", 99),
            Student(null, "Mob", "Psycho", 100),
            Student(null, "Saitama", "Sensei", 1000)
        ))
    }

    @Test
    fun selectAllStudentsInJPQL() = repository.findAllStudents().forEach {
        println(it)
    }

    @Test
    fun selectAllStudentsNames() = repository.getNamesOfAllStudents().forEach {
        println(it)
    }

    @Test
    fun selectAllStudentHavingName() = repository.getAllStudentsByName("krishnakumar").forEach {
        println(it)
    }

    @Test
    fun selectAllStudentWithScoresBetween() = repository.getAllStudentsWithScoreRange(90, 100).forEach {
        println(it)
    }

    @Test @Transactional()@Rollback(false)
    fun deleteStudentByFirstName() {
        repository.deleteStudentByFirstName("Saitama")
            ?.let { println("Rows deleted: $it") }
    }

    @Test
    fun findAllStudentsUsingPaging() = repository.findAllStudentsPaged(
        PageRequest.of(0, 10))
        .forEach { println(it) }


    @Test
    fun findAllStudentsUsingPagingAndSorting() = repository.findAllStudentsPaged(
        PageRequest.of(0, 10, Sort.by( Sort.Direction.DESC, "Id")))
        .forEach { println(it) }

    @Test
    fun findAllStudentsUsingNativeQuery() = repository.selectFromTable()
        .forEach { println(it) }

    @Test
    fun findAllStudentsWhereUsingNativeQuery() = repository.selectFromTableWhere("Saitama")
        .forEach { println(it) }


    @Test
    fun findAllFromStmtStudentsWhereUsingNativeQuery() = repository.selectFromTableWhere("Saitama")
        .forEach { println(it) }


}