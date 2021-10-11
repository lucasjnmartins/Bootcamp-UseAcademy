//Aula 1: Introdução ao Kotlyn
//Exercício proposto

fun invert(st1: String): String?{
    var aux: String = ""
    
    for(i in (st1.length - 1) downTo 0){
        aux += st1[i]
    }
    
    return aux    
}

fun contVog(st1: String): Int?{
    var cont: Int = 0
    
    for(i in 0 until st1.length){
        when(st1[i]){
            'a'->{
                cont++;
            }
            'e'->{
                cont++;
            }
            'i'->{
                cont++;
            }
            'o'->{
                cont++;
            }
            'u'->{
                cont++;
            }
        }
    }
    
    return cont
}


fun main() {
    var name: String = "Lucas"
    var aux: String?
    var vogs: Int?
    aux = invert(name)
    println("${aux}")
    
    vogs = contVog(name)
    println("Quantidade de vogais ${vogs}")
}