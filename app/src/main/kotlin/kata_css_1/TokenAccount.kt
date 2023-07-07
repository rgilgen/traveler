package kata_css_1

data class TokenAccount(val lines: List<String>) {

    val accountNumbers: List<Int>

    init {
        accountNumbers = parseTokenNumbers().map { it.parseNumber() }
    }
    
    fun getAccountNumber() : Int {
        val stringRepresentation = accountNumbers.map { it.toString() }.joinToString(separator = "")
        return Integer.parseInt(stringRepresentation)
    }

    fun parseTokenNumbers(): List<TokenNumber> {
        val firstLine = lines[0]
        val secondLine = lines[1]
        val thirdLine = lines[2]
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

    fun parseNumber(): Int {
        val flatRepresentation = lines.joinToString(separator = ",")
        return when (flatRepresentation) {
            "   ,  |,  |" -> 1
            " _ , _|,|_ " -> 2
            " _ , _|, _|" -> 3
            "   ,|_|,  |" -> 4
            " _ ,|_ , _|" -> 5
            " _ ,|_ ,|_|" -> 6
            " _ ,  |,  |" -> 7
            " _ ,|_|,|_|" -> 8
            " _ ,|_|, _|" -> 9
            else -> throw IllegalArgumentException("Not a valid Integer representation: $flatRepresentation")
        }
    }
}


