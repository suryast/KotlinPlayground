package au.com.nig.coffeemachine

import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object DrinksTest : Spek({
    describe("Barista receives an invalid order") {
        it("should throw an IllegalDrinkException") {
            // GIVEN
            val invalidOrder = "W:"

            // THEN
            val exception = Assertions.assertThrows(IllegalDrinkException::class.java) {
                Drinks.getOrderedDrink(Order(invalidOrder))
            }
            Assertions.assertEquals("w is an not an accepted drink type", exception.message)
        }
    }

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
        describe("of making an orange juice") {
            it("returns an orange juice") {
                // GIVEN
                val order = "O::"

                // WHEN
                val result = Drinks.getOrderedDrink(Order(order))

                // THEN
                Assertions.assertTrue(result is Orange)
            }
        }
        describe("of an extra hot tea") {
            it("returns an extra hot tea") {
                // GIVEN
                val order = "Th::"

                // WHEN
                val result = Drinks.getOrderedDrink(Order(order)) as Tea

                // THEN
                Assertions.assertTrue(result.extraHot)
            }
        }
        describe("of an extra hot Chocolate") {
            it("returns an extra Chocolate") {
                // GIVEN
                val order = "Hh::"

                // WHEN
                val result = Drinks.getOrderedDrink(Order(order)) as HotChocolate

                // THEN
                Assertions.assertTrue(result.extraHot)
            }
        }
        describe("of an extra hot coffee") {
            it("returns an extra hot coffee") {
                // GIVEN
                val order = "Ch::"

                // WHEN
                val result = Drinks.getOrderedDrink(Order(order)) as Coffee

                // THEN
                Assertions.assertTrue(result.extraHot)
            }
        }
    }
})