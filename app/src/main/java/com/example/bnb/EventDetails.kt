package com.example.bnb

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bnb.ui.theme.orange10
import com.example.bnb.ui.theme.orange5
import com.example.musicapp.MainViewModel

@Composable
fun EventDetailScreen(event: Event, viewModel: MainViewModel) {
    // Observe the spots left for the specific event
    val spotsLeft by viewModel.getSpotsLeft(event.title).observeAsState(initial = 10) // Default value

    Column(modifier = Modifier.background(orange5)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            // Display the event image, title, etc.
            Image(
                painter = painterResource(id = event.painter),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Event : ${event.title}",
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Date : ${event.date}",
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Time : ${event.time}",
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Spots Left : $spotsLeft",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(10.dp))


            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = orange10, // Background color
                    contentColor = Color.White   // Text color
                ),
                onClick = {
                    viewModel.bookSlot(event.title) // Book a slot for this specific event
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = spotsLeft > 0
            ) {
                Text(text = "Book Slot")
            }

            if (spotsLeft == 0) {
                Text(
                    text = "No spots left",
                    style = TextStyle(color = Color.Red, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}
