import java.lang.IllegalArgumentException
import java.util.Random
import javax.swing.Painter

fun main(args: Array<String>) {

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

