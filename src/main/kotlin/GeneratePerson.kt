import kotlin.random.Random
import com.github.javafaker.Faker
import java.util.Locale


class GeneratePerson {

    private val fake = Faker(Locale("ru_RU"))

    fun generatePerson(): Person {

        val fullNameAndGender = generateFullNameAndGender()

        val firstName = fullNameAndGender[0]
        val lastName = fullNameAndGender[1]
        val middleName = fullNameAndGender[2]

        val age = 30

        val gender = fullNameAndGender[3]

//    val birthDate = fake.date().birthday(18, 88)
        val birthDate = "01-01-1970"

        val birthPlace = fake.address().city()
        val postalCode = fake.address().zipCode()
        val country = nameCountry
        val region = generateRegion()

        val city = fake.address().city()
        val street = fake.address().streetName()
        val houseNumber = Random.nextInt(1, 200)
        val apartmentNumber = Random.nextInt(1, 500)

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


    private fun generateFullNameAndGender(): List<String> {
        val fullNameAndGender = mutableListOf<String>()
        if (Random.nextBoolean()) {
            fullNameAndGender.add(firstNamesMan.random())
            fullNameAndGender.add(lastNamesMan.random())
            fullNameAndGender.add(middleNamesMan.random())
            fullNameAndGender.add(male)
        } else {
            fullNameAndGender.add(firstNamesWoman.random())
            fullNameAndGender.add(lastNamesWoman.random())
            fullNameAndGender.add(middleNamesWoman.random())
            fullNameAndGender.add(female)
        }
        return fullNameAndGender
    }

    private fun generateRegion(): String {
        var count = 0
        var fullRegion = listOf<String>()
        while (fullRegion.size != 2 || fullRegion[1] != "область") {
            fullRegion = fake.address().state().split(" ")
        }
        return fullRegion[0]
    }






}
