import java.io.File
import kotlin.random.Random


fun main() {

    val countPeople = inputCountPeople()
    if (countPeople == 0) {
        println("Введены некорректные данные, работа программы завершена!")
        return
    }

    val people = mutableListOf<Person>()
    val personGenerator = GeneratePerson()
    repeat(countPeople) {
        people.add(personGenerator.generatePerson(choiceGender = Random.nextBoolean()))
    }

    val pdfCreator = CreatePdf()
    pdfCreator.createPdf(fileNamePdf, people)
    println("Файл создан. Путь: ${File(fileNamePdf).absolutePath}")
}
