package com.jb.project.ui.login

import android.content.Intent
import com.jb.project.R
import com.jb.project.api.Constants
import com.jb.project.base.BaseActivity
import com.jb.project.base.EventObserver
import com.jb.project.databinding.ActivityLoginBinding
import com.jb.project.extentions.hideProgressDialog
import com.jb.project.extentions.showProgressDialog
import com.jb.project.extentions.showSnackBar
import com.jb.project.extentions.showToast
import com.jb.project.ui.MainActivity
import com.jb.project.utils.ErrorUtil
import com.jb.project.utils.PreferenceManager
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    private val mloginvm: LoginVm by viewModel()


    override fun mLayoutRes(): Int {
        return R.layout.activity_login
    }

    override fun onViewReady() {
        mBinding.buttonlogin.setOnClickListener {
            if (validation()){
            mloginvm.login(mBinding.editTextTextPersonName.text.toString().trim(),mBinding.editTextTextPassword.text.toString().trim())

            }

        }


        obserber()
    }



    private fun obserber() {
        mloginvm.mProgressbar.observe(this, {
            if (it) {
                (this).showProgressDialog(this, "Login In")
            } else {
                (this).hideProgressDialog()
            }
        })

        mloginvm.mResponse.observe(this, EventObserver {
            setdata(it)
        })

        mloginvm.mError.observe(this, androidx.lifecycle.Observer {
            ErrorUtil.handlerGeneralError(this,mBinding.editTextTextPersonName, it)
        }
        )
    }

    private fun setdata(it: LoginResponseModel) {
        showToast(" token :${it.token}")
        Constants.HEADER_TOKEN=it.token
        PreferenceManager.getInstance(this).setAuthToken(it.token)
        PreferenceManager.getInstance(this).setLogin(true)
        startActivity(Intent(this,MainActivity::class.java))
        finish()

    }


    private fun validation(): Boolean {
        if (mBinding.editTextTextPersonName.text.isEmpty()) {
            mBinding.editTextTextPersonName.showSnackBar("Please Enter User Name")
            return false
        } else if (mBinding.editTextTextPassword.text.isEmpty()) {
            mBinding.editTextTextPersonName.showSnackBar("Please Enter Password")
            return false
        }
        return true
    }

}