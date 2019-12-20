import java.util.Random
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
    //========================= Functions ================


}

