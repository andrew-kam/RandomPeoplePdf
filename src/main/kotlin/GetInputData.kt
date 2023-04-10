fun inputCountPeople(): Int {
    println("Введите количество человек ($minCountPeoples-$maxCountPeoples):")
    var countPeople = readlnOrNull()?.toIntOrNull() ?: 0
    if (countPeople < minCountPeoples || countPeople > maxCountPeoples) {
        countPeople = 0
    }
    return countPeople
}
