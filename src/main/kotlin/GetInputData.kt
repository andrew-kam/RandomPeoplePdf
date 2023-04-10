fun inputCountPeople(): Int {
    println("Введите количество человек ($minCountPeoples-$maxCountPeoples):")
    var countPeople = readlnOrNull()?.toIntOrNull() ?: 0
    if (countPeople < minCountPeoples || countPeople > maxCountPeoples) {
        countPeople = 0
    }
    return countPeople
}

fun inputFilePath(): String {
    println("Введите путь для сохранения файла\n(например D:\\{название папки}\\people.pdf - для Windows\n" +
            "/Users/{имя пользователя}/Downloads/people.pdf - для macOS):")
    return readlnOrNull() ?: ""
}
