class ConsoleIo : IO {
    override fun read() : String {
        print("Введите выражение в формате (x \"знак\" y): ")
        var data : String = ""

        while (true)
        {
            val text = readln()
            if (text == "stop") break
            data += text + "\n";
        }

        return data
    }

    override fun write(data : String) {
        val rows = data.lines()
        rows.forEach { println(it) }
    }
}
