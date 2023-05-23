package br.senai.sp.jandira.lionschool.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL_BASE = "https://api-lionschool.onrender.com/v1/lion-school/"

    private val retrofitFactory = Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(GsonConverterFactory.create()).build()

    fun getCursosService():CursosService{
        return retrofitFactory.create(CursosService::class.java)
    }
    //fun getCharacterService(): CharacterService {
    //        return  retrofitFactory.create(CharacterService::class.java)
    //    }





// private val URL_BASE = "https://rickandmortyapi.com/api/"
   // private val retrofitFactory = Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(
     //   GsonConverterFactory.create()).build()
   // fun getCharacterService(): CharacterService {
    //    return  retrofitFactory.create(CharacterService::class.java)
 //   }
}