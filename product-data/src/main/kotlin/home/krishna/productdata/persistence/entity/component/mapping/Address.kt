package home.krishna.productdata.persistence.entity.component.mapping

import javax.persistence.Embeddable

@Embeddable
data class Address(
    val streetaddress: String,
    val city: String,
    val state: String,
    val zipcode: String,
    val country: String
)
