import java.time.LocalDate

data class Person(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val age: Int,
    val gender: Gender,
    val birthDate: LocalDate,
    val birthPlace: String,
    val postalCode: String,
    val country: String,
    val region: String,
    val city: String,
    val street: String,
    val houseNumber: Int,
    val apartmentNumber: Int
)

enum class Gender {
    MALE,
    FEMALE
}