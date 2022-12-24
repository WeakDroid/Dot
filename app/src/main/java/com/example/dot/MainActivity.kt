package com.example.dot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Simple but easy to understand minimal principles of Jetpack's Compose app
//Good luck!
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                CircleItem()
            }
        }
    }
}

@Composable
private fun CircleItem() {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Color.White)
    }
    Box(
        modifier = Modifier
            .size(169.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {

                when (++counter.value) {
                    10 -> color.value = Color.Gray
                    20 -> color.value = Color.DarkGray
                    30 -> color.value = Color.Transparent
                    40 -> color.value = Color.DarkGray
                    50 -> color.value = Color.Gray
                    60 -> color.value = Color.White
                    70 -> color.value = Color.Gray
                }
                if (counter.value >= 70) {
                    counter.value = 0
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = counter.value.toString(), style = TextStyle(Color.Black, fontSize = 24.sp))
    }
}