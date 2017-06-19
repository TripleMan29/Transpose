import org.junit.Test
import org.junit.Assert.*
import java.io.*
import java.util.stream.Collectors
import java.nio.file.Paths
import java.util.*


class Test {

    @Throws(IOException::class)
    private fun assertFileContent(file: String, expectedContent: String) {
        val bufferedReader = BufferedReader(FileReader(file))
        val content = bufferedReader.lines().collect(Collectors.joining("\n"))
        assertEquals(expectedContent, content)
    }

    @Test
    fun transposeTest() {
        val transposeTest1 = Transpose(0, false, false)
        transposeTest1.transpose(Scanner(Paths.get("files/iFile.txt")), PrintWriter("files/oFile.txt"))
        assertFileContent("files/oFile.txt",
                "A D \n" +
                        "B E \n" +
                        "C   ")
        val transposeTest2 = Transpose(10, true, false)
        transposeTest2.transpose(Scanner(Paths.get("files/iFile.txt")), PrintWriter("files/oFile.txt"))
        assertFileContent("files/oFile.txt",
                "         A          D \n" +
                        "         B          E \n" +
                        "         C            ")
        val transposeTest3 = Transpose(1, false, true)
        transposeTest3.transpose(Scanner(Paths.get("files/iFile2.txt")), PrintWriter("files/oFile.txt"))
        assertFileContent("files/oFile.txt",
                "2 4   \n" +
                        "2 6   \n" +
                        "3 5   \n" +
                        "  1   ")
    }

    @Test
    fun transposeLauncherTest() {
        val t = TransposeLauncher()
        val args1 = arrayOf("files/iFile.txt", "-o", "files/oFile3.txt")
        t.launch(args1)
        assertFileContent("files/oFile3.txt",
                "A D \n" +
                        "B E \n" +
                        "C   ")
        val args2 = arrayOf("files/iFile.txt", "-o", "files/oFile3.txt", "-r")
        t.launch(args2)
        assertFileContent("files/oFile3.txt",
                "         A          D \n" +
                        "         B          E \n" +
                        "         C            ")
        val args3 = arrayOf("files/iFile2.txt", "-o", "files/oFile3.txt", "-a", "1", "-t")
        t.launch(args3)
        assertFileContent("files/oFile3.txt",
                "2 4   \n" +
                        "2 6   \n" +
                        "3 5   \n" +
                        "  1   ")
    }

}