data class Person(
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val age: String,
    val gender: String,
    val birthDate: String,
    val birthPlace: String,
    val postalCode: String,
    val country: String,
    val region: String,
    val city: String,
    val street: String,
    val houseNumber: String,
    val apartmentNumber: String
)

fun createInstancePerson(): Person {

    val fullNameAndGender = GenerateFullNameAndGender()

    val birthDataAndAge = GenerateBirthDataAndAge()

    return Person(
        firstName = fullNameAndGender.generateFirstName(),
        lastName = fullNameAndGender.generateLastName(),
        middleName = fullNameAndGender.generateMiddleName(),
        age = birthDataAndAge.generateAge(),
        gender = fullNameAndGender.generateGender(),
        birthDate = birthDataAndAge.generateBirthDate(),
        birthPlace = generateCityName(),
        postalCode = generatePostalCode(),
        country = generateNameCountry(),
        region = generateRegionName(),
        city = generateCityName(),
        street = generateStreetName(),
        houseNumber = generateHouseNumber(),
        apartmentNumber = generateApartmentNumber()
    )
}
