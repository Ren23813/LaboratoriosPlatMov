package com.uvg.renato.lab7

import android.adservices.topics.Topic
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.renato.lab7.ui.theme.Lab7Theme
import com.uvg.renato.lab7.Notification
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7Theme {
                   NotificationScreen()
                }
            }
        }
    }


val iconMap = mapOf(
    NotificationType.GENERAL to Icons.Rounded.Home,
    NotificationType.NEW_LIKE to Icons.Rounded.Favorite,
    NotificationType.NEW_POST to Icons.Rounded.AddCircle,
    NotificationType.NEW_MESSAGE to Icons.Rounded.Email)

@Composable
fun GridItem(title: String,type:NotificationType,body:String,hour: Date) {
    val icon = iconMap[type]
Box(
    Modifier
        .background(MaterialTheme.colorScheme.primaryContainer)
        .padding(10.dp)){
    Row (modifier = Modifier.padding(2.dp)){
    Box(modifier = Modifier
        .size(45.dp)
        .padding(7.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.onSurface),
        contentAlignment = Alignment.Center
    ){
        if (icon != null) {
            Icon(imageVector = icon, contentDescription ="" , tint = MaterialTheme.colorScheme.surface, modifier = Modifier.clip(
                CircleShape))
        }

    }
    Column {
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = title, style = MaterialTheme.typography.titleMedium, fontStyle = FontStyle.Italic,color = MaterialTheme.colorScheme.onSurface)
            Text(text = "$hour", style = MaterialTheme.typography.labelSmall, textAlign = TextAlign.Right,color = MaterialTheme.colorScheme.onSurface)
        }
    Text(text = body,style = MaterialTheme.typography.bodyMedium,color = MaterialTheme.colorScheme.onSurface)
    }
}
}
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen() {
    var selectedFilter by remember { mutableStateOf<NotificationType?>(null) }
    val list = generateFakeNotifications()


    val filteredNotifications = if (selectedFilter != null) {
        list.filter { it.type == selectedFilter }
    }
    else {
            list
        }

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .safeDrawingPadding()
        .background(MaterialTheme.colorScheme.primaryContainer)
        //.padding(10.dp)
        )
    {
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.onErrorContainer)
        .height(55.dp)
        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){
        Box() {
            Icon(Icons.Rounded.ArrowBack, contentDescription ="", tint = MaterialTheme.colorScheme.secondary )
        }
    Spacer(modifier = Modifier.width(10.dp))
    Text(text = "Notificaciones", color = MaterialTheme.colorScheme.onError, modifier = Modifier.fillMaxWidth())
    }
        Row (modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(5.dp), horizontalArrangement = Arrangement.Start

        ) {Text(text = "Tipos de notificaciones", style = MaterialTheme.typography.titleMedium,color = MaterialTheme.colorScheme.onSurface)}
Row (modifier = Modifier
    .background(MaterialTheme.colorScheme.tertiaryContainer)
    .padding(3.dp)){
    NotificationType.entries.forEach { type ->
        FilterChip(modifier = Modifier.weight(0.25f),
            selected = selectedFilter == type,
            onClick = {
                selectedFilter = if (selectedFilter == type) null else type
            },
            label = { Text(text = "$type", style = MaterialTheme.typography.labelSmall, textAlign = TextAlign.Center, fontWeight = FontWeight.Black) }, leadingIcon = {
                if (selectedFilter == type) {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            }

        )
    }
    }
        Box (modifier = Modifier
            .padding(10.dp)
            .border(
                width = 3.dp,
                shape = RoundedCornerShape(25.dp),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )){
            LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = Modifier.fillMaxSize()) {
                items(filteredNotifications.size) { item ->
                    GridItem(
                        title = filteredNotifications[item].title,
                        type = filteredNotifications[item].type,
                        body = filteredNotifications[item].body,
                        hour = filteredNotifications[item].sendAt
                    )
                }
            }
        }
    }
    }






@Preview(showBackground = true)
@Composable
fun GeneralPreview() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(50.dp)) {
    }
    Lab7Theme {
        NotificationScreen()
    }
}