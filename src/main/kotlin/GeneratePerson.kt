import kotlin.random.Random
import com.github.javafaker.Faker
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale


class GeneratePerson {

    private val fake = Faker(Locale("ru_RU"))

    fun generatePerson(choiceGender: Boolean): Person {
        val firstName = if (choiceGender) firstNamesMan.random() else firstNamesWoman.random()
        val lastName = if (choiceGender) lastNamesMan.random() else lastNamesWoman.random()
        val middleName = if (choiceGender) middleNamesMan.random() else middleNamesWoman.random()
        val gender = if (choiceGender) male else female
        val (birthDate, age) = createBirthDateAndAge()
        val birthPlace = fake.address().city()
        val postalCode = Random.nextInt(minZipCode, maxZipCode)
        val country = nameCountry
        val region = regionNames.random()
        val city = fake.address().city()
        val street = streetNames.random()
        val houseNumber = Random.nextInt(minHouseNumber, maxHouseNumber)
        val apartmentNumber = Random.nextInt(minApartmentNumber, maxApartmentNumber)

        return Person(
            firstName,
            lastName,
            middleName,
            age,
            gender,
            birthDate,
            birthPlace,
            postalCode,
            country,
            region,
            city,
            street,
            houseNumber,
            apartmentNumber
        )
    }


    private fun createBirthDateAndAge(): Pair<String, Int> {

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

        val currentDate = LocalDate.now()
        val maxPeriod = Period.ofYears(maxAge)
        val minPeriod = Period.ofYears(minAge)
        val startDate = currentDate.minus(maxPeriod)
        val endDate = currentDate.minus(minPeriod)
        val randomDate = startDate.plusDays(Random.nextLong(startDate.until(endDate, ChronoUnit.DAYS)))
        val randomDateString = randomDate.format(formatter)
        val age = Period.between(randomDate, currentDate).years
        return Pair(randomDateString, age)
    }
}
