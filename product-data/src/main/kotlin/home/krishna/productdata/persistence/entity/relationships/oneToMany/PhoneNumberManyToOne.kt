package home.krishna.productdata.persistence.entity.relationships.oneToMany

import javax.persistence.*

@Entity
@Table(name = "phone_number_many_to_one")
data class PhoneNumberManyToOne(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val number: String,
    val type: String,
) {
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    lateinit var customer: CustomerOneToMany
}