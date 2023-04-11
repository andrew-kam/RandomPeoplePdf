fun main() {

    val countPeople = inputCountPeople()
    if (countPeople == 0) {
        println("Введены некорректные данные, работа программы завершена!")
        return
    }

    val fileCreator: CreateFile = CreatePdfFile()
    fileCreator.createFile(countPeople)
}
