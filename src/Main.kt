import java.io.File

fun getLinesOfFile(fileName: String): List<String> {
    println("getting lines of file: $fileName")
    return File(fileName).readLines()
}

fun writeFile(fileContent: String) {
    File("out/output").writeText(fileContent)
}

class Main {
}
fun main() {
    getLinesOfFile("in/a_example.in")
    writeFile("test")
}