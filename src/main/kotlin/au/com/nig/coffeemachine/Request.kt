package au.com.nig.coffeemachine

import java.math.BigDecimal

data class Request(val order: String, val amt: BigDecimal = BigDecimal.ZERO)