package com.example.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Start()
        }
    }
}

@Composable
fun Start(){
    val showText = true
    var currentFactIndex by remember { mutableIntStateOf(0) }
    val facts = listOf(
        "Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still edible.",
        "A day on Venus is longer than a year on Venus.",
        "Bananas are berries, but strawberries aren't.",
        "There are more stars in the universe than grains of sand on all the Earth's beaches.",
        "Octopuses have three hearts.",
        "The world's oldest wooden wheel has been around for more than 5,000 years.",
        "Dead skin cells are a main ingredient in household dust.",
        "Sudan has more pyramids than any country in the world.",
        "The bumblebee bat is the world's smallest mammal.",
        "A group of flamingos is called a 'flamboyance'.",
        "The shortest war in history lasted just 38 to 45 minutes.",
        "Wombat poop is cube-shaped.",
        "The Eiffel Tower can be 15 cm taller during the summer.",
        "A bolt of lightning contains enough energy to toast 100,000 slices of bread.",
        "Sea otters hold hands while sleeping to keep from drifting apart.",
        "A single strand of spaghetti is called a 'spaghetto'.",
        "The inventor of the frisbee was turned into a frisbee after he died.",
        "There are more possible iterations of a game of chess than there are atoms in the known universe."
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .offset(x = 0.dp, y = 650.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { currentFactIndex = (currentFactIndex + 1) % facts.size
                         },
            modifier = Modifier
                .width(200.dp)
                .height(60.dp)
        ) {
            Text(text = "Next Fact",
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
    if (showText) {
        FunFacts(
            fact = facts[currentFactIndex]
        )
    }
}
@Composable
fun FunFacts(fact: String) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = fact,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            color = Color.Blue,
            fontStyle = FontStyle.Italic
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FunFactsPreview() {
    Start()
}