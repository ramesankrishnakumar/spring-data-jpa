package home.krishna.productdata.persistence.repository

import home.krishna.productdata.persistence.StudentModel
import home.krishna.productdata.persistence.entity.Student
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface StudentRepository : CrudRepository<Student, Int> {

    @Query(value =  "from Student" )
    fun findAllStudents() : List<Student>

    @Query(value =  "from Student" )
    fun findAllStudentsPaged(page: Pageable) : List<Student>

    @Query(value =  "select  new home.krishna.productdata.persistence.StudentModel(s.firstName, s.lastName) from Student s" )
    fun getNamesOfAllStudents() : List<StudentModel>

    @Query(value = "select s from Student s where s.firstName = :firstName")
    fun getAllStudentsByName(@Param("firstName") name: String): List<Student>

    @Query(value = "from Student where score >= :min and score <= :max")
    fun getAllStudentsWithScoreRange(@Param("min") min: Int, @Param("max") max: Int): List<Student>

    @Query(value = "delete from Student where firstName = :name")
    @Modifying
    fun deleteStudentByFirstName(@Param("name")name: String): Int?

    @Query(value = "select * from student", nativeQuery = true)
    fun selectFromTable(): List<Student>

    @Query(value = "select * from student where fname = :firstName", nativeQuery = true)
    fun selectFromTableWhere(@Param("firstName") name: String): List<Student>

}