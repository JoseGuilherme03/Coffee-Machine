package machine

class MaquinaDeCafe(
    var agua: Int = 400,
    var leite: Int = 540,
    var cafe: Int = 120,
    var copos: Int = 9,
    var dinheiro: Int = 550
) {


    fun compraCafe(bebida: Bebida): String {
        return when {
            this.agua < bebida.agua -> "Sorry, not enough water!"
            this.leite < bebida.leite -> "Sorry, not enough milk!"
            this.cafe < bebida.cafe -> "Sorry, not enough coffee beans!"
            this.copos < 1 -> "Sorry, not enough disposable cups!"
            else -> {
                this.agua -= bebida.agua
                this.leite -= bebida.leite
                this.cafe -= bebida.cafe
                this.copos--
                this.dinheiro += bebida.preco
                "I have enough resources, making you a coffee!"
            }
        }
    }


    private fun reabasteceMaquina() {
        println("Write how many ml of water you want to add: ")
        val aguaAdd = readln().toInt()
        println("Write how many ml of milk you want to add: ")
        val leiteAdd = readln().toInt()
        println("Write how many grams of coffee beans you want to add: ")
        val cafeAdd = readln().toInt()
        println("Write how many disposable cups you want to add: ")
        val coposAdd = readln().toInt()
        this.agua += aguaAdd
        this.leite += leiteAdd
        this.cafe += cafeAdd
        this.copos += coposAdd
    }


    private fun recolheDinheiro() {
        this.dinheiro = 0
    }


    private fun statusMaquinaCafe() {
        println("""
        The coffee machine has:
        ${this.agua} ml of water
        ${this.leite} ml of milk
        ${this.cafe} g of coffee beans
        ${this.copos} disposable cups
        $${this.dinheiro} of money
        """.trimIndent()
        )
    }


    private fun menu() {
        while (true){
            println("Write action (buy, fill, take, remaining, exit): ")
            val acao = readln()
            if (acao == "exit") break

            when (acao) {
                "buy" -> {
                    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: , back - to main menu: ")
                    val tipoCafe = readln()

                    if (tipoCafe == "back") continue

                    compraCafe(Bebida.values()[tipoCafe.toInt() - 1])
                }

                "fill" -> { reabasteceMaquina() }

                "take" -> { println("I gave you $${this.dinheiro}") ; recolheDinheiro() }

                "remaining" -> {statusMaquinaCafe()}
            }
        }

    }


    fun getMenu() {
        return menu()
    }
}