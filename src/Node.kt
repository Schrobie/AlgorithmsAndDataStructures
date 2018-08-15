
class Node(var value: Int, var left: Node? = null, var right: Node? = null){

    fun print(){
        println("Value = $value")
        println("Left value = ${left?.value}")
        println("Right value = ${right?.value}")
    }

    fun printValue(){
        println("Value = $value")
    }
}