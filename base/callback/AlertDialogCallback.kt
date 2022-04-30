package com.jb.project.base.callback

interface AlertDialogCallback {

    fun onPositiveButton(dialogId: Int)

    fun onNegativeButton(dialogId: Int)
}