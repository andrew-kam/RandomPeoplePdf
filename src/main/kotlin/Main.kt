fun main() {

    val countPeople = inputCountPeople()
    if (countPeople == 0) {
        println("Введены некорректные данные, работа программы завершена!")
        return
    }

    val pdfFileSettings = FileSettings(fileName = "people.pdf")

    val headerFilePeople = listOf(
        "Имя",
        "Фамилия",
        "Отчество",
        "Возраст",
        "Пол",
        "Дата рождения",
        "Место рождения",
        "Индекс",
        "Страна",
        "Область",
        "Город",
        "Улица",
        "Дом",
        "Квартира"
    )

    val dataGenerator = GenerateDataPerson()

    val fileCreator = CreatePdfFile()

    try {
        fileCreator.createFile(pdfFileSettings, headerFilePeople, dataGenerator, countPeople)
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
