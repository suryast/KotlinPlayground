package au.com.nig.coffeemachine

import java.math.BigDecimal

data class Request(val order: Order, val amt: BigDecimal = BigDecimal.ZERO)

data class Order(val order: String) {
    fun getOrderType(): String {
        return order.first().toString().toLowerCase()
    }
    fun getSecondPartOfTheOrder(): String {
        return order.split(":")[1]
    }

    fun isExtraHot(): Boolean {
        return order[1] == 'h'
    }
}
