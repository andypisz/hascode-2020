import java.io.File

class Main {
}
fun main() {
    val listOfFileNames = listOf("a_example.in")
    for (fileName in listOfFileNames) {
        processFile(fileName)
    }
}

/**
 * our algorithm, take the list of lines in entry, return the list of lines to write in the file
 */
fun runAlgorithm(listOfLines: List<String>): List<String> {
    println("test22")
    //get each entry for each line
    val firstLine = listOfLines[0]
    val firstLineEntries = readLine(firstLine)
    val secondLine = listOfLines[1]
    val secondLineEntries = readLine(secondLine)

    //put it in a variable to use later
    val entry1 = firstLineEntries[0]
    val entry2 = firstLineEntries[1]
    val entry3 = secondLineEntries[0]
    val entry4 = secondLineEntries[1]
    val entry5 = secondLineEntries[2]
    val entry6 = secondLineEntries[3]

    //write line with each result
    val result1 = writeLine(listOf(entry1, entry2, entry3))
    val result2 = writeLine(listOf(entry4, entry5, entry6))

    return listOf(result1, result2)
}

/**
 * read the file, run the algorithm and write the output in a file
 */
fun processFile(fileName: String) {
    val inputLines = readFile("in/$fileName")
    writeFile(runAlgorithm(inputLines), fileName)
}

/**
 * get a list of lines for a file
 */
fun readFile(fileName: String): List<String> {
    println("getting lines of file: $fileName")
    return File(fileName).readLines()
}

/**
 * put the list of lines in a file
 */
fun writeFile(listOfLines: List<String>, fileName: String) {
    val content = buildFileContent(listOfLines)
    File("out/$fileName").writeText(content)
}

/**
 * split each line by spaces
 */
fun readLine(line: String): List<String> {
    return line.split(" ")
}

/**
 * build a line = a string with each results separated by a space, without a space after the last result
 */
fun writeLine(listOfResults: List<String>): String {
    var res = ""
    for (i in 0 until listOfResults.size - 1) {
        res += "${listOfResults[i]} "
    }
    res += listOfResults.last()
    return res
}

/**
 * build a file = a string with each line separated by a \n
 */
fun buildFileContent(listOfLines: List<String>): String {
    var result = ""
    for (line in listOfLines) {
        result += "$line\n"
    }
    return result
}

/**
 * Calculate the scoring
 */
fun calculateScoring(listOfResults: List<String>): Int {
    var res = 0
    for (result in listOfResults) {
        res += result.toInt()
    }
    return res
}
