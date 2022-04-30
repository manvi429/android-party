package com.jb.project.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jb.project.api.WebServiceRequests
import com.jb.project.base.Event
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class LoginVm (private val webServiceRequests: WebServiceRequests) : ViewModel() {
    val mResponse = MutableLiveData<Event<LoginResponseModel>>()
    val mError = MutableLiveData<Throwable>()
    val mProgressbar = MutableLiveData<Boolean>()



    fun login(name:String,password: String) {
        mProgressbar.value=true
        webServiceRequests.login(name,password)
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