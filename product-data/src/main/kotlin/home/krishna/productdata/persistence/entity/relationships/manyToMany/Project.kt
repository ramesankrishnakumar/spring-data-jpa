package home.krishna.productdata.persistence.entity.relationships.manyToMany

import javax.persistence.*

@Entity
@Table(name = "project_many_to_many")
data class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    @Column(unique = true)
    val name: String
) {

    @ManyToMany(
        mappedBy = "projects",
        cascade = [CascadeType.MERGE],
        fetch = FetchType.LAZY
    )
     var programmers: MutableSet<Programmer>? = null

    fun addProgrammer(programmer: Programmer) {
        if (this.programmers == null)
            this.programmers = mutableSetOf()

        this.programmers?.add(programmer)
    }


}
