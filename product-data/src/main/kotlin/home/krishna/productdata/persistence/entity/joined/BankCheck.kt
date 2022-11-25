package home.krishna.productdata.persistence.entity.joined

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn

@Entity
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
data class BankCheck3(
    override val id: Int?,
    override val amount: Double,
    val checkNumber: String
) : Payment3(id, amount)