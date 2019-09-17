package au.com.nig.coffeemachine

import java.math.BigDecimal

interface IResponse

data class Message(val msg: String) : IResponse

abstract class Drink(val amt: BigDecimal) : IResponse
data class Tea(val sugars: Int = 0, val stick: Boolean = false, val extraHot: Boolean = false) : Drink(BigDecimal.valueOf(0.4))
data class Coffee(val sugars: Int = 0, val stick: Boolean = false, val extraHot: Boolean = false) : Drink(BigDecimal.valueOf(0.6))
data class HotChocolate(val sugars: Int = 0, val stick: Boolean = false, val extraHot: Boolean = false) : Drink(BigDecimal.valueOf(0.5))
class Orange : Drink(BigDecimal.valueOf(0.6))

object Drinks {
    fun getOrderedDrink(order: Order): Drink {
        val sugars: Int = order.getSecondPartOfTheOrder().toIntOrNull() ?: 0
        val stick = sugars > 0
        return when (val type = order.getOrderType()) {
            "t" -> Tea(sugars, stick, order.isExtraHot())
            "h" -> HotChocolate(sugars, stick, order.isExtraHot())
            "c" -> Coffee(sugars, stick, order.isExtraHot())
            "o" -> Orange()
            else -> throw IllegalDrinkException("$type is an not an accepted drink type")
        }
    }
}