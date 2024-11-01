package com.example.bnb.ui.theme

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(
    title: String,
    onBackNavClicked: () -> Unit = {}
) {
    val navigationIcon : (@Composable () -> Unit)? = {
        if(!title.contains("Home")) {
            IconButton(onClick = { onBackNavClicked() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack, contentDescription = "Arrow Back",
                    tint = Color.White
                )
            }
        }else{
            null
        }
    }

    if (navigationIcon != null) {
        TopAppBar(
            modifier = Modifier.clip(RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp)),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = orange11
            ),
            navigationIcon = navigationIcon,
            title = {
                Text(
                    text = title,
                    color = orange11,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .heightIn(max = 24.dp)
                )
            },
//        elevation = 3.dp,
//        backgroundColor = appBar,
//        navigationIcon
        )
    }
}