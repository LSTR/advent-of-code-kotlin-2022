fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach { round ->
            val result = round.replace("""[A,X]""".toRegex(), "1")
                            .replace("""[B,Y]""".toRegex(), "2")
                               .replace("""[C,Z]""".toRegex(), "3").split(" ")
                .map { it.toInt() }
            val me = result[1]
            val elf = result[0]
            val r = when (me) {
                elf -> 3 + me
                1 -> if (elf == 2) 0 + me else 6 + me
                2 -> if (elf == 3) 0 + me else 6 + me
                3 -> if (elf == 1) 0 + me else 6 + me
                else -> 0
            }
            sum += r
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach { round ->
            val result = round.replace("""[A,X]""".toRegex(), "1")
                .replace("""[B,Y]""".toRegex(), "2")
                .replace("""[C,Z]""".toRegex(), "3").split(" ")
                .map { it.toInt() }
            val shouldEnd = result[1]
            val elf = result[0]
            val r = when (shouldEnd) {
                1 -> 0 + (if (elf == 1) 3 else if (elf == 2) 1 else 2)
                2 -> 3 + elf
                3 -> 6 + (if (elf == 1) 2 else if (elf == 2) 3 else 1)
                else -> 0
            }
            sum += r
        }
        return sum
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
