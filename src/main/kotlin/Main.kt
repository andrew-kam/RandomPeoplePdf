import java.io.FileNotFoundException
import kotlin.random.Random


fun main() {

    val countPeople = inputCountPeople()
    if (countPeople == 0) {
        println("Введены некорректные данные, работа программы завершена!")
        return
    }

    val filePath = inputFilePath()
    if (filePath.isEmpty()) {
        println("Путь к файлу не может быть пустым, работа программы завершена!")
        return
    }

    val people = mutableListOf<Person>()
    val personGenerator = GeneratePerson()
    repeat(countPeople) {
        people.add(personGenerator.generatePerson(Random.nextBoolean()))
    }

    val pdfCreator = CreatePdf()
    try {
        pdfCreator.createPdf(filePath, people)
        println("Файл создан. Путь: $filePath")
    }
    catch (e: FileNotFoundException) {
        println("Некорректный путь для сохранения файла, работа программы завершена!.")
        return
    }
    catch (e: Exception) {
        println("Ошибка при создании файла.")
        e.printStackTrace()
        return
    }
}
