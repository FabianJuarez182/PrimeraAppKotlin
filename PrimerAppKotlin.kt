/**
 * *Copyright (C), 2022-2023, Fabian Juarez Tello (FabianJuarez182)
    * @author   Fabian Juarez Tello
    * FileName: DataListItemIdentification
    @version: I
    - Creation: 15/07/2022
    - Last modification: 22/07/2022
 */

//  No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
// -----------------------

// Main function
fun main() {
    val result = processList(listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0))
    println(result)
}
// Process list function for use in data splitting
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
                        element%10==0 ->  ItemData(Pos, element, "entero", "M10") //item creation
                        element%5 == 0 -> ItemData(Pos, element, "entero", "M5") //item creation
                    	element%2 == 0 -> ItemData(Pos, element, "entero", "M2") //item creation
                        else -> ItemData(Pos, element, "entero", null) //item creation
                    }
                }
                is String ->{
                    ItemData(Pos, element, "cadena","L" + element.length)}  // item creation
                
                is Boolean ->{
                    ItemData(Pos, element, "booleano",if (element) "Verdadero" else "Falso")} // item creation
                
                else -> { 
                    ItemData(Pos, element,null, null)} // item creation
            }
        // Addition of the element in the class
        finalList.add(element2)
        }
    }
    // The final list will be returned with the data already evaluated.
    return finalList
}