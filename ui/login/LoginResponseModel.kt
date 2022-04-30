package com.jb.project.ui.login
import com.google.gson.annotations.SerializedName


data class LoginResponseModel(
    @SerializedName("token")
    val token: String
)