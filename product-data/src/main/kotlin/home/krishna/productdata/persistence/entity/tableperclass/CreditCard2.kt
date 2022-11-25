package home.krishna.productdata.persistence.entity.tableperclass

import javax.persistence.*

@Entity
@Table(name = "creditcard")
data class CreditCard2(
    override val id: Int?,
    override val amount: Double,
    @Column(name = "cardnumber")
    val cardNumber: String
) : Payment2(id, amount) { }