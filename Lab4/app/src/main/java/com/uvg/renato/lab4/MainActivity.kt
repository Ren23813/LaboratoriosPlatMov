package com.uvg.renato.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.renato.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Caratula()
            }
        }
    }
}

@Composable
fun Caratula() {
Box(modifier = Modifier
    .fillMaxSize()
    .border(BorderStroke(6.dp, SolidColor(Color.Green)))) {
    Image(painter = painterResource(id = R.drawable.logo_uvg), contentDescription = null, modifier = Modifier.fillMaxSize(), alpha = 0.2f)
}

Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
    .fillMaxHeight()
    .fillMaxWidth())
    {
    Spacer(modifier = Modifier.weight(0.3f))
Text(text = "Universidad Del Valle de Guatemala", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center, modifier = Modifier.weight(0.2f))
        Text(text = "Programación de Plataformas móviles, sección 30.", style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Center,modifier = Modifier.weight(0.2f))
Row (modifier = Modifier.weight(0.1f)){
Text(text = "Integrantes", fontWeight = FontWeight.ExtraBold, style = MaterialTheme.typography.titleLarge)
Spacer(modifier = Modifier.width(50.dp))
    Text(text = "Renato Rojas \nMelisa Mendizabal", textAlign = TextAlign.Center)

}
        Row (modifier = Modifier.weight(0.2f)){
            Text(text = "Catedrático", fontWeight = FontWeight.ExtraBold,style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.width(50.dp))
            Text(text = "Juan Carlos Durini", textAlign = TextAlign.Center)
        }
        Text(text = "Nombre del alumno: Renato Rojas.", modifier = Modifier.weight(0.05f), textAlign = TextAlign.Center)
        Text(text = "Número de carné: 23813.", modifier = Modifier.weight(0.2f), textAlign = TextAlign.Center)


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(50.dp)) {
    }
    Lab4Theme {
        Caratula()
    }
}