package traveler

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

class TavelerKTest {

    val traveler = TravelerKotlin()

    @OptIn(ExperimentalTime::class)
    @Test
    fun testIt() {
        val resourceAsText = getResourceAsText("/bigDataSet.txt")
        // val listOfCityDistances = generatBigDataSet(190, 1, 100)
        val listOfCityDistances = getListOfCitiesFromResources(resourceAsText)
        val cityVisits = 3
        val maxDistance = 230
        val expectedJourneyDistance = 230

        val (actualJourney, elapsed) = measureTimedValue {
            traveler.choose_best_sum(maxDistance, cityVisits, listOfCityDistances.toMutableList())
        }

        println("elapsed time is : ${elapsed.absoluteValue}")
        println("actualJourney is : $actualJourney")
        Assertions.assertEquals(expectedJourneyDistance, actualJourney?.totalDistance)
    }

    private fun getListOfCitiesFromResources(resourceAsText: String?) =
        resourceAsText!!.dropLast(1).drop(1).split(",").map { it.trim() }.map { it.toInt() }.toList()

    private fun generatBigDataSet(
        n: Int,
        rangeStart: Int,
        rangeEnd: Int
    ) = generateRandomList(n, rangeStart, rangeEnd)

    fun generateRandomList(n: Int, rangeStart: Int, rangeEnd: Int): List<Int> =
        List(n) { Random.nextInt(rangeStart, rangeEnd) }
}

fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()