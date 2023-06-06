package br.senai.sp.jandira.lionschool.service

import br.senai.sp.jandira.lionschool.model.Alunos
import br.senai.sp.jandira.lionschool.model.AlunosLista
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlunosService {
    @GET("alunos")
    fun getAlunos():Call<AlunosLista>

    @GET("alunos")
    fun getStatus(@Query("status") status: String):Call<AlunosLista>

    @GET("alunos")
    fun getStatusCurso(@Query("status") status: String,@Query("status") curso: String):Call<AlunosLista>

    @GET("alunos")
    fun getCurso(@Query("curso") curso: String):Call<AlunosLista>

    @GET("alunos")
    fun getConclusao(@Query("conclusao") conclusao: String):Call<AlunosLista>
}