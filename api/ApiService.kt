package com.jb.project.api

import com.jb.project.ui.dashboard.CountryListResponse
import com.jb.project.ui.login.LoginResponseModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.Partials.signin)
    fun login(@Body params: HashMap<String, Any>): Observable<LoginResponseModel>


    @GET(Constants.Partials.listdata)
    fun listdata(): Observable<CountryListResponse>

}


