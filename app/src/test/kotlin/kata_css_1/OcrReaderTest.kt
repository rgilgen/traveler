/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata_css_1

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class OcrReaderTest {

    val ocrReader = OcrReader()

    @Test
    fun `GIVEN file WHEN reading THEN return string representation`() {
        val lines = getResourceAsText("src/test/resources/ocr_input_story1.txt")

        assertNotNull(lines)
    }

    @Test
    fun `GIVEN lines WHEN tonkenizeAccounts is called THEN return lines representing accounts`() {
        val lines = getResourceAsText("src/test/resources/ocr_input_story1.txt")
        val expectedTokenAccount: List<TokenAccount> = listOf(TokenAccount(lines.take(3)))
        val actualTokenAccounts: List<TokenAccount> = ocrReader.tokenizeAccounts(lines);

        assertEquals(expectedTokenAccount, actualTokenAccounts)
    }

    @Test
    fun `GIVEN tokenAccount WHEN parsing the TokenNumbers THEN return the correct amount of TokenNumbers`() {
        val tokenAccount = TokenAccount(
            lines = listOf(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|"
            )
        )
        val actualTokenNumbers = tokenAccount.parseTokenNumbers()

        assertEquals(9, actualTokenNumbers.size)
    }

    @Test
    fun `GIVEN tokenAccount WHEN parsing the TokenNumbers THEN return the correct account number`() {
        val tokenAccount = TokenAccount(
            lines = listOf(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|"
            )
        )
        val expectedAccount = 123456789
        val actualAccount = tokenAccount.getAccountNumber()

        assertEquals(expectedAccount, actualAccount)
    }

    @Test
    fun `GIVEN file with two accounts WHEN parsing the account THEN return the two correct account numbers`() {
        val lines = getResourceAsText("src/test/resources/ocr_input_story1_several_accounts.txt")
        val expectedAccounts = listOf(123456789, 129457789)

        val actualReadAccounts = ocrReader.readAccountsFromInput(lines)

        assertEquals(expectedAccounts, actualReadAccounts)
    }

    @Test
    fun `GIVEN valid account WHEN validating THEN return true`() {
        val accountNumbers = listOf(3, 4, 5, 8, 8, 2, 8, 6, 5)

        val validAccount = validateAccountNumbers(accountNumbers)

        assertTrue(validAccount)
    }

    private fun getResourceAsText(path: String): List<String> =
        File(path).readLines()

}
