package br.senai.sp.jandira.lionschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        ) {
//HEADER
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp), backgroundColor = Color(53,93,233), shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.logo_grande), contentDescription = "logo",Modifier.padding(0.dp,0.dp,20.dp,0.dp))
                    Text(text = "Lion School", color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
//HEADER

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
            Row() {
                Text(text = "Olá", fontWeight = FontWeight.Bold, fontSize = 50.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Professor",fontWeight = FontWeight.Bold, fontSize = 50.sp, color = Color(53,93,233))
            }
            Card(Modifier.width(200.dp).height(3.dp), backgroundColor = Color(249,210,5)) {

            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LionSchoolTheme {
        Greeting("Android")
    }
}