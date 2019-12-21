import java.lang.IllegalArgumentException
import java.util.Random
import javax.swing.Painter

fun main(args: Array<String>) {
    // =============== Variables =================
    var varName : String = "Hossein" // Mutable
    val courseName : String = "Programming Languages" // Constant

    // =============== ARRAYS =================
    var myArray = arrayOf(1 , 'a'..'z' , 1.23 , 2.25 , "Lion") ;
    val animal = "Lion"
    //arrays can contain objects with different types like C#

    println("Array Length : ${myArray.size}")
    println("Contain 'z' ? ${myArray.contains(animal)}")
    // get a subset of the following array
    var subset = myArray.copyOfRange(3,5);
    for ( item in subset){
        print("$item  ")
    }
    //get first element of the array
    println("\nFirst Element : ${myArray.first()}")
    //get index of an object
    println("Index of '$animal' = ${myArray.indexOf(animal)}")

    // Lambada in Arrays
    var sqrArray = Array( 5 , {x-> x*x})
    for (item in sqrArray){
        print("$item  ")
    }

    // Type specific Arrays
    var arr2 : Array<Int> = arrayOf(1,2,3,4,5,6);


    //===================== RANGES ========================

    println()
    println("*********  RANGES **********")
    val oneToTen = 1 .. 10
    val alphabets = "A".."Z"
    println("R in Alphabet ? : ${alphabets.contains("R")}")
    val tenToOne = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)

    val rng3 = oneToTen.step(3) // goes from 1 to 10 by 3 steps (1,4,7,10)
    // print all elements in rng3
    for ( x in rng3 ){
        println("rng3 : $x")
    }
    //printing arrayElements in reverse
    for ( x in tenToOne.reversed() ){
        println("Reversed : $x")
    }

    //===================== CONDITIONALS ========================
    println("********** CONDITIONALS **********")
    //Using pure If/Else
    var age = 6
    if ( age < 18){
        println("You are not older than legal age.")
    }
    else if ( age > 18 ){
        println("you shall enter")
    }

    else if ( (age > 8) && (age < 18)){
        println("Not a chance.")
    }
    else{
        println("Go home Son")
    }

    // "When" works as Switch/Case in other languages
    when(age){
        0,1,2,4 -> println("Go to Preschool")
        5 -> println("go to kindergarten")
        in 6 .. 17 -> {
            println("Your Age is $age")
            var difference = 18 - age
            println("You should wait for $difference years to be able to enter.")
        }
        else ->{
            println("Get in ... welcome")
        }
    }

    //========================= LOOPING ================
    println("********** LOOPING **********")
    for ( x in 1..10){
        println("Looooooop : $x")
    }
    //guessing a number with "While Loop"
    val rnd = Random() // creating an object of random class
    val magicNum = rnd.nextInt(50) + 1
    var guess = 0
    while(guess != magicNum){
        guess ++
        println("$guess is Not Equal with $magicNum")
    }
    //determining the Even and Odd numbers
    for ( x in 1..20){
        if ( x % 2 == 0){
            println("$x is Even")
        }
        else{
            println("$x is Odd")
        }
        if ( x == 15 ){
            break
        }
    }

    //Accessing Array Elements
    var arr3 : Array<Int> = arrayOf(7,4,0)
    for ( i in arr3.indices){
        println("Element ($i) : ${arr3[i]} ")
    }

    for ( (index,value) in arr3.withIndex()){
        println("Index -> Value :: $index -> $value")
    }
    println("## Foreach Loop ##")
    //forEach loop :
    arr3.forEach { e -> println("Value <- Index  : $e <- ${arr3.indexOf(e)}") }

    //========================= Functions ================
    println("********* FUNCTIONS *********")
    println("Add Int 1 + 2 -> " + add(1,2).toInt())
    println("Add Float: 2.4 + 3.6 -> ${addFloat(2.4 , 3.6) }")
    //Using name d parameters :
    //named parameters help us ignore the order of the passing arguments.
    println("Add using named Parameters -> " + add(num2 = 8 , num1 = 7))
    val name = "Hossein"
    sayHello(name)

    //returning more than one value
    val ( result1 , result2 ) = nextTwo(7)
    println("One : $result1 | Two : $result2")

    //Passing Unlimited Argumetns :
    println("Sum 1.. 5 : ${getSum(1,2,3,4,5)}")
    println("Sum 1.. 8 : ${getSum(1,2,3,4,5,6,7,8)}")

    //Using Function literals :
    val multiply = { num1 : Int , num2 : Int , num3 :Int -> num1 * num2 * num3}
    println("4 * 5 * 6 -> ${multiply(4,5,6)}")

    // We can use tail-recursion :
    val factNum = 5
    println("Tail-Recursion of Factorial : $factNum -> ${fact(factNum)}")

    //Filter
    val numList = 1 .. 20
    val evenList = numList.filter { it % 2 == 0 }
    evenList.forEach { n -> println(n) }

    //Higher Order function : A function that accepts or returns another Function.
    val mult3 = makeMathFunction(3)
    println("High Order Function -> ${ mult3(5)} " )

    // Filter on List - Type 2 :
    val powerTwoLambda = { num1 : Int -> num1 * num1}
    var testIntList = arrayOf(5 , 6 , 9 , 8)
    functionOnList( testIntList , powerTwoLambda )

    // Default values in function parameters
    insertFamilyInfo("Erfan Sabouri")
    insertFamilyInfo()

    //Method OverLoading
    getInfo("John")
    getInfo("John" , "Wick")

    //========================= Collection Operators ================
    println("********* COLLECTION OPERATORS *********")
    val numList2 = 1..20
    val listSum = numList2.reduce{ x , y -> x + y}
    println("Reduce Sum : $listSum")

    val foldSum = numList2.fold(5){ x , y -> x + y }
    println("foldSum : $foldSum")
    //fold() This function helps to accumulate value starting with initial value, then apply operation from left to right to current accumulator value and each element

    println("Evens : ${numList2.any{it % 2 == 0}}")
    //returns "True" if there exists an even number.

    println("Evens : ${numList2.all { it % 2 == 0 }}")
    //returns "True" if all of the numbers are even.

    val biggerThan3 = numList2.filter { x -> x > 3}
    biggerThan3.forEach{ n -> println("($n) is Bigger than 3")}

    // Map :
    println("## Map ##")
    val times7 = numList2.map{ it * 7}
    times7.forEach{ n -> println(n)}

    //========================= Exception Handling ================
    println("********* Exception Handling *********")
    val divisor = 2
    var dividend = 10
    try{
        if ( divisor == 0) {
            throw  IllegalArgumentException("Can't divide by zero.")
        }else{
            println(" $dividend / $divisor = ${dividend/divisor}")
        }
    }catch (e : IllegalArgumentException){
        println( e.message )
    }

    //========================= Collections ================
    var list1 : MutableList<Int> = mutableListOf(1,2,3,4,5,6)
    val list2 : List<Int> = listOf(2 ,3 , 5 ,6)
    list1.add(9)

    println("1st item out of List -> ${list1.first()}")

    println("last item out of List -> ${list1.last()}")

    println("3rd item out of List -> ${list1[2]}")

    var sublist2 = list2.subList(0,3)
    var sublist1 = list1.subList(0,3)
    // because list2 is readOnly the returned list "sublist2" is also readOnly.
    //you can not clear it
    sublist1.forEach{ n -> println("SubList : $n ")}
    println("Length : ${list1.size}")
    sublist1.clear()
    list1.remove(1)
    list1.removeAt(0)
    list1[2] = 10
    list1.forEach{ n -> println("SubList(Revised List) : $n ")}

    //========================= Maps ================
    // which means the key is Int but the value can be in any kind
    val map = mutableMapOf<Int,Any?>()
    // we have made a map with two elements :
        // 1 -> Dog
        // 2 -> 25
    val map2 = mutableMapOf(1 to "Dog" , 2 to 25)
    map[1] = "Derek"
    map[2] = 42

    println("Map Size : ${map.size}")
    map.put(3,"Horse")// add a new pair
    map.remove(2)

    for ( (x,y) in map){
        println("Key -> Value: $x -> $y")
    }

    //========================= Classes ================
    val browser = Animal("Mike" , 2.0 , 13.5)
    //val mike = Animal("Mike" , 0.0, 13.5) // Throws an exception due to the require fields.
    browser.getInfo()

    val doggy = Dog("Bravo" , 1.78 , 98.0 , "Jack" , 176 )
    doggy.getInfo()

    val tweety = Bird("Tweety" ,true)
    tweety.fly(170.0)
    //========================= Null Safety ================
    //val nullVal : String = null //you can not directy assign a null in kotlin
    val nullVal : String? = null //? means nullable
    var nullVariable = returnNull()
    if ( nullVariable != null){
        println("Not null -> $nullVariable")
    }
    else{
        println("Null it is -> $nullVariable ")
    }






}//End of Main Function

// Here we have defined a function that gets two integers and returns a String.
fun add ( num1 : Int , num2 : Int ) : String {
    return ( num1 + num2).toString()
}
// Here we have defined a function that gets two Doubles and Directly returns the result.
fun addFloat (num1: Double, num2: Double ) : Double = num1 + num2

// instead of using Void we use Unit
fun sayHello ( name : String ) : Unit {
    println("Hello $name !")
}

// we can create a function that returns more than one value
fun nextTwo ( num : Int) : Pair<Int , Int>{
    return ( Pair (num+1 , num + 2))
}
//passing unlimited number if arguments to a function
fun getSum( vararg numbers : Int ) : Int{
    var sum = 0
    numbers.forEach { n -> sum += n }
    return sum
}

fun fact( x : Int) : Int {
    tailrec fun facTail ( y : Int , z : Int ) : Int {
        if ( y == 0 ){
            return z
        }
        else {
            return facTail(y-1 , y * z)
        }
    }
    return facTail(x,1)
}

fun insertFamilyInfo ( name : String = "UNKNOWN" , family : String = "UNKNOWN"){
    println("First Name  : {$name} | Family Name : {$family }")

}
fun getInfo(name: String){
    println("Hello My Name is {$name}")
}
fun getInfo(name: String , family: String){
    println("Hello I am {$name} {$family}")
}

//Higher Order
// returns a function that returns an Integer.
fun makeMathFunction( num1 : Int ) : (Int) -> Int = { num2 -> num1 * num2 }

// gets a "List" and a "Function" and applies the function on all elements of the list.
fun functionOnList ( numList : Array<Int> , myFunction :(num : Int) -> Int ) : Boolean{
    for ( num in numList ){
        println("MathOnList : ${myFunction(num)}")
    }
    return true
}
//Open in kotlin means final in java
open class Animal ( val name : String , var height : Double , var weight : Double){
    init {
        // we write a RegEx here
        val regex = Regex(".*\\d+.*")
        // if the input numbers does not satisfy the require fields , it will throw an exception.
        require(!name.matches(regex)){"Animal Names can't contain Numbers"}
        require(height > 0 ){"Height must be greater than zero"}
        require(weight > 0 ){"Weight must be greater than zero"}
    }
    // for being able to be overriden
    open fun getInfo() : Unit{
        println("Name :  $name | Height/Weight : $height / $weight")
    }

}
// ":" means inheritance.
class Dog (  name:String ,  height:Double ,  weight:Double , var Owner : String , var speed : Int) : Animal(name, height,weight  ) {

    override fun getInfo():Unit {
        super.getInfo()
        println("Owner : $Owner | Speed : $speed")
    }
}
//Interfaces :
interface Flyable{
    var canFly : Boolean
    fun fly(distMile : Double) : Unit {
        println("Can fly for $distMile Miles")
    }
}
//A class in Kotlin can have a primary constructor and one or more secondary constructors.
// The primary constructor is part of the class header: it goes after the class name (and optional type parameters).
class Bird(override var canFly: Boolean = true) : Flyable{
    var name : String = ""
    override fun fly(distMile: Double) {
        //super.fly(distMile)
        if ( canFly ){
            println("Can Fly in $distMile Miles")
        }
    }
    constructor(birdName : String , flies : Boolean) : this() {
        this.name = birdName
        this.canFly = flies
    }
}

// returning null from a fucntion
fun returnNull():String?{
    return null
}

