package home.krishna.productdata.persistence.entity.tableperclass

import javax.persistence.*

@Entity
@Table(name = "bankcheck")
data class BankCheque(
    override val id: Int?,
    override val amount: Double,
    @Column(name = "checknumber")
    val checkNumber: String
): Payment2(id, amount)