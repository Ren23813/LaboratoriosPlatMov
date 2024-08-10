package com.uvg.renato.lab5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.uvg.renato.lab5.ui.theme.Lab5Theme


class Lab5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                PagPrincipal()
            }
        }
    }
}

@Composable
fun PagPrincipal() {
    val context = LocalContext.current
    val playStoreUrl = "https://play.google.com/store/apps/details?id=com.dinosaurgames.dinosaurrampage.dinocitysmasher.dinosaursimulator.cityattack&hl=es"
    val mapsURL = "https://maps.app.goo.gl/JVf5o6qDhyzzPLXz7"

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .statusBarsPadding())
    {
    Spacer(modifier = Modifier.height(15.dp))
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Cyan.copy(alpha = 0.4f))
        .height(45.dp),
        contentAlignment = Alignment.Center) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Rounded.Refresh, contentDescription = "",Modifier.weight(1f))
            Text(text = "Actualización disponible",Modifier.weight(4f))
            Text(
                text = "Descargar",
                modifier = Modifier
                    .weight(2f)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(playStoreUrl)
                        }
                        context.startActivity(intent)
                    }
            )
        }
    }
    Row (modifier = Modifier.weight(0.1f)){
        Box(modifier =  Modifier.weight(0.5f), contentAlignment = Alignment.Center){
            Text(text = "Viernes", textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
            Text(text = "\n \n 8 de marzo",textAlign = TextAlign.Center,style = MaterialTheme.typography.titleMedium)
        }
        OutlinedButton(onClick = {},Modifier.padding(15.dp)) {
            Text(text = "Terminar jornada")
        }
    }
    ElevatedCard(modifier = Modifier
        .fillMaxWidth()
        .weight(0.2f),
        colors = CardDefaults.elevatedCardColors(Color.LightGray.copy(alpha = 0.1f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.3.dp)) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "Aída",textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.ExtraBold)
            Icon(
                imageVector = Icons.Rounded.LocationOn,
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(mapsURL)
                        }
                        context.startActivity(intent)
                    }
            )      }
        Text(text = "6 calle 3-34 zona 1, Guatemala")
        Text(text = "\n 6:30AM 8:00PM \n ")
        Row {
            Button(onClick = {Toast.makeText(context,"Renato Manuel Rojas Roldan",Toast.LENGTH_LONG).show()}, modifier = Modifier.weight(0.5f)) {
                Text(text = "Iniciar",style = MaterialTheme.typography.bodyLarge)
            }
            Button(onClick = { Toast.makeText(context,"Comida casera. \n QQ",Toast.LENGTH_LONG).show() }, modifier = Modifier.weight(0.5f)) {
                Text(text = "Detalles",style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
    }
    Spacer(modifier = Modifier.weight(0.3f))
}

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(50.dp)) {
        }
    Lab5Theme {
        PagPrincipal()
    }
}