fun main() {
    println("Выберите тип IO:\n" +
            "1. Console\n" +
            "2. File")

    val input : Int

    try {
        input = readln().toInt()
    }
    catch (e: NumberFormatException)
    {
        println("Некорректный ввод")
        main()
        return
    }

    val io : IO = when (input) {
        1 -> ConsoleIo()
        2 -> FileIo()
        else -> {
            println("Некорректный ввод")
            main()
            return
        }
    }

    val data = io.read()

    io.write(count(data))
}

fun count(data : String) : String
{
    var result = ""
    val rows = data.lines()
    for (item: String in rows) {
        if (item.isEmpty()) continue

        val first : Int
        val second : Int
        val temp : String

        try {
            val numbers = item.replace("\\s".toRegex(), "").split("\\D".toRegex())
            val operator : Char = item.filterNot { it.isDigit() || it.isWhitespace() }.first()

            first = numbers[0].toInt()
            second = numbers[1].toInt()

            temp = when (operator) {
                '+' -> (first + second).convert(4).toString()
                '-' -> (first - second).convert(4).toString()
                '*' -> (first * second).convert(4).toString()
                '/' -> (first / second).convert(4).toString()
                else -> throw Exception()
            }
        }
        catch (e: Exception)
        {
            result += "Неверный формат выражения\n"
            continue
        }

        result += temp + "\n"
    }
    return result
}
