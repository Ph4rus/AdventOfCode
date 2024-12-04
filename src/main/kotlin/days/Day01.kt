package days

import readInput
import kotlin.time.times

class Day01 {
    fun numberOne(): Int {
        val (l, r) = createListFromInput()
        val left = l.toMutableList()
        val right = r.toMutableList()
        left.sort()
        right.sort()
        var sol = 0
        left.forEachIndexed { index, element ->
            sol += if(element > right[index]){
                element - right[index]
            } else {
                right[index]- element
            }
        }
        return sol
    }

    fun numberOnePartTwo(): Int {
        val (left, right) = createListFromInput()
        return left.sumOf { element ->
            right.count { it == element } * element
        }
    }

    private fun createListFromInput(): Pair<List<Int>,  List<Int>> =
    readInput("Day01").
    map { it.replace("\uFEFF", "").split(" ")  }.
    map { it.first().toInt() to it.last().toInt() }.
    unzip()
}