import java.io.File

class FileIo : IO {
    override fun read() : String {
        return File("input.txt").inputStream().readBytes().toString(Charsets.UTF_8)
    }

    override fun write(data: String) {
        File("output.txt").writeText(data)
    }
}
