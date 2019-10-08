package au.com.nig.coffeemachine

import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal

object RequestServiceTest : Spek ({
    describe("Barista receives an order of making a hot chocolate with sugars and stick and the right amount") {
        it("returns a hot chocolate with 1 sugar and a stick") {
            // GIVEN
            val amount = BigDecimal.valueOf(0.6)
            val drink = HotChocolate()

            // WHEN
            val result = RequestService.validateDrinkPayment(drink, amount)

            // THEN
            Assertions.assertEquals(drink, result)
        }


    }
    describe("Barista receives an order of making a hot chocolate AND NOT the right amount") {
        it("returns a message telling the missing amount") {
            // GIVEN
            val amount = BigDecimal.valueOf(0.4)
            val drink = HotChocolate()

            // WHEN
            val result = RequestService.validateDrinkPayment(drink, amount) as Message

            // THEN
            Assertions.assertEquals("Your order is missing $0.1", result.msg)
        }
    }
})