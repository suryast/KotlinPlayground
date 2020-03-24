package au.com.nig.kotlin.collections
object BasicListOperations {
    fun transformIntInStrings(myList: List<Int>): List<String> {
        return myList.map { it.toString() }
    }
    fun keepOnlyEvenNumbers(myList: List<Int>): List<Int> {
        return myList.filter {  it % 2 == 0}
    }
    fun transformInListOfChars(myList: List<String>): List<Char> {
        return myList.flatMap { str -> str.toCharArray().toList() }
    }
    fun keepOnlyNonNullNumbers(myList: List<Int?>): List<Int> {
        return myList.filterNotNull()
    }
    fun sumNumbers1(myList: List<Int>): Int {
        return myList.sum()
    }
    fun sumNumbers2(myList: List<Int>): Int {
        return myList.reduce { acc, i -> acc + i }
    }
    fun getFirstNumber(myList: List<Int>): Int {
        return myList.first()
    }
    fun getLastNumber(myList: List<Int>): Int {
        return myList.last()
    }
    fun getNumber(myList: List<Int>, i: Int): Int {
        return myList.get(i)
    }
    fun modify(myList: List<Int>): List<Int> {
//        val temp = myList.filter { it != 2 }
//        return temp.plus(10)
        val temp = myList.toMutableList()
        temp.remove(2)
        temp.add(10)
        return temp
    }
}