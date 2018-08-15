

fun main(args : Array<String>) {

    val tree = populateTree()
    tree.print(tree.root)

//    tree.find(14).print()
//    tree.findRecursive(14, tree.root).print()
//    tree.sortSmallToLarge(tree.root) {}
//    tree.sortLargeToSmall(tree.root) {}

//    getBranchesDeep(5, tree)
//    tree.findParent(8, tree.root).print()
//    findCousins(4, tree)

}

fun populateTree(): Tree {
    val values = arrayListOf(3,7,4,6,5,1,10,15,2,9,13,8)
//    val values = arrayListOf(7,5,10,3,6,8,12)
    val tree = Tree()
    for (value in values){
        tree.add(value)
    }
    return tree
}

fun getBranchesDeep(value: Int, tree: Tree){
    println("Branches Deep = ${tree.findBranchesDeep(value)}")
}

fun findCousins(cousinsOf: Int, tree: Tree){
    println("Sum of Cousins: ${tree.findCousinSum(tree.findBranchesDeep(cousinsOf), -1, tree.root, 0,
            tree.findParent(cousinsOf, tree.root).value)}")
}