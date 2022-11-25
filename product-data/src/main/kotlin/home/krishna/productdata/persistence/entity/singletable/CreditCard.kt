package home.krishna.productdata.persistence.entity.singletable

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue(value = "cc")
data class CreditCard(
    override val id: Int?,
    override val amount: Double,
    @Column(name = "cardnumber")
    val cardNumber: String
) : Payment(id, amount)