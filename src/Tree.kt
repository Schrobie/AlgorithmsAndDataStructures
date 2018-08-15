
class Tree(var root: Node? = null){

    fun add(value: Int){
        if (root == null){
            root = Node(value)
            return
        }
        var currentNode = root
        while(true) {
            if (value > currentNode!!.value) {
                if (currentNode.right != null){
                    currentNode = currentNode.right
                    continue
                }
                currentNode.right = Node(value)
                println("adding ${currentNode.right?.value} to right of ${currentNode.value}")
                break
            } else {
                if (currentNode.left != null){
                    currentNode = currentNode.left
                    continue
                }
                currentNode.left = Node(value)
                println("adding ${currentNode.left?.value} to left of ${currentNode.value}")
                break
            }
        }
    }
}