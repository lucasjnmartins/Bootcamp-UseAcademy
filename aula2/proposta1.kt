// Faça	 um programa para controle de empréstimo de livros, 
// com as classes Empréstimo, Livro e Pessoa.

fun main() {
    val p1 = People("Lucas", "999.999.999-99")
    val l1 = Book("Quem é você Alasca", 7070)    
    val e1 = Emprestimo(p1, l1, 5)
    
    e1.situation()
    e1.newDay()
    e1.newDay()
    e1.newDay()
    e1.newDay()
    e1.newDay()
    e1.situation()
    e1.newDay()
    e1.newDay()
    e1.newDay()
    e1.newDay()
    e1.newDay()
    e1.situation()
}

data class People(
    val name: String, 
    val cpf: String
)

data class Book(
    val title: String, 
    val code: Int
)

class Emprestimo(val p: People, val l: Book, var period: Int) {
    var days: Int = 0
    
    fun newDay () {
        period--
    }
    
    fun situation () {
        if (period > 0) {
            println("O locador ${p.name} está dentro do prazo de uso do livro ${l.title}.")
        } else if(period == 0) {
            println("O locador ${p.name} deve devolver o livro ${l.title} hoje!")
        } else {
            days = (-1) * period
            println("O locador ${p.name} deveria ter devolvido o livro ${l.title} a ${days} dias.")
        }
    }
}