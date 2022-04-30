package com.jb.project.api

class Constants {
    companion object {
        const val BASE_URL = "https://playground.tesonet.lt/v1/"
        var DeviceId: String = ""
        var HEADER_TOKEN = ""
        var ClientIPAddress: String = ""

    }

    internal object Partials {
        const val signin = "tokens"
        const val listdata = "servers"
    }

    internal object Keys {
        const val username = "username"
        const val password = "password"
    }
}