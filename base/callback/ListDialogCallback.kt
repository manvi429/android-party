package com.jb.project.base.callback

interface ListDialogCallback {
    fun onItemSelected(which: Int?, selectedData: String?, dialogId: Int?)
    fun onDismiss(dialogId: Int?)
}