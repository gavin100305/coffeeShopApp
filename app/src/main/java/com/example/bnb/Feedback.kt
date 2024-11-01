package com.example.bnb

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bnb.ui.theme.orange10
import com.example.bnb.ui.theme.orange2
import com.example.bnb.ui.theme.orange5
import com.example.bnb.ui.theme.orange8

@Composable
fun FeedBackView(){
    val context = LocalContext.current
    var message by remember{ mutableStateOf("") }
    Column(modifier = Modifier
        .background(orange5)
        .padding(top = 30.dp)
        ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(orange10)
            .padding(16.dp),
            contentAlignment = Alignment.Center){
            Text(text = "Customer Review",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = orange2)
        }
Spacer(modifier = Modifier.height(70.dp))
        Box(modifier = Modifier.fillMaxWidth().padding(16.dp)){
            OutlinedTextField(value = message,
                onValueChange ={
                    message = it
                } ,modifier = Modifier
                    .width(400.dp)
                    .height(350.dp)
                    .border(
                        BorderStroke(2.dp, Color.Black)

                    )
                    .background(orange8),
                placeholder = {Text(text = "Enter Your Feedback ..... ",
                    style = TextStyle(color = Color.White)
                )},textStyle = TextStyle(color = Color.White)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier.fillMaxWidth().padding(bottom = 70.dp),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                message = ""
                Toast.makeText(context, "Thank You for Your Feedback", Toast.LENGTH_LONG).show()

            }) {
                Text(text = "Submit")
            }
        }
    }
}