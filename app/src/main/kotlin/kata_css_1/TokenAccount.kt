package kata_css_1

data class TokenAccount(val lines: List<String>) {
    fun parseAccount(): Int {
        parseTokenNumbers().map { it.parseNumber() }
        return 0
    }

    fun parseTokenNumbers(): List<TokenNumber> {
        val firstLine = lines.get(0)
        val secondLine = lines.get(1)
        val thirdLine = lines.get(2)
        val result = mutableListOf<TokenNumber>();
        for (i in 0..24 step 3) {
            val element = TokenNumber(
                listOf(
                    firstLine.substring(i, i + 3),
                    secondLine.substring(i, i + 3),
                    thirdLine.substring(i, i + 3)
                )
            )
            result.add(
                element
            )
        }
        return result.toList()
    }
}

class TokenNumber(val lines: List<String>) {
    fun parseNumber() {
        TODO("Not yet implemented")
    }
}
