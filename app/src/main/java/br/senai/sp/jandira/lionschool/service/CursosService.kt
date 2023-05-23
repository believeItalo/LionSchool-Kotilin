package br.senai.sp.jandira.lionschool.service

import br.senai.sp.jandira.lionschool.model.CursoLista
import retrofit2.Call
import retrofit2.http.GET

interface CursosService {
    //https://api-lionschool.onrender.com/v1/lion-school/
   // @GET("cursos")
    //fun getCursos():Call<CursoLista>

    @GET("cursos")
    fun getCursos(): Call<CursoLista>
}