package com.jb.project.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jb.project.api.WebServiceRequests
import com.jb.project.base.Event
import com.jb.project.ui.login.LoginResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DashBoardViewModel(private val webServiceRequests: WebServiceRequests) : ViewModel() {
    val mResponse = MutableLiveData<Event<CountryListResponse>>()
    val mError = MutableLiveData<Throwable>()
    val mProgressbar = MutableLiveData<Boolean>()



    fun countrylist() {
        mProgressbar.value=true
        webServiceRequests.countrylist()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mResponse.value = Event(it)
                mProgressbar.value=false

            }){
                mError.value = (it)
                mProgressbar.value=false

            }

    }





}