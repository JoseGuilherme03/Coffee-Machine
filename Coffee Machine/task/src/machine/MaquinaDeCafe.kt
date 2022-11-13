package machine

class MaquinaDeCafe(
    var agua: Int = 400,
    var leite: Int = 540,
    var cafe: Int = 120,
    var copos: Int = 9,
    var dinheiro: Int = 550
) {

    private fun compraCafe(tipoCafe:Int) {
        val verificaExpresso = agua >= 250 && cafe >= 16 && copos >= 1
        val verificaCafeLeite = agua >= 350 && leite >= 75 && cafe >= 20 && copos >= 1
        val verificaCappuccino = agua >= 200 && leite >= 100 && cafe >= 12 && copos >= 1
        var falta = ""

        when {
            cafe < 12 -> falta += "coffe"
            agua < 200 -> falta += "water"
            leite < 75 -> falta += "milk"
            copos == 0 -> falta += "cups"
        }

        when {
            tipoCafe == 1 && verificaExpresso -> {
                agua -= 250 ;cafe -= 16; dinheiro += 4; copos -= 1
                println("I have enough resources, making you a coffee!")
            }
            tipoCafe == 2 && verificaCafeLeite -> {
                agua -= 350; leite -= 75; cafe -= 20; dinheiro += 7; copos -= 1
                println("I have enough resources, making you a coffee!")
            }
            tipoCafe == 3 && verificaCappuccino -> {
                agua -= 200; leite -= 100; cafe -= 12; dinheiro += 6; copos -=1
                println("I have enough resources, making you a coffee!")
            }
            else -> println("Sorry, not enough $falta!")
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


    fun menu() {
        while (true){
            println("Write action (buy, fill, take, remaining, exit): ")
            val acao = readln()
            if (acao == "exit") break

            when (acao) {
                "buy" -> {
                    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: , back - to main menu: ")
                    val tipoCafe = readln()

                    if (tipoCafe == "back") continue
                    compraCafe(tipoCafe.toInt())
                }

                "fill" -> { reabasteceMaquina() }

                "take" -> { println("I gave you $${this.dinheiro}") ; recolheDinheiro() }

                "remaining" -> {statusMaquinaCafe()}
            }
        }

    }
}