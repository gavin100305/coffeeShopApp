package com.example.bnb

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bnb.ui.theme.orange5
import com.example.bnb.ui.theme.orange10


@Composable
fun ChefView(chefs: List<Chef>){

    LazyColumn(modifier = Modifier.background(orange5),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(chefs) { chef ->
            ChefCard(chef = chef)
        }
    }
}






@Composable
fun ChefCard(chef:Chef,
             modifier : Modifier = Modifier) {

    Card(
        modifier = modifier.fillMaxWidth().padding(top = 16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(modifier = Modifier.height(250.dp)) {
            Image(
                painterResource(id = chef.painter),
                contentDescription = "Chef",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    Text(
                        text = chef.name,
                        style = TextStyle(color = Color.White, fontSize = 16.sp)
                    )
                    Text(text = "Availability : ${chef.availability}",
                        style = TextStyle(color = Color.White, fontSize = 16.sp) )

                    Text(text = chef.cuisine,
                        style = TextStyle(color = Color.White, fontSize = 16.sp) )

                }
            }

        }

    }
}



data class Chef(
    val painter: Int,
    val availability: String,
    val name: String,
    val cuisine: String
)

val dummyPainter: Int = R.drawable.gorden

val chefList = listOf<Chef>(
    Chef(
        painter = dummyPainter,
        availability = "Available on Sundays",
        name = "Chef Gordon Ramsay",
        cuisine = "British"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Available on Sundays",
        name = "Chef Massimo Bottura",
        cuisine = "Italian"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Available on Sundays",
        name = "Chef Dominique Crenn",
        cuisine = "French"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Available",
        name = "Chef Dominique Crenn",
        cuisine = "French"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Available",
        name = "Chef Heston Blumenthal",
        cuisine = "British Molecular Gastronomy"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Unavailable",
        name = "Chef Alice Waters",
        cuisine = "Californian"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Available",
        name = "Chef René Redzepi",
        cuisine = "Nordic"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Available",
        name = "Chef Nobu Matsuhisa",
        cuisine = "Japanese-Peruvian"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Unavailable",
        name = "Chef Alain Ducasse",
        cuisine = "French"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Available",
        name = "Chef José Andrés",
        cuisine = "Spanish"
    ),
    Chef(
        painter = dummyPainter,
        availability = "Unavailable",
        name = "Chef Thomas Keller",
        cuisine = "American-French"
    )
)
