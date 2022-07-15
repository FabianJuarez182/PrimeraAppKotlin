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
        
        var tipo:String? = ""
        var inf:String? = ""
        var Pos = i
        i = i+1
        if(element != null){
            when (element) {
                is Int -> {
                    tipo = "entero"
                    if (element%10 == 0){
                        inf = "M10"
                    }
                    else if (element%5 == 0){
                        inf = "M5"
                    }
                    else if (element%2 == 0){
                        inf = "M2"
                    }
                    else{
                        inf = null
                    }
                }
                is String ->{
                  tipo = "cadena"
                  inf = ("L" + element.length)
                } 
                is Boolean ->{
                    tipo = "booleano"
                    if(element == false){ 
                        inf = "Falso"
                    }

                    else if(element == true){
                        inf ="Verdadero"
                    }
                    else{
                        inf = null
                    } 
                }
                else -> {
                    tipo = null
                    inf = null
                }
            }
        val element2 = ItemData(
            originalPos = Pos,
            originalValue = element,
            type = tipo,
            info = inf 
            
        )
        finalList.add(element2)
        }
    }
    
    return finalList

}