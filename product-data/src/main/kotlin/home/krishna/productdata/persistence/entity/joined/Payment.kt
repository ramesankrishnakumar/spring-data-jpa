package home.krishna.productdata.persistence.entity.joined

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Payment3(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    open val id: Int?,
    open val amount: Double
)