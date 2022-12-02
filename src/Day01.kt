import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var sum = 0
        input.forEach{ calories ->
            if (calories == ""){
                max = max(max, sum)
                sum = 0
            }else{
                sum += calories.toInt()
            }
        }
        return max(max, sum)
    }

    fun part2(input: List<String>): Int {
        val caloriesList = arrayListOf<Int>()
        var sum = 0
        input.forEach{ calories ->
            if (calories == ""){
                caloriesList.add(sum)
                sum = 0
            }else{
                sum += calories.toInt()
            }
        }
        caloriesList.add(sum)
        return caloriesList.sortedDescending().take(3).sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
