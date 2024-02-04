package com.example.learningprjct

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp

@Composable
fun ItemRow(item: ItemRowModel) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Image(painter = painterResource(id = item.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(3.dp)
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Column (modifier = Modifier
            .padding(start = 10.dp, top = 10.dp)) {
            Text(text = item.title)
            Text(modifier = Modifier.clickable {
                 isExpanded  = !isExpanded
            }, maxLines = if(isExpanded) Int.MAX_VALUE else 1, text = item.content)
        }
    }
}