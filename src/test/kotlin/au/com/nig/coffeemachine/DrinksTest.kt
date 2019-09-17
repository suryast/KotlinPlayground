package au.com.nig.coffeemachine

import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object DrinksTest : Spek ({
    describe("Barista receives an order") {
        describe("of making a tea") {
            it("returns a Tea without sugar and stick") {
                // GIVEN
                val order = "T::"
                
                // WHEN
                val result = Drinks.getOrderedDrink(Order(order)) as Tea

                // THEN
                Assertions.assertEquals(0, result.sugars)
                Assertions.assertFalse(result.stick)
            }
        }
        describe("of making a tea with sugar and stick") {
            it("returns a Tea with right amount of sugar and a stick") {
                // GIVEN
                val order = "T:3:"
                
                // WHEN
                val result: Tea = Drinks.getOrderedDrink(Order(order)) as Tea

                // THEN
                Assertions.assertEquals(3, result.sugars)
                Assertions.assertTrue(result.stick)

            }
        }
        describe("of making a Coffee with no sugar") {
            it("returns a Coffee with no sugar and no stick") {
                // GIVEN
                val order = "C::"
                
                // WHEN
                val result = Drinks.getOrderedDrink(Order(order)) as Coffee

                // THEN
                Assertions.assertEquals(0, result.sugars)
                Assertions.assertFalse(result.stick)

            }
        }
        describe("of making a Coffee with sugars and stick") {
            it("returns a Coffee with 1 sugar and a stick") {
                // GIVEN
                val order = "C:1:"
                
                // WHEN
                val result = Drinks.getOrderedDrink(Order(order)) as Coffee

                // THEN
                Assertions.assertEquals(1, result.sugars)
                Assertions.assertTrue(result.stick)

            }
        }
        describe("of making a hot chocolate with no sugar") {
            it("returns a hot chocolate with no sugar and no stick") {
                // GIVEN
                val order = "H::"
                
                // WHEN
                val result = Drinks.getOrderedDrink(Order(order)) as HotChocolate

                // THEN
                Assertions.assertEquals(0, result.sugars)
                Assertions.assertFalse(result.stick)
            }
        }
        describe("of making a hot chocolate with sugars and stick") {
            it("returns a hot chocolate with 1 sugar and a stick") {
                // GIVEN
                val order = "H:1:"
                
                // WHEN
                val result = Drinks.getOrderedDrink(Order(order)) as HotChocolate

                // THEN
                Assertions.assertEquals(1, result.sugars)
                Assertions.assertTrue(result.stick)
            }
        }
    }
})