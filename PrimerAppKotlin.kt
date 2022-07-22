// // No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------


fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var i:Int = 0
    val finalList = ArrayList<ItemData>()
    
    if (inputList == null) return null
    
    for (element in inputList){
        var Pos = i
        i = i+1
        
        if(element != null){
            val element2 = when (element) {
                is Int -> {
                   when{
                        element%10==0 ->  ItemData(Pos, element, "entero", "M10")
                        element%5 == 0 -> ItemData(Pos, element, "entero", "M5")
                    	element%2 == 0 -> ItemData(Pos, element, "entero", "M2")
                        else -> ItemData(Pos, element, "entero", null)
                    }
                }
                is String ->{
                    ItemData(Pos, element, "cadena","L" + element.length)} 
                
                is Boolean ->{
                    ItemData(Pos, element, "booleano",if (element) "Verdadero" else "False")}
                
                else -> { 
                    ItemData(Pos, element,null, null)}
            }
        finalList.add(element2)
        }
    }
    return finalList
}