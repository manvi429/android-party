package com.jb.project.ui.splesh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jb.project.R
import com.jb.project.ui.MainActivity
import com.jb.project.ui.login.LoginActivity
import com.jb.project.utils.PreferenceManager

class SpleshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splesh)
        if (PreferenceManager.getInstance(this).isLoggedIn){
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }else{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}