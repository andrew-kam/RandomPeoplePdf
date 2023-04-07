fun main() {

    println("Введите количество людей ($minCountPeoples-$maxCountPeoples):")
    val countPeoples = readlnOrNull()?.toIntOrNull() ?: 0
    if (countPeoples < minCountPeoples || countPeoples > maxCountPeoples) {
        println("Некорректное количество людей!")
        return
    }

    println("Введите путь для сохранения файла\n(например D:\\TempPdf\\people.pdf):")
    val filePath = readlnOrNull() ?: ""
    if (filePath.isEmpty()) {
        println("Путь не может быть пустым!")
        return
    }

}

