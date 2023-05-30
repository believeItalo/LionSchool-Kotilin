package br.senai.sp.jandira.lionschool.service

import br.senai.sp.jandira.lionschool.model.Alunos
import br.senai.sp.jandira.lionschool.model.CursoLista
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CursosService {
    //https://api-lionschool.onrender.com/v1/lion-school/
   // @GET("cursos")
    //fun getCursos():Call<CursoLista>

    @GET("cursos")
    fun getCursos(): Call<CursoLista>
    @GET("alunos")
    fun getAlunos(@Query("alunos") alunos: String): Call<Alunos>
}