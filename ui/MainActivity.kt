package com.jb.project.ui

import android.content.Intent
import android.graphics.Paint
import android.view.View
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.jb.project.R
import com.jb.project.base.BaseActivity
import com.jb.project.databinding.ActivityMainBinding
import com.jb.project.ui.dashboard.DashBoardViewModel
import com.jb.project.ui.login.LoginActivity
import com.jb.project.utils.PreferenceManager
import kotlinx.android.synthetic.main.drawer_header.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity() : BaseActivity<ActivityMainBinding>() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var inflateHeaderView: View

    private val mHomeVM: HomeVM by viewModel()

    override fun mLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onViewReady() {
        setSupportActionBar(mBinding.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController)

        mBinding.imglogout.setOnClickListener {
            PreferenceManager.getInstance(this).clear()
            finish()
            startActivity(Intent(this,LoginActivity::class.java))

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }


}