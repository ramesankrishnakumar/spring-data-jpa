package home.krishna.productdata.persistence.entity.joined

import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn

@Entity
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
data class CreditCard3(
    override val id: Int?,
    override val amount: Double,
    val cardNumber: String
): Payment3(id, amount)