package br.senai.sp.jandira.lionschool

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.model.AlunosLista
import br.senai.sp.jandira.lionschool.model.CursoLista
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import br.senai.sp.jandira.lionschool.service.RetrofitFactory
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

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
    val context = LocalContext.current

    var cursos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschool.model.Curso>())
    }

    var alunos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschool.model.Alunos>())
    }
    val call = RetrofitFactory().getCursosService().getCursos()

    call.enqueue(object : Callback<CursoLista> {
        override fun onResponse(
            call: Call<CursoLista>,
            response: Response<CursoLista>

        ) {
            cursos = response.body()!!.cursos

        }

        override fun onFailure(call: Call<CursoLista>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })





    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
//HEADER
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                backgroundColor = Color(53, 93, 233),
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_grande),
                        contentDescription = "logo",
                        Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp)
                    )
                    Text(
                        text = "Lion School",
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
//HEADER

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(0.dp, 30.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)) {
                Text(text = "Olá", fontWeight = FontWeight.Bold, fontSize = 50.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Professor",
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                    color = Color(53, 93, 233)
                )
            }

            Card(
                Modifier
                    .width(200.dp)
                    .height(3.dp), backgroundColor = Color(249, 210, 5)
            ) {
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn() {
                items(cursos) {
                    Card(
                        Modifier
                            .width(200.dp)
                            .height(200.dp)
                            .clickable {
                                if (it.sigla == "DS"){
                                val intent = Intent(context, DsActivity::class.java)
                                context.startActivity(intent)
                                }
                                else{
                                    val intent = Intent(context, RdsActivity::class.java)
                                    context.startActivity(intent)
                                }
                            }
                            .padding(0.dp, 25.dp, 0.dp, 0.dp), backgroundColor = Color(53, 93, 233)

                    ) {
                        Column(
                            Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = it.sigla,
                                fontSize = 64.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(72.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                backgroundColor = Color(53, 93, 233),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) { }
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