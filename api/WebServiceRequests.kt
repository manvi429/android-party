package com.jb.project.api

import com.jb.project.ui.dashboard.CountryListResponse
import com.jb.project.ui.login.LoginResponseModel
import io.reactivex.Observable

class WebServiceRequests {
    val apiService by lazy { ApiClient.getClient()!!.create(ApiService::class.java) }
    val apiService2 by lazy { ApiClient.getClient2()!!.create(ApiService::class.java) }

//    suspend fun mRequestPayment(
//        mRequestPayment: RequestPayment
//    ) = apiService.signUp(mRequestPayment)


    fun login(
        username: String,
        password: String,
    ): Observable<LoginResponseModel> {
        val params: HashMap<String, Any> = HashMap()
        params[Constants.Keys.username] = username
        params[Constants.Keys.password] = password
        return apiService2!!.login(params)
    }

    fun countrylist(): Observable<CountryListResponse> {
        return apiService2!!.listdata()
    }


}
