package com.jb.project.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import com.jb.project.R
import com.jb.project.api.baseModel.ErrorBean
import com.jb.project.extentions.getGsonInstance
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ErrorUtil {
    fun handlerGeneralError(context: Context?, view: View?, throwable: Throwable) {
        // No need to pass the view. i'll remove later

        if (context == null) return

        when (throwable) {
            //For Display Toast

            is ConnectException -> Toast.makeText(
                context,
                "Unable to connect to the internet please try again",
                Toast.LENGTH_SHORT
            ).show()
            is SocketTimeoutException -> Toast.makeText(
                context,
                "Unable to connect to the internet please try again",
                Toast.LENGTH_SHORT
            ).show()
            is UnknownHostException -> Toast.makeText(
                context,
                "Unable to connect to the internet please try again",
                Toast.LENGTH_SHORT
            ).show()
            is InternalError -> Toast.makeText(context, "Server Error", Toast.LENGTH_SHORT).show()

            is HttpException -> {
                try {
                    when (throwable.code()) {
                        401 -> displayError(context, throwable)
                        403 -> displayError(context, throwable)
                        400 -> displayError(context, throwable)
                        else -> displayError(context, throwable)
                    }
                } catch (exception: Exception) {

                }
            }
            else -> {
                Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun displayError(context: Context, exception: HttpException) {
        try {
            val errorBody = getGsonInstance().fromJson(
                exception.response()?.errorBody()?.charStream(),
                ErrorBean::class.java
            )
            Toast.makeText(context, errorBody.message, Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Log.e("Error Utils", e.message + "")
            Toast.makeText(
                context, context.getString(R.string.error_exception), Toast.LENGTH_SHORT
            ).show()
        }
    }

//    private fun forceLogout(view: View?, exception: HttpException) {
//        try {
//            val errorBody = getGsonInstance().fromJson(
//                exception.response()?.errorBody()?.charStream(),
//                ErrorBean::class.java
//            )
//            Log.e("ErrorMessage", errorBody.ErrorDetails + "")
//            Toast.makeText(view?.context, errorBody.ErrorDetails, Toast.LENGTH_SHORT).show()
//
//            val act = view?.getParentActivity()
//            act?.run {
//                val viewModelUser = ViewModelProvider(act).get(UserViewModel::class.java)
//                viewModelUser.deleteUserData()
//                startActivity(Intent(this, LoginActivity::class.java))
//                finishAffinity()
//            }
//        } catch (e: java.lang.Exception) {
//            Toast.makeText(
//                view?.context,
//                view?.context?.getString(R.string.error_exception),
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
}