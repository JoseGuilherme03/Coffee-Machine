package machine

fun main() {
    val maquinaCafe = MaquinaDeCafe()
    maquinaCafe.menu()
}

fun serveCafe() {
    val aguaDisponivel: Int = readLine()!!.toInt()
    val leiteDisponivel: Int = readLine()!!.toInt()
    val cafeDisponivel: Int = readLine()!!.toInt()
    val xicaras: Int = readLine()!!.toInt()

    val maximoXicaras = minOf((aguaDisponivel / 200), (leiteDisponivel / 50), (cafeDisponivel / 15))

    when {
        maximoXicaras > xicaras -> println("Yes, I can make that amount of coffee (and even ${maximoXicaras - xicaras} more than that)")
        maximoXicaras < xicaras -> println("No, I can make only $maximoXicaras cups of coffee")
        else -> println("Yes, I can make that amount of coffee")
    }
}


fun MaquinadeCafe() {
    val numeroDeXicaras = readln().toInt()
    val receitaXicaras = XicaraDeCafe(numeroDeXicaras)


    println(
        """
        For $numeroDeXicaras cups of coffee you will need:
        ${receitaXicaras.agua} ml of water
        ${receitaXicaras.leite} ml of milk
        ${receitaXicaras.cafe} g of coffee beans
        """.trimIndent()
    )
}


fun FazCafe() {
    println(
        """
    Starting to make a coffee
    Grinding coffee beans
    Boiling water
    Mixing boiled water with crushed coffee beans
    Pouring coffee into the cup
    Pouring some milk into the cup
    Coffee is ready!
    """.trimIndent()
    )
}
