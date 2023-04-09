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
    } catch (e: Exception) {
        println("Ошибка при создании файла.")
        e.printStackTrace()
        return
    }
}
