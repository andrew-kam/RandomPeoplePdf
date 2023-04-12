fun main() {

    val countPeople = inputCountPeople()
    if (countPeople == 0) {
        println("Введены некорректные данные, работа программы завершена!")
        return
    }

    val fileCreator: CreateFile = CreatePdfFile()
    fileCreator.createFile(countPeople)
}

private fun inputCountPeople(): Int {
    val minCountPeople = 1
    val maxCountPeople = 30
    println("Введите количество человек ($minCountPeople-$maxCountPeople):")
    var countPeople = readlnOrNull()?.toIntOrNull() ?: 0
    if (countPeople < minCountPeople || countPeople > maxCountPeople) {
        countPeople = 0
    }
    return countPeople
}