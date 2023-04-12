data class FileSettings(
    val pageWidth: Float = 100f,
    val pathFont: String = "src/main/resources/fonts/arial.ttf",
    val fontSize: Float = 4f,
    val fileName: String = "people.pdf",
    val headerFile: List<String> = listOf(
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
