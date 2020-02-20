import java.io.File

class Main {
}
fun main() {
    val listOfFileNames = listOf("a_example.txt","b_read_on.txt","c_incunabula.txt","d_tough_choices.txt","e_so_many_books.txt","f_libraries_of_the_world.txt")
    for (fileName in listOfFileNames) {
        processFile(fileName)
    }
}

/**
 * our algorithm, take the list of lines in entry, return the list of lines to write in the file
 */
fun runAlgorithm(listOfLines: List<String>): List<String> {
    val metaDataEntries = readLine(listOfLines[0])

    val numberOfBooks = metaDataEntries[0]
    val numberOfLibraries = metaDataEntries[1]
    val numberOfDays = metaDataEntries[2]
    //println("1: $numberOfBooks - 2: $numberOfLibraries - 3: $numberOfDays")

    val booksScores = readLine(listOfLines[1])
    //println("booksScores: $booksScores")

    val listOfLibraries = mutableListOf<Library>()
    for (lineIndex in 2 until listOfLines.size step 2) {
        //println("$lineIndex / ${listOfLines.size}")
        if(lineIndex < listOfLines.size - 2) {
            val firstLineEntries = readLine(listOfLines[lineIndex])
            val secondLineEntries = readLine(listOfLines[lineIndex+1])
            val listOfBooks = mutableListOf<Book>()
            for (book in secondLineEntries) {
                val id = book.toInt()
                listOfBooks.add(Book(id, booksScores[id].toInt()))
            }
            listOfLibraries.add(Library(lineIndex-2, firstLineEntries[1].toInt(), firstLineEntries[2].toInt(), listOfBooks))
        }
    }
    /*println("got ${listOfLibraries.size} libraries: ")
    println("first one = ${listOfLibraries.first()}")
    println("last one = ${listOfLibraries.last()}")
    println()*/


    //write line with each result
    val result1 = writeLine(listOf())
    val result2 = writeLine(listOf())

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
    if (listOfResults.isNotEmpty()) {
        res += listOfResults.last()
    }
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

class Book(
    val id: Int,
    val score: Int
)

class Library(
    val id: Int,
    val signupTime: Int,
    val bookPerDay: Int,
    val listOfBooks: List<Book>
)
