package au.com.nig.coffeemachine

interface IResponse

data class Message(val msg: String) : IResponse

interface Drink : IResponse
data class Tea(val sugars: Int = 0, val stick: Boolean = false) : Drink
data class Coffee(val sugars: Int = 0, val stick: Boolean = false) : Drink
data class HotChocolate(val sugars: Int = 0, val stick: Boolean = false) : Drink
