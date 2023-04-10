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

        val (birthDate, age) = createBirthDateAndAge()

        return Person(
            firstName = if (choiceGender) firstNamesMan.random() else firstNamesWoman.random(),
            lastName = if (choiceGender) lastNamesMan.random() else lastNamesWoman.random(),
            middleName = if (choiceGender) middleNamesMan.random() else middleNamesWoman.random(),
            age = age,
            gender = if (choiceGender) male else female,
            birthDate = birthDate,
            birthPlace = fake.address().city(),
            postalCode = Random.nextInt(minZipCode, maxZipCode).toString(),
            country = nameCountry,
            region = regionNames.random(),
            city = fake.address().city(),
            street = streetNames.random(),
            houseNumber = Random.nextInt(minHouseNumber, maxHouseNumber).toString(),
            apartmentNumber = Random.nextInt(minApartmentNumber, maxApartmentNumber).toString()
        )
    }

    private fun createBirthDateAndAge(): Pair<String, String> {

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val currentDate = LocalDate.now()
        val maxPeriod = Period.ofYears(maxAge)
        val minPeriod = Period.ofYears(minAge)
        val startDate = currentDate.minus(maxPeriod)
        val endDate = currentDate.minus(minPeriod)
        val randomDate = startDate.plusDays(Random.nextLong(startDate.until(endDate, ChronoUnit.DAYS)))
        val randomDateString = randomDate.format(formatter)
        val age = Period.between(randomDate, currentDate).years.toString()

        return Pair(randomDateString, age)
    }
}
