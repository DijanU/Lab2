package com.example.lab2apps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2apps.ui.theme.Lab2AppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2AppsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2AppsTheme {
        Greeting("Android")
    }
}

data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val
studentId: String)

fun main(){
    println("Hello world")
    fun calcularPromedio(notas: List<Int>): Double {
        val sigma = notas.reduce{acc, notas -> acc + notas}
        val promedio = sigma.toDouble()/notas.size
        return promedio
    }

    fun impares(enteros: List<Int>): List<Int> {
        return enteros.filter {it%2 !=0}
    }

    fun isPalindrome(palabra: String): Boolean{ return palabra == palabra.reversed()}

    fun addHola(nombres: List<String>): List<String>{
        val holas = nombres.map{nombres -> "Hola, $nombres!"}
        return holas
    }
    fun performOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int{
        return operation(x,y)
    }
    fun personToStudent(personas: List<Person>): List<Student>{
        return personas.map { Student(name = it.name, age = it.age, gender = it.gender, studentId = "0") }
    }

    //1
    val notas = listOf(8, 9, 7, 10)
    val promedio = calcularPromedio(notas)
    println("Promedio: $promedio")

    //2
    val impares = impares(notas)
    println("impares $impares")

    //3
    println(isPalindrome("hannah"))

    //4
    val names = listOf("David", "Anggie", "Bran", "Hermano", "Iris")
    println(addHola(names))

    //5
    println(performOperation(3,2){x,y->x-y})

    //6
    val people = listOf(
        Person("david", 30, "Male"),
        Person("Bran", 19, "Male"),
        Person("Anggie", 20, "Male"),
        Person("Iris", 22, "female"),
        Person("Johnny", 20, "Male")
    )
    val students = personToStudent(people)
    for (i in students){
        println("El Estudiante ${i.name}  tiene ${i.age}")
    }
}
