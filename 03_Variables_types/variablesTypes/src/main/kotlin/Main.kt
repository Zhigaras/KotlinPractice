fun main() {
    val firstName: String = "Ilya"
    val lastName: String = "Zhigaras"
    var height: Double = 1.7
    var weight: Float = 65f
    var isChild: Boolean = height < 1.5 || weight <40
    var info: String = """
                       Mi name is $lastName $firstName. 
                       My weight is $weight kg, height - $height meters.
                       Am I a child? $isChild.
                    """
    println(info)
    height = 1.4
    isChild = height < 1.5 || weight <40
    info = """
                       Mi name is $lastName $firstName. 
                       My weight is $weight kg, height - $height meters.
                       Am I a child? $isChild.
                    """
    println(info)


}