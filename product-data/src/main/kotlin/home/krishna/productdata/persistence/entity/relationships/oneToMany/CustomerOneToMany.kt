package home.krishna.productdata.persistence.entity.relationships.oneToMany

import javax.persistence.*
@NamedEntityGraph(
    name = "customer-and-phone",
    attributeNodes = [
        NamedAttributeNode("numbers")
    ]
)
@Entity
@Table(name = "customer_one_to_many")
data class CustomerOneToMany(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val name: String,
) {

    // mappedBy = is added in the parent side
    // the value is the variable name in the child entity
    // var customer: CustomerOneToMany
    // mappedBy = customer
    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL])
    var numbers: MutableSet<PhoneNumberManyToOne>? = null

    /**
        ::variableName.isInitialized  or   this::variableName.isInitialized
        But if you are inside a listener or inner class, do this:
        this@OuterClassName::variableName.isInitialized
     */
    fun addPhoneNumbers(numbers: Set<PhoneNumberManyToOne>) {
        if(this.numbers == null)
            this.numbers = numbers.toMutableSet()
        else
            this.numbers?.addAll(numbers)
        numbers.forEach { it.customer = this }
    }

}