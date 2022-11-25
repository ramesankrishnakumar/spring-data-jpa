package home.krishna.productdata.persistence.entity.relationships.manyToMany

import javax.persistence.*

@NamedEntityGraph(
    name = "programmer-and-projects",
    attributeNodes = [
        NamedAttributeNode(value = "projects", subgraph = "project-and-programmers")
    ],
    subgraphs = [
        NamedSubgraph(
            name = "project-and-programmers",
            attributeNodes = [
                NamedAttributeNode("programmers")
            ]
        )
    ]
)
@Entity
@Table(name = "programmer_many_to_many")
data class Programmer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val name: String,
    val salary: Int,
) {

    @ManyToMany(
        cascade = [CascadeType.MERGE],
        fetch = FetchType.LAZY
    )
    @JoinTable(
        name = "programmers_projects",
        joinColumns = [
            JoinColumn(
                name = "programmer_id",
                referencedColumnName = "id",
                nullable = false
            )
        ],
        inverseJoinColumns = [
            JoinColumn(
                name = "project_id",
                referencedColumnName = "id",
                nullable = false
            )
        ]
    )
    var projects: MutableSet<Project>? = null

    fun addProject(project: Project) {
        if (this.projects == null)
            this.projects = mutableSetOf()

            this.projects?.add(project)
    }

}