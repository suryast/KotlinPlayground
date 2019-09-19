package au.com.nig.coffeemachine

import org.junit.jupiter.api.Assertions
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object BaristaTest : Spek({
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
})