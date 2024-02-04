package com.example.learningprjct

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningprjct.ui.theme.LearningPrjctTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningPrjctTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                            .background(
                                Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color.Cyan,
                                    Color.Green,
                                    Color.Transparent
                                )
                            ))
                    ) {
                        itemsIndexed(listOf(
                            ItemRowModel(R.drawable.ava, "Я", "Я русский и иду до конца, я русский, моя кровь от отца, я русский!"),
                            ItemRowModel(R.drawable.girl_1, "Девушка 1", "Я русский и иду до конца, я русский, моя кровь от отца, я русский!"),
                            ItemRowModel(R.drawable.girl_2, "Девушка 2", "Я русский и иду до конца, я русский, моя кровь от отца, я русский!"),
                            ItemRowModel(R.drawable.girl_3, "Девушка 3", "Я русский и иду до конца, я русский, моя кровь от отца, я русский!"),
                            ItemRowModel(R.drawable.girl_4, "Девушка 4", "Я русский и иду до конца, я русский, моя кровь от отца, я русский!"),
                            ItemRowModel(R.drawable.girl_5, "Девушка 5", "Я русский и иду до конца, я русский, моя кровь от отца, я русский!"),

                            )
                        ) {  _, item ->
                            ItemRow(item = item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ListItem(name: String, description: String) {
    val counter = remember{
        mutableStateOf(0)
    }
    val color = remember{
        mutableStateOf(Color.Gray)
    }
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = color.value)
            .clickable {
                when (++counter.value) {
                    10 -> color.value = Color.Cyan
                }

            }) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.ava), contentDescription = "ava", contentScale = ContentScale.Crop, modifier = Modifier
                    .size(64.dp)
                    .padding(5.dp))
                Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = name)
                    Text(text = "$description x ${counter.value.toString()}", style = TextStyle(fontSize = 12.sp))
                }

            }
        }
        
    }
}
