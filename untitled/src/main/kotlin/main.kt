fun main() {
    val commision = calculateCommission("Mastercard", 150_000, 100_000)
    println("Комиссия составит $commision руб")
}


fun calculateCommission(
    cardType: String = "Мир",

    previousTransfers: Int = 0,
    transferAmount: Int,
): Int {

    if (transferAmount > 150_000) {
        println("Сумма перевода не может превышать 150 000 рублей за сутки.")
        return -1
    }



    if (previousTransfers + transferAmount > 600_000) {
        println("Сумма переводов за месяц не может превышать 600 000 рублей.")
        return -1
    }


    var commission = 0


    when (cardType) {
        "Mastercard" -> {

            if (previousTransfers > 75_000){
                commission = (transferAmount * 0.006).toInt() + 20
            } else if (transferAmount + previousTransfers > 75_000){
                commission = ((transferAmount + previousTransfers - 75_000) * 0.006).toInt() +20
            } else if (transferAmount + previousTransfers <= 75_000){
                commission = 0
            }

        }


        "Visa" -> {

            commission = (transferAmount * 0.0075).toInt()
            if (commission < 35) {
                commission = 35
            }
        }

        "Мир" -> {

            commission = 0
        }

        else -> {
            println("Неизвестный тип карты.")
            return -1
        }
    }

    return commission
}