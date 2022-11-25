package home.krishna.productdata.persistence.entity.singletable

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue(value = "ch")
data class Cheque(
    override val id: Int?,
    override val amount: Double,
    @Column(name = "checknumber")
    val checkNumber: String
): Payment(id, amount)