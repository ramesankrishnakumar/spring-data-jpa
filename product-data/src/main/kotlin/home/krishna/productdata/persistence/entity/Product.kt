package home.krishna.productdata.persistence.entity

import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var name: String,
    @Column(name = "description")
    var desc: String,
    var price: Double
) {
}