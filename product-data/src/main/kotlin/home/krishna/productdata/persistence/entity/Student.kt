package home.krishna.productdata.persistence.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.NamedNativeQuery
import javax.persistence.SqlResultSetMapping

//@NamedNativeQuery(
//    name = "Student.findtStudentFirstNameLastNameNQ",
//    query = "select fname, lname from student",
//    resultSetMapping = "studentdto.projection"
//)
//@SqlResultSetMapping(name = "studentdto.projection")
@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    @Column(name = "fname")
    val firstName: String,
    @Column(name = "lname")
    val lastName: String,
    val score: Int
) {
}