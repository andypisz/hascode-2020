import java.io.File

class Main {
}
fun main() {
    val lines = getLinesOfFile("in/a_example.in")
    writeFile(lines)
}

fun getLinesOfFile(fileName: String): List<String> {
    println("getting lines of file: $fileName")
    return File(fileName).readLines()
}

fun writeFile(listOfLines: List<String>) {
    val content = buildFileContent(listOfLines)
    File("out/output").writeText(content)
}

fun buildFileContent(listOfLines: List<String>): String {
    var result = ""
    for (line in listOfLines) {
        result += "$line\n"
    }
    return result
}
