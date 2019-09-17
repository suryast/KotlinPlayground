package au.com.nig.coffeemachine

import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal

object BaristaTest : Spek({
    describe("Barista receives an order") {
        describe("of making a tea") {
            it("returns a Tea without sugar and stick") {
                // GIVEN
                val order = "T::"
                val request = Request(Order(order), BigDecimal.valueOf(0.6))
                // WHEN
                val result = Barista.makeBeverage(request) as Tea

                // THEN
                Assertions.assertEquals(0, result.sugars)
                Assertions.assertFalse(result.stick)


            }
        }
        describe("of making a tea with sugar and stick") {
            it("returns a Tea with right amount of sugar and a stick") {
                // GIVEN
                val order = "T:3:"
                val request = Request(Order(order), BigDecimal.valueOf(0.6))
                // WHEN
                val result: Tea = Barista.makeBeverage(request) as Tea

                // THEN
                Assertions.assertEquals(3, result.sugars)
                Assertions.assertTrue(result.stick)

            }
        }
        describe("of making a Coffee with no sugar") {
            it("returns a Coffee with no sugar and no stick") {
                // GIVEN
                val order = "C::"
                val request = Request(Order(order), BigDecimal.valueOf(0.6))
                // WHEN
                val result = Barista.makeBeverage(request) as Coffee

                // THEN
                Assertions.assertEquals(0, result.sugars)
                Assertions.assertFalse(result.stick)

            }
        }
        describe("of making a Coffee with sugars and stick") {
            it("returns a Coffee with 1 sugar and a stick") {
                // GIVEN
                val order = "C:1:"
                val request = Request(Order(order), BigDecimal.valueOf(0.6))
                // WHEN
                val result = Barista.makeBeverage(request) as Coffee

                // THEN
                Assertions.assertEquals(1, result.sugars)
                Assertions.assertTrue(result.stick)

            }
        }
        describe("of making a hot chocolate with no sugar") {
            it("returns a hot chocolate with no sugar and no stick") {
                // GIVEN
                val order = "H::"
                val request = Request(Order(order), BigDecimal.valueOf(0.6))
                // WHEN
                val result = Barista.makeBeverage(request) as HotChocolate

                // THEN
                Assertions.assertEquals(0, result.sugars)
                Assertions.assertFalse(result.stick)
            }
        }
        describe("of making a hot chocolate with sugars and stick") {
            it("returns a hot chocolate with 1 sugar and a stick") {
                // GIVEN
                val order = "H:1:"
                val request = Request(Order(order), BigDecimal.valueOf(0.6))
                // WHEN
                val result = Barista.makeBeverage(request) as HotChocolate

                // THEN
                Assertions.assertEquals(1, result.sugars)
                Assertions.assertTrue(result.stick)
            }
        }
    }
    describe("The barista receives a message") {
        it("should send back the message") {
            // GIVEN
            val order = "M:message-content"
            val request = Request(Order(order))
            // WHEN
            val result = Barista.makeBeverage(request) as Message

            // THEN
            Assertions.assertEquals("message-content", result.msg)
        }
    }

    describe("Barista receives an order of making a hot chocolate with sugars and stick and the right amount") {
        it("returns a hot chocolate with 1 sugar and a stick") {
            // GIVEN
            val order = "H:1:"
            val request = Request(Order(order), BigDecimal.valueOf(0.6))

            // WHEN
            val result = Barista.makeBeverage(request) as HotChocolate

            // THEN
            Assertions.assertEquals(1, result.sugars)
            Assertions.assertTrue(result.stick)
        }
    }
    describe("Barista receives an order of making a hot chocolate AND NOT the right amount") {
        it("returns a message telling the missing amount") {
            // GIVEN
            val order = "H:1:"
            val request = Request(Order(order), BigDecimal.valueOf(0.4))

            // WHEN
            val result = Barista.makeBeverage(request) as Message

            // THEN
            Assertions.assertEquals("Your order is missing $0.1", result.msg)
        }
    }
    describe("Barista receives an order of making a COFFEE AND NOT the right amount") {
        it("returns a message telling the missing amount") {
            // GIVEN
            val order = "C:1:"
            val request = Request(Order(order), BigDecimal.valueOf(0.5))

            // WHEN
            val result = Barista.makeBeverage(request) as Message

            // THEN
            Assertions.assertEquals("Your order is missing $0.1", result.msg)
        }
    }
    describe("Barista receives an order of making a Tea AND NOT the right amount") {
        it("returns a message telling the missing amount") {
            // GIVEN
            val order = "T:1:"
            val request = Request(Order(order), BigDecimal.valueOf(0.3))

            // WHEN
            val result = Barista.makeBeverage(request) as Message

            // THEN
            Assertions.assertEquals("Your order is missing $0.1", result.msg)
        }
    }
})