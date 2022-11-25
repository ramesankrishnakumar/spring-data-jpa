package home.krishna.productdata.persistence.entity.tableperclass

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Payment2(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    open val id: Int?,
    open val amount: Double
)