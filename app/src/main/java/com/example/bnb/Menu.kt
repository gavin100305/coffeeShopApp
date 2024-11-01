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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.bnb.ui.theme.orange1
import com.example.bnb.ui.theme.orange10
import com.example.bnb.ui.theme.orange2
import com.example.bnb.ui.theme.orange4
import com.example.bnb.ui.theme.orange5
import com.example.bnb.ui.theme.orange7
import com.example.bnb.ui.theme.orange8
import com.example.bnb.ui.theme.orange9

@Composable
fun MenuView(menuitems : List<Menu>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Define the number of columns
        modifier = Modifier
            .background(orange5)
            , // Add padding
        contentPadding = PaddingValues(16.dp) // Padding for the grid
    ) {
        items(menuitems) { menu ->
            MenuCard(
                menu = menu,
                modifier = Modifier.padding(5.dp) // Add padding around each item
            )
        }
    }


}

@Composable
fun MenuCard(menu: Menu,
             modifier : Modifier = Modifier
) {

//    Card(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(top = 5.dp),
//        shape = RoundedCornerShape(15.dp),
//        elevation = CardDefaults.cardElevation(5.dp)
//    ) {
//        Box(modifier = Modifier.height(200.dp)) {
//            Image(
//                painterResource(id = menu.painter),
//                contentDescription = "Chef",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(
//                        Brush.verticalGradient(
//                            colors = listOf(Color.Transparent, Color.Black),
//                            startY = 300f
//                        )
//                    )
//            )
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(12.dp),
//                contentAlignment = Alignment.BottomStart
//            ) {
//                Column {
//                    Text(
//                        text = menu.name,
//                        style = TextStyle(color = Color.White, fontSize = 16.sp,fontWeight = FontWeight.SemiBold)
//                    )
//                    Text(
//                        text = "Price : ${menu.price}",
//                        style = TextStyle(color = Color.White, fontSize = 16.sp,fontWeight = FontWeight.SemiBold)
//                    )
//
//                    Text(
//                        text = "Calorie Count : ${menu.calorie}",
//                        style = TextStyle(color = Color.White, fontSize = 16.sp,fontWeight = FontWeight.SemiBold)
//                    )
//
//                }
//            }
//
//        }
//    }
    Card(

        modifier = modifier.padding(bottom = 16.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = orange1
        )
    ) {
        Column {
            Image(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
                painter = painterResource(id = menu.painter),
                contentDescription = menu.name,
                contentScale = ContentScale.Crop)
        }
        Column(modifier = Modifier.padding(vertical = 20.dp , horizontal = 15.dp)) {

            Text(
                text = menu.name,
                style = TextStyle(color = orange9, fontSize = 20.sp,fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Calorie  : ${menu.calorie}",
                style = TextStyle(color = orange9, fontSize = 16.sp,fontWeight = FontWeight.SemiBold)
            )
            Text(
                text = "Price : ${menu.price}",
                style = TextStyle(color = orange9, fontSize = 16.sp,fontWeight = FontWeight.SemiBold)
            )
        }

    }
}



data class Menu(
    val painter: Int = R.drawable.halloween,
    val name: String,
    val price: String,
    val calorie : String
)

var menulist = listOf<Menu>(
    Menu(
        painter = R.drawable.espresso, // Replace with actual drawable
        name = "Espresso",
        price = "₹150",
        calorie = "5 kcal"
    ),
    Menu(
        painter = R.drawable.cappuccino, // Replace with actual drawable
        name = "Cappuccino",
        price = "₹180",
        calorie = "120 kcal"
    ),
//    Menu(
//        painter = R.drawable.latte, // Replace with actual drawable
//        name = "Latte",
//        price = "₹200",
//        calorie = "150 kcal"
//    ),
//    Menu(
//        painter = R.drawable.espresso, // Replace with actual drawable
//        name = "Mocha",
//        price = "₹220",
//        calorie = "170 kcal"
//    ),
//    Menu(
//        painter = R.drawable.espresso, // Replace with actual drawable
//        name = "Cold Brew",
//        price = "₹210",
//        calorie = "15 kcal"
//    )
//    ,
    Menu(
        painter = R.drawable.muffin, // Replace with actual drawable
        name = "Blueberry Muffin",
        price = "₹120",
        calorie = "250 kcal"
    ),
    Menu(
        painter = R.drawable.croissant, // Replace with actual drawable
        name = "Butter Croissant",
        price = "₹140",
        calorie = "220 kcal"
    ),
    Menu(
        painter = R.drawable.sandwich, // Replace with actual drawable
        name = "Chicken Sandwich",
        price = "₹180",
        calorie = "350 kcal"
    )
)
