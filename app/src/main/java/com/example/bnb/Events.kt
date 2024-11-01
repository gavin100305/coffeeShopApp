package com.example.bnb

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bnb.ui.theme.orange5

@Composable
fun EventView(navController: NavController
){
    LazyColumn(modifier = Modifier.background(orange5),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(eventlist) { event ->
            EventCard(event = event,navController = navController)
        }
    }

}

@Composable
fun EventCard(event: Event,navController: NavController,
    modifier : Modifier = Modifier){
  Column {
      Box(modifier = modifier
          .padding(top = 16.dp)
          .border(BorderStroke(2.dp, androidx.compose.ui.graphics.Color.Black),
              shape = RoundedCornerShape(15.dp)
          ) ) {
          Card(modifier = modifier
              .fillMaxWidth()
              .clickable {
//              navController.navigate("event_detail/${event.title}/${event.painter}/${event.date}/${event.time}")
                         navController.navigate(Screen.EventDetail.route+"/${event.title}/${event.painter}/${event.date}/${event.time}")
          },
              shape = RoundedCornerShape(15.dp),
              elevation = CardDefaults.cardElevation(5.dp)) {
              Box(modifier = Modifier.height(250.dp)) {
                  Image(
                      painterResource(id = event.painter),
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
                              text = event.title,
                              style = TextStyle(color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                          )
                          Text(text = "Date : ${event.date}",
                              style = TextStyle(color = Color.White, fontSize = 16.sp) )

                          Text(text = "Time : ${event.time}",
                              style = TextStyle(color = Color.White, fontSize = 16.sp) )

                      }
                  }

              }

          }
      }
  }
}




data class Event(
    val painter: Int,
    val title: String,
    val date: String,
    val time: String
)

val partyImage : Int = R.drawable.halloween

val eventlist = listOf<Event>(

//    Event(
//        painter = partyImage,
//        title = "Birthday Bash",
//        date = "20-10-2024", // Indian date format
//        time = "6:00 PM"
//    ),
    Event(
        painter = partyImage,
        title = "Halloween Party",
        date = "16-10-2024", // Indian date format
        time = "7:00 PM"
    ),
    Event(
        painter = partyImage,
        title = "Bollywood Night",
        date = "20-10-2024", // Indian date format
        time = "9:00 PM"
    ),
    Event(
        painter = partyImage,
        title = "Mask Night",
        date = "15-11-2024", // Indian date format
        time = "5:00 PM"
    ),
//    Event(
//        painter = partyImage,
//        title = "Engagement Party",
//        date = "01-12-2024", // Indian date format
//        time = "4:00 PM"
//    ),
//    Event(
//        painter = partyImage,
//        title = "Anniversary Celebration",
//        date = "10-12-2024", // Indian date format
//        time = "7:00 PM"
//    )

)