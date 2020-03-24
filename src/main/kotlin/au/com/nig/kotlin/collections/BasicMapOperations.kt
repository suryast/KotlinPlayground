package au.com.nig.kotlin.collections

object BasicMapOperations {

    fun filterOnKeysAndValuesAndToUpperCaseValues(myMap: Map<Int, String?>, i: Int): Map<Int, String?> {
        return myMap
            .filterValues { value -> value != null }
            .filterKeys { key -> key % 2 == 0}
    }

    fun addElementsToMutableMap(myMap: MutableMap<Int, String>, pair: Pair<Int, String>): MutableMap<Int, String> {
        return myMap.plus(pair).toMutableMap()
    }

    fun addElementsToMap(myMap: Map<Int, String>, pair: Pair<Int, String>): Map<Int, String> {
        return myMap.plus(pair)
    }

    fun removeElementsFromMutableMap(myMap: MutableMap<Int, String>, i: Int): MutableMap<Int, String> {
        myMap.remove(i)
        return myMap
    }

    fun getCharacters(myMap: Map<Int, String>): List<Char> {
        return myMap.flatMap { it.value.toCharArray().toList() }
    }

    fun getKeys(myMap: Map<Int, String>): List<Int> {
         return myMap.keys.toList()
    }

    fun getValues(myMap: Map<Int, String>): List<String> {
        return myMap.values.toList()
    }

    fun setValue(myMap: MutableMap<Int, String>, i: Int, s: String): MutableMap<Int, String> {
        myMap.set(i,s)
        return myMap
    }
}