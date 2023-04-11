import com.github.javafaker.Faker
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale
import kotlin.random.Random


class GenerateFullNameAndGender {

    private val choiceGender = Random.nextBoolean()

    fun generateFirstName() : String {
        return if (choiceGender) firstNamesMan.random() else firstNamesWoman.random()
    }

    fun generateLastName() : String {
        return if (choiceGender) lastNamesMan.random() else lastNamesWoman.random()
    }

    fun generateMiddleName() : String {
        return if (choiceGender) middleNamesMan.random() else middleNamesWoman.random()
    }

    fun generateGender() : String {
        return if (choiceGender) male else female
    }
}

class GenerateBirthDataAndAge {

    private val choiceAge = Random.nextInt(minAge, maxAge)

    fun generateAge() : String {
        return choiceAge.toString()
    }

    fun generateBirthDate() : String {

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val currentDate = LocalDate.now()
        val maxPeriod = Period.ofYears(choiceAge + 1)
        val minPeriod = Period.ofYears(choiceAge)
        val startDate = currentDate.minus(maxPeriod)
        val endDate = currentDate.minus(minPeriod)
        val randomDate = startDate.plusDays(Random.nextLong(startDate.until(endDate, ChronoUnit.DAYS)))

        return randomDate.format(formatter)
    }
}

fun generateCityName() : String {
    val fake = Faker(Locale("ru_RU"))
    return fake.address().city()
}

fun generatePostalCode() : String {
    return Random.nextInt(minZipCode, maxZipCode).toString()
}

fun generateNameCountry() : String {
    return nameCountry
}

fun generateRegionName() : String {
    return regionNames.random()
}

fun generateStreetName() : String {
    return streetNames.random()
}

fun generateHouseNumber() : String {
    return Random.nextInt(minHouseNumber, maxHouseNumber).toString()
}

fun generateApartmentNumber() : String {
    return Random.nextInt(minApartmentNumber, maxApartmentNumber).toString()
}

val tableFieldNames = listOf(
    "Имя", "Фамилия", "Отчество", "Возраст","Пол", "Дата рождения", "Место рождения",
    "Индекс", "Страна", "Область", "Город", "Улица", "Дом", "Квартира"
)

fun generateDataPerson(): List<String> {
    val fullNameAndGender = GenerateFullNameAndGender()

    val birthDataAndAge = GenerateBirthDataAndAge()

    return listOf(
        fullNameAndGender.generateFirstName(),
        fullNameAndGender.generateLastName(),
        fullNameAndGender.generateMiddleName(),
        birthDataAndAge.generateAge(),
        fullNameAndGender.generateGender(),
        birthDataAndAge.generateBirthDate(),
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
