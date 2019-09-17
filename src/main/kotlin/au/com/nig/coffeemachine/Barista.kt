package au.com.nig.coffeemachine

object Barista {

    fun makeBeverage(request: Request): IResponse {
        val order = request.order
        if (order.getOrderType() == "m")
            return Message(order.getSecondPartOfTheOrder())
        return Drinks.getOrderedDrink(order)
            .let { RequestService.validateDrinkPayment(it, request.amt) }
    }
}

class IllegalDrinkException(msg: String) : Exception(msg)