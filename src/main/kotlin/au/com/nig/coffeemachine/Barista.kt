package au.com.nig.coffeemachine

object Barista {

    fun makeBeverage(request: Request): IResponse {
        val order = request.order
        if (order.startsWith("M"))
            return Message(order.split(":")[1])
        return Drinks.getOrderedDrink(order)
            .let { RequestService.validateDrinkPayment(it, request.amt) }
    }

}

class IllegalDrinkException(msg: String) : Exception(msg)