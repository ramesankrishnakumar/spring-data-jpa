package home.krishna.productdata.persistence.entity.singletable

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)
abstract class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Int?,
    open val amount: Double
)