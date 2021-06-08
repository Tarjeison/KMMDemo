package com.example.faglunsj2.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.faglunsj2.*
import kotlinx.coroutines.runBlocking

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val text = DataClassDemo().getInfo().infoText
        val animal = DataClassDemo().getAnimalCat()
        val time = SomeTime().getTimeNow()
        val joke = runBlocking {
            ChuckNorrisRepository().getChuckNorrisFunFact().value
        }
        setContent {
            Faglunsj(joke)
        }
    }
}

@Composable
fun Faglunsj(text: String) {
    Text(
        text = text
    )
}

@Preview
@Composable
fun FaglunsjPreview() {
    Faglunsj(DataClassDemo().getAnimalCat().sound)
}
