package home.krishna.productdata.oneToMany

import home.krishna.productdata.persistence.entity.relationships.oneToMany.CustomerOneToMany
import home.krishna.productdata.persistence.entity.relationships.oneToMany.PhoneNumberManyToOne
import home.krishna.productdata.persistence.repository.oneToMany.OneToManyRepo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OneToManyTest(
    @Autowired val repository: OneToManyRepo
) {

    @Test
    fun createCustomer() {
        val phoneNumbers = mutableSetOf<PhoneNumberManyToOne>()
        phoneNumbers.add(PhoneNumberManyToOne(null, "1234567", "cell"))
        phoneNumbers.add(PhoneNumberManyToOne(null, "1234568", "work"))
        phoneNumbers.add(PhoneNumberManyToOne(null, "1234569", "mobile"))
        val customers = CustomerOneToMany(null, "krishnakumar")
        customers.addPhoneNumbers(phoneNumbers)
        repository.save(customers)
    }

    @Test
    fun readCustomer() {
        val customer = repository.findById(7).get()
        println(customer) // won't load the numbers
        // need an active transaction to load the phone numbers
        // that's one more active call to retrieve the data, you know you need
        // solution => 1. left join 2. entity graph
        // bad ones 1. keep an open transaction 2. fetch mode = eager
    }

    @Test
    fun readCustomerLeftJoin() {
        val customer = repository.findCustomerById(7)
        println(customer)
        customer?.numbers?.forEach {
            println(it)
        }
    }

    @Test
    fun readCustomerEntityGraph() {
        val customer = repository.findCustomerOneToManyById(7)
        println(customer)
        customer?.numbers?.forEach {
            println(it)
        }
    }



}