package com.uvg.renato.lab6

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.graphics.alpha
import com.uvg.renato.lab6.ui.theme.Lab6Theme
import com.uvg.renato.lab6.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6Theme {
                    PagPrincipal()
                }
            }
        }
    }


fun addToList(listToAdd: MutableList<Int>,numberToAdd: Int): Int {
    listToAdd.add(numberToAdd)
    return 0
}


@Composable
fun GridItem(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(paintAColor(ultimaAccion)).copy(alpha=0.8f))
            ,fontWeight = FontWeight.Bold,
        color = Color.Black
        ,
    )
}

fun paintAColor(lastAction:Boolean): Long {
    if(lastAction == true){
        return 0xFF8FF64D
    }
    else {
        return 0xFFEC2727
    }
}
var ultimaAccion = true

@Composable
fun PagPrincipal() {
    val elements = remember {
        mutableStateListOf<String>()
    }
    var newElement by remember {
        mutableStateOf("")
    }

    val onAddElement = {
        if (newElement.isNotEmpty()) {
            elements.add(newElement)
            newElement = ""
        }
    }
    var number by remember { mutableIntStateOf(0) }
    var incrementos by remember { mutableStateOf(0) }
    var decrementos by remember { mutableStateOf(0) }
    var cambios by remember { mutableStateOf(0) }
    val list = remember {
        mutableStateListOf<Int>()
    }
    LaunchedEffect(list.isEmpty()) {
        if (list.isEmpty()) {
            list.add(0)

        }

    }


    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .safeDrawingPadding()
        .padding(10.dp)
    ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
    Text(text = "Renato Manuel Rojas Roldan", textAlign = TextAlign.Center, modifier = Modifier.weight(0.6f),style = MaterialTheme.typography.headlineLarge)
    Row (modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(20.dp), verticalAlignment = Alignment.CenterVertically){
        Button(onClick = { number-- and decrementos++ and cambios++ and addToList(list,number);ultimaAccion=false }, modifier = Modifier
            .clip(CircleShape)
            .size(50.dp), contentPadding = ButtonDefaults.TextButtonWithIconContentPadding) {
        Text(text = "—",fontWeight = FontWeight.Bold,style = MaterialTheme.typography.headlineMedium )//Boton -
        }
        Text(text = "$number", textAlign = TextAlign.Center, style = MaterialTheme.typography.displayLarge,fontWeight = FontWeight.ExtraBold) //El contador en sí
        Button(onClick = { number++ and incrementos++ and cambios++ and addToList(list,number); ultimaAccion=true}, modifier = Modifier
            .clip(CircleShape)
            .size(50.dp), contentPadding = ButtonDefaults.TextButtonContentPadding) {
        Text(text = "+",fontWeight = FontWeight.Bold,style = MaterialTheme.typography.headlineMedium)//Boton +
        }
    }
    Column (modifier = Modifier
        .weight(1.3f)
        .fillMaxWidth()
        .padding(12.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.SpaceBetween){
        Row (Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Absolute.SpaceBetween){
            Text(text = "Total incrementos:",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            Text(text = "$incrementos")
        }
        Row (Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Absolute.SpaceBetween){
            Text(text = "Total decrementos:",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            Text(text = "$decrementos")

        }
        Row (Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Absolute.SpaceBetween){
            Text(text = "Valor máximo:",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            Text(text = "${list.maxOrNull()}")

        }
        Row (Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Absolute.SpaceBetween) {
            Text(text = "Valor mínimo:",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            Text(text = "${list.minOrNull()}")

        }
        Row (Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Absolute.SpaceBetween){
            Text(text = "Total cambios:",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            Text(text = "$cambios")

        }
        Text(text = "Historial:",fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
    }

    LazyVerticalGrid(columns = GridCells.Fixed(5), verticalArrangement = Arrangement.spacedBy(15.dp), horizontalArrangement = Arrangement.spacedBy(15.dp), modifier = Modifier
        .weight(1.3f)
        .fillMaxWidth()) {
        items(list) {item ->GridItem(item.toString())}
    }
    Button(onClick = {number = 0; incrementos = 0;decrementos = 0; cambios = 0; list.clear();ultimaAccion=true}, modifier = Modifier
        .weight(0.3f)
        .fillMaxWidth()) {
    Text(text = "Reiniciar")
    }   
}
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(50.dp)) {
    }
    Lab6Theme {
        PagPrincipal()
    }
}