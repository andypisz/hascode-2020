import java.io.File

fun getLinesOfFile(fileName: String): List<String> {
    return File(fileName).readLines()
}

fun writeFile(fileContent: String) {
    File("out/output").writeText(fileContent)
}

class Main {
}
fun main() {
    println(getLinesOfFile("in/a_example.in"))
    writeFile("test")
}