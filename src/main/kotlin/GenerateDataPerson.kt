import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.random.Random


class GenerateDataPerson : GenerateData {

    override fun generateData(): List<String> {

        val choiceGender = Random.nextBoolean()
        val choiceAge = Random.nextInt(MIN_AGE, MAX_AGE)

        return listOf(
            generateFirstName(choiceGender),
            generateLastName(choiceGender),
            generateMiddleName(choiceGender),
            generateAge(choiceAge),
            generateGender(choiceGender),
            generateBirthDate(choiceAge),
            generateCityName(),
            generatePostalCode(),
            generateNameCountry(),
            generateRegionName(),
            generateCityName(),
            generateStreetName(),
            generateHouseNumber(),
            generateApartmentNumber()
        )
    }

    private fun generateFirstName(choiceGender: Boolean): String =
        if (choiceGender) FIRST_NAMES_MAN.random() else FIRST_NAMES_WOMAN.random()

    private fun generateLastName(choiceGender: Boolean): String =
        if (choiceGender) LAST_NAMES_MAN.random() else LAST_NAMES_WOMAN.random()

    private fun generateMiddleName(choiceGender: Boolean): String =
        if (choiceGender) MIDDLE_NAMES_MAN.random() else MIDDLE_NAMES_WOMAN.random()

    private fun generateGender(choiceGender: Boolean): String =
        if (choiceGender) MALE else FEMALE

    private fun generateAge(choiceAge: Int): String =
        choiceAge.toString()

    private fun generateBirthDate(choiceAge: Int): String {

        val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)
        val currentDate = LocalDate.now()
        val maxPeriod = Period.ofYears(choiceAge + 1)
        val minPeriod = Period.ofYears(choiceAge)
        val startDate = currentDate.minus(maxPeriod)
        val endDate = currentDate.minus(minPeriod)
        val randomDate = startDate.plusDays(Random.nextLong(startDate.until(endDate, ChronoUnit.DAYS)))

        return randomDate.format(formatter)
    }

    private fun generateCityName(): String =
        FAKE.address().city()

    private fun generatePostalCode(): String =
        Random.nextInt(MIN_ZIP_CODE, MAX_ZIP_CODE).toString()

    private fun generateNameCountry(): String =
        NAME_COUNTRY

    private fun generateRegionName(): String =
        REGION_NAMES.random()

    private fun generateStreetName(): String =
        STREET_NAMES.random()

    private fun generateHouseNumber(): String =
        Random.nextInt(MIN_HOUSE_NUMBER, MAX_HOUSE_NUMBER).toString()

    private fun generateApartmentNumber(): String =
        Random.nextInt(MIN_APARTMENT_NUMBER, MAX_APARTMENT_NUMBER).toString()
}
