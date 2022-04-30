package com.jb.project.ui.dashboard

import androidx.recyclerview.widget.LinearLayoutManager
import com.jb.project.roomdb.AppDatabase
import com.jb.project.R
import com.jb.project.base.BaseFragment
import com.jb.project.base.EventObserver
import com.jb.project.databinding.DashBoardFragmentBinding
import com.jb.project.extentions.hideProgressDialog
import com.jb.project.extentions.showProgressDialog
import com.jb.project.extentions.showToast
import com.jb.project.ui.dashboard.adapter.ListAdapter
import com.jb.project.utils.ErrorUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashBoardFragment : BaseFragment<DashBoardFragmentBinding>() {
    private val mDashBoardViewModel: DashBoardViewModel by viewModel()

    override fun mLayoutRes(): Int {
        return R.layout.dash_board_fragment
    }

    override fun onViewReady() {
        mBinding.listrecycler.layoutManager = LinearLayoutManager(requireContext())
        mDashBoardViewModel.countrylist()
        obserber()

    }




    private fun obserber() {
        mDashBoardViewModel.mProgressbar.observe(this, {
            if (it) {
                (requireActivity()).showProgressDialog(requireContext(), "")
            } else {
                (requireActivity()).hideProgressDialog()
            }
        })

        mDashBoardViewModel.mResponse.observe(this, EventObserver {
            setdata(it)
        })

        mDashBoardViewModel.mError.observe(this, androidx.lifecycle.Observer {
            ErrorUtil.handlerGeneralError(requireContext(),mBinding.listrecycler, it)
        }
        )
    }

    private fun setdata(it: CountryListResponse) {
        AppDatabase.getDatabase(requireContext()).localDB().clearCategories()
        AppDatabase.getDatabase(requireContext()).localDB().insertCategories(it)
        mBinding.listrecycler.adapter = ListAdapter(AppDatabase.getDatabase(requireContext()).localDB().getAllContact())

    }

}