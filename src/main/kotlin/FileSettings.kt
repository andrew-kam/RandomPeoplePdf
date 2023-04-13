data class FileSettings(
    val pageWidth: Float = 100f,
    val fontPath: String = "src/main/resources/fonts/arial.ttf",
    val fontSize: Float = 4f,
    val fileName: String = "people.pdf",
    val fileHeader: List<String> = listOf(
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
)
