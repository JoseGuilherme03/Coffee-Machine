package machine

enum class Bebida(val nomeDaBebida:String, val agua:Int, val leite:Int, val cafe:Int, val preco:Int) {
    ESPRESSO("espresso", 250, 0, 16, 4),
    LATTE("latte", 350, 75, 20, 7),
    CAPPUCCINO("cappuccino", 200, 100, 12, 6)
}