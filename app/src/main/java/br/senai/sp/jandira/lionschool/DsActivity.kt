package br.senai.sp.jandira.lionschool

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.model.Alunos
import br.senai.sp.jandira.lionschool.model.Curso
import br.senai.sp.jandira.lionschool.model.CursoLista
import br.senai.sp.jandira.lionschool.service.RetrofitFactory
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import br.senai.sp.jandira.lionschool.model.AlunosLista as AlunosLista

class DsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    var alunos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschool.model.Alunos>())
    }

    val call = RetrofitFactory().getAlunosService().getAlunos("DS")

    call.enqueue(object : Callback<AlunosLista> {
        override fun onResponse(
            call: Call<AlunosLista>,
            response: Response<AlunosLista>) {
           alunos = response.body()!!.alunos
        }

        override fun onFailure(call: Call<AlunosLista>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })


    Column(modifier = Modifier.fillMaxSize()) {

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

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
        ) {
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp),
                backgroundColor = Color(53, 93, 233),
                shape = RoundedCornerShape(
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp,
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Finalizado",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp),
                backgroundColor = Color(210, 178, 9),
                shape = RoundedCornerShape(
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp,
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
            ) {

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Cursando",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }

        }

        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(Modifier.fillMaxSize()) {
                items(alunos) {

                    Card(
                        Modifier
                            .width(200.dp)
                            .height(200.dp)
                            .padding(0.dp, 25.dp, 0.dp, 0.dp), backgroundColor = Color(53, 93, 233)
                    ) {
                        Column(
                            Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "${it.nome}",
                                fontSize = 64.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }

                    }
                }
            }
        }

    }

}

fun <T> Call<T>.enqueue(callback: Callback<AlunosLista>) {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LionSchoolTheme {
        Greeting2("Android")
    }
}