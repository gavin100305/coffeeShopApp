package com.example.bnb

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bnb.ui.theme.orange5
import com.example.bnb.ui.theme.orange8
import com.example.bnb.ui.theme.orange9

@Composable
fun HomeView(navController: NavController){

    Column(
        modifier = Modifier
            .background(orange5)
            .padding(top = 50.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(orange8)
            .padding(top = 20.dp, bottom = 20.dp),
            contentAlignment = Alignment.Center) {
            Column {
                Text(text = "       ETTARRA",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold)
                Text(text = "The Coffee House",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = R.drawable.ettarra),
                contentDescription = null,
                modifier = Modifier.size(300.dp) )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 70.dp),
            horizontalArrangement = Arrangement.SpaceAround) {
            Box(){
                Button(onClick = {
                    navController.navigate(Screen.BottomScreen.Menu.bRoute)
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = orange9,
                        contentColor = Color.White
                    )) {
                    Text(text = "Explore Menu",)
                }
            }
            Box(){
                Button(onClick = {
                    navController.navigate(Screen.BottomScreen.Chef.bRoute)
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = orange9,
                    contentColor = Color.White
                ) ) {
                    Text(text = "Chefs")
                }
            }
        }

    }


}