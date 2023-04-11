import java.io.File


fun main() {

    val countPeople = inputCountPeople()
    if (countPeople == 0) {
        println("Введены некорректные данные, работа программы завершена!")
        return
    }

    val people = mutableListOf<Person>()
    repeat(countPeople) {
        people.add(createInstancePerson())
    }

    val pdfCreator = CreatePdf()
    pdfCreator.createPdf(fileNamePdf, people)
    println("Файл создан. Путь: ${File(fileNamePdf).absolutePath}")
}
