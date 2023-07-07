/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kata_css_1

class OcrReader {
    fun tokenizeAccounts(lines: List<String>): List<TokenAccount> {
        return lines.chunked(4)
            .map {
                if (it.size > 3) {
                    it.dropLast(1)
                } else {
                    it
                }
            }
            .map { TokenAccount(it) }
    }

    fun readAccountsFromInput(lines: List<String>): List<Int> {
        return tokenizeAccounts(lines).map { it.parseAccount() }
    }
}

fun main() {
    println(OcrReader())
}
