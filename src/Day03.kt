fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach { rucksack ->
            val pack1 = rucksack.take(rucksack.length/2).toSet()
            val pack2 = rucksack.takeLast(rucksack.length/2).toSet()
            val common = pack1.filter { pack2.contains(it) }.toSet()
            common.forEach {
                if (it.code >= 97){
                    sum += (it.code - 96)
                }else if (it.code < 97){
                    sum += (it.code - 65 + 27)
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        var idx = 0
        for (i in 0 until input.size/3){
            val pack1 = input[idx++].toSet()
            val pack2 = input[idx++].toSet()
            val pack3 = input[idx++].toSet()
            val common = pack1.filter { pack2.contains(it) }.filter { pack3.contains(it) }.toSet()
            common.forEach {
                if (it.code >= 97){
                    sum += (it.code - 96)
                }else if (it.code < 97){
                    sum += (it.code - 65 + 27)
                }
            }
        }
        return sum
    }
    
    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
