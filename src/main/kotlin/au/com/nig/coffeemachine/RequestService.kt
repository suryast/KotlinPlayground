package au.com.nig.coffeemachine

import java.math.BigDecimal

object RequestService {

    fun validateDrinkPayment(drink: Drink, amt: BigDecimal): IResponse {
        return if (amt >= drink.amt)
            drink
        else
            Message("Your order is missing \$${drink.amt - amt}")
    }
}