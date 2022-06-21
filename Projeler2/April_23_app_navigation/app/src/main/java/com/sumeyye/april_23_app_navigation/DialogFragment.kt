package com.sumeyye.april_23_app_navigation

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogFragment:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder= AlertDialog.Builder(it)
            builder.setMessage("This dialog window")
                .setPositiveButton("OK",
                    DialogInterface.OnClickListener { dialog, id ->

                    } )
                .setNegativeButton("Cancel",DialogInterface.OnClickListener { dialog, id ->

                })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}