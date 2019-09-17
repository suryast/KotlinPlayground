package au.com.nig.coffeemachine

import java.math.BigDecimal

interface IResponse

data class Message(val msg: String) : IResponse

abstract class Drink(val amt: BigDecimal) : IResponse
data class Tea(val sugars: Int = 0, val stick: Boolean = false) : Drink(BigDecimal.valueOf(0.4))
data class Coffee(val sugars: Int = 0, val stick: Boolean = false) : Drink(BigDecimal.valueOf(0.6))
data class HotChocolate(val sugars: Int = 0, val stick: Boolean = false) : Drink(BigDecimal.valueOf(0.5))

object Drinks {
    fun getOrderedDrink(order: Order): Drink {
        val sugars = order.getSecondPartOfTheOrder().toIntOrNull() ?: 0
        val stick = sugars > 0
        return when (val type = order.getOrderType()) {
            "t" -> Tea(sugars, stick)
            "h" -> HotChocolate(sugars, stick)
            "c" -> Coffee(sugars, stick)
            else -> throw IllegalDrinkException("$type is an not an accepted drink type")
        }
    }
}