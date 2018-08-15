
fun Tree.print(node: Node?){
    if (node == null){
        return
    }
    println("-----------${node.value} Left Check----------")
    node.print()
    print(node.left)

    println("-----------${node.value} Right Check----------")
    node.print()
    print(node.right)
}

fun Tree.find(value: Int): Node {
    var currentNode = root
    while (value != currentNode?.value && currentNode != null) {
        currentNode = if (value > currentNode.value) {
            currentNode.right
        } else {
            currentNode.left
        }
    }
    //node with value doesn't exist
    if (currentNode == null) {
        currentNode = Node(-1, null, null)
    }
    return currentNode
}

tailrec fun Tree.findRecursive(value: Int, node: Node?): Node {
    val nullNode = Node(-1, null, null)
    if (node == null) {
        return nullNode
    }
    return when {
        value > node.value -> this.findRecursive(value, node.right)
        value < node.value -> this.findRecursive(value, node.left)
        value == node.value -> node
        else -> nullNode
    }
}

tailrec fun Tree.sortSmallToLarge(node: Node?, lambda: () -> Unit){
    if (node == null){
        return
    }
    this.sortSmallToLarge(node.left) {node.printValue()}
    node.printValue()
    this.sortSmallToLarge(node.right) {node.printValue()}
}

tailrec fun Tree.sortLargeToSmall(node: Node?, lambda: () -> Unit){
    if(node == null){
        return
    }
    this.sortLargeToSmall(node.right) {node.printValue()}
    node.printValue()
    this.sortLargeToSmall(node.left) {node.printValue()}
}

tailrec fun Tree.findParent(value: Int, node: Node?): Node{
    if (node == null || (node.right == null && node.left == null)){
        return Node(-1, null, null)
    }

    if(value == node.right?.value || value == node.left?.value){
        return node
    } else {
        return when {
            value > node.value -> this.findParent(value, node.right)
            value < node.value -> this.findParent(value, node.left)
            else -> {
                return Node(-1, null, null)
            }
        }
    }
}

fun Tree.findBranchesDeep(value: Int): Int{
    var branchesDeep = 0
    var currentNode = root
    while (currentNode != null && value != currentNode.value){
        currentNode = if (value > currentNode.value){
            branchesDeep++
            currentNode.right
        } else {
            branchesDeep++
            currentNode.left
        }
    }
    //node with value doesn't exist
    if (currentNode == null) {
        branchesDeep = -1
    }
    return branchesDeep
}

fun Tree.findCousinSum(targetLevel: Int, pastLevel: Int, node: Node?, sumSoFar: Int, parentValue: Int): Int{
    if (node == null){
        return sumSoFar
    }
    var cousinSum = sumSoFar
    val currentLevel = pastLevel+1

    if (node.value == parentValue){
        return cousinSum
    }

    cousinSum += findCousinSum(targetLevel, currentLevel, node.left, sumSoFar, parentValue)
    cousinSum += findCousinSum(targetLevel, currentLevel, node.right, sumSoFar, parentValue)

    if (currentLevel == targetLevel){
        cousinSum += node.value
    }

    return cousinSum
}

