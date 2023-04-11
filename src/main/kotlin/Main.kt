import java.io.File


fun main() {

    val countPeople = inputCountPeople()
    if (countPeople == 0) {
        println("Введены некорректные данные, работа программы завершена!")
        return
    }

    val people = mutableListOf<List<String>>()
    people.add(tableFieldNames)
    repeat(countPeople) {
        people.add(createPerson())
    }

    createPdfFile(fileNamePdf, people)
    println("Файл создан. Путь: ${File(fileNamePdf).absolutePath}")
}
