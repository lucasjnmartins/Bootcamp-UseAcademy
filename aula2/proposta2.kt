// Faça um programa que calcule a área de uma figura geométrica. 
// Aceite quatro tipos de figura geométrica: quadrado, retângulo, 
// triângulo e círculo. Use herança e polimorfismo.

fun main () {
    println("Calculos com polimorfismo: ")
    val square = Square(4.0)
    println("Área do quadrado: ${calculateArea(square)}")
    val rect = Rectangle(4.0, 2.0)
    println("Área do retângulo: ${calculateArea(rect)}")
    val tri = Triangle(3.0, 6.0)
    println("Área do triângulo: ${calculateArea(tri)}")
    val circ = Circle(5.0)
    println("Área do circulo: ${calculateArea(circ)}")
    println("")
    println("Calculos com herança: ")
    val square2 = SquareH(4.0)
    println("Área do quadrado: ${square2.area()}")
    val rect2 = RectangleH(4.0, 2.0)
    println("Área do retângulo: ${rect2.area()}")
    val tri2 = TriangleH(3.0, 6.0)
    println("Área do triângulo: ${tri2.area()}")
    val circ2 = CircleH(5.0)
    println("Área do circulo: ${circ2.area()}")
}

// Polimorfismo
interface Polygon {
    fun area() : Double
}
class Square (val side: Double) : Polygon {
    override fun area() : Double {
        return side*side
    }
}
class Rectangle (val side1: Double, val side2: Double) : Polygon {
    override fun area() : Double {
        return side1*side2
    }
}
class Triangle (val base: Double, val height: Double) : Polygon {
    override fun area() : Double {
        return (base*height)/2
    }
}
class Circle (val radius: Double) : Polygon {
    override fun area() : Double {
        return (Pi.Companion.PI)*(radius*radius) 
    }
}
fun calculateArea (pol: Polygon) : Double {
    return pol.area()
}

//Herança
abstract class Area() {
    abstract fun area() : Double
}
class SquareH (val side: Double) : Area() {
    override fun area() : Double {
        return side*side
    }
}
class RectangleH (val side1: Double, val side2: Double) : Area() {
    override fun area() : Double {
        return side1*side2
    }
}
class TriangleH (val base: Double, val height: Double) : Area() {
    override fun area() : Double {
        return (base*height)/2
    }
}
class CircleH (val radius: Double) : Area() {
    override fun area() : Double {
        return (Pi.Companion.PI)*(radius*radius) 
    }
}

class Pi private constructor() {
    companion object {
        const val PI  = 3.14159265359
    }
}