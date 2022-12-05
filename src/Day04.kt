fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach { section ->
            val s = section.split(",")
            val first = s[0].split("-").map { it.toInt() }
            val second = s[1].split("-").map { it.toInt() }
            if ((first[0] >= second[0] && first[1] <= second[1])
                || (second[0] >= first[0] && second[1] <= first[1]))
                sum++
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach { section ->
            val s = section.split(",")
            var first = s[0].split("-").map { it.toInt() }
            var second = s[1].split("-").map { it.toInt() }
            if (first[0] > second[0]){
                first = second.apply {
                    second = first
                }
            }
            if (first[1] >= second[0]){
                sum++
            }
        }
        return sum
    }
    
    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
