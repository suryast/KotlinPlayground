package au.com.nig.coffeemachine

object Barista {

    fun makeBeverage(order: String): IResponse? {
        if (order.startsWith("M"))
            return Message(order.split(":")[1])

        val sugars = order.split(":")[1].toIntOrNull() ?: 0
        val stick = sugars > 0

        return when(order.first()) {
            'T' -> Tea(sugars, stick)
            'H' -> HotChocolate(sugars, stick)
            'C' -> Coffee(sugars, stick)
            else -> null
        }
    }
}
