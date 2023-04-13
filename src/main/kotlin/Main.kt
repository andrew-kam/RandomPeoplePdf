fun main() {

    val rangeCountPeople = 1..30

    val countPeople = inputIntNumber(rangeCountPeople)

    if ( countPeople !in rangeCountPeople) {
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

private fun inputIntNumber(rangeNumber: IntRange): Int {

    println("Введите целое число в диапазоне [$rangeNumber]:")

    return readlnOrNull()?.toIntOrNull() ?: 0
}
