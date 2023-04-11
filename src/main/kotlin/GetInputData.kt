fun inputCountPeople(): Int {
    println("Введите количество человек ($MIN_COUNT_PEOPLE-$MAX_COUNT_PEOPLE):")
    var countPeople = readlnOrNull()?.toIntOrNull() ?: 0
    if (countPeople < MIN_COUNT_PEOPLE || countPeople > MAX_COUNT_PEOPLE) {
        countPeople = 0
    }
    return countPeople
}
