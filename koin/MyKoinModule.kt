package com.jb.project.koin


import com.jb.project.api.WebServiceRequests
import com.jb.project.ui.HomeVM
import com.jb.project.ui.dashboard.DashBoardViewModel
import com.jb.project.ui.login.LoginVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { WebServiceRequests() }

//    factory { (mListener: MyClickListener) -> AdapterPassCode(mListener) }

    viewModel { HomeVM(get()) }
    viewModel { DashBoardViewModel(get()) }
    viewModel { LoginVm(get()) }


}