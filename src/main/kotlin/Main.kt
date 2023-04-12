fun main() {

    val countPeople = inputCountPeople()
    if (countPeople == 0) {
        println("Введены некорректные данные, работа программы завершена!")
        return
    }

    try {
        CreatePdfFile().apply {
            createFile(FileSettings(), GenerateDataPerson(), countPeople)
        }
    } catch (e: Exception) {
        println("Ошибка при создании файла, работа программы завершена!\n${e.message}")
        return
    }
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
