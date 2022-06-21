package com.sumeyye.april_23_app_navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgument


//private const val ARG_PARAM1 = "number"


class BFragment : Fragment() {
    //private var number: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // arguments?.let {
            //number = it.getInt(ARG_PARAM1)
       // }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // Log.v("NUMBER",number.toString())
       // return inflater.inflate(R.layout.fragment_b, container, false)
        val args:BFragmentArgs by navArgs()
        Log.v("BFragmentArgs",args.mynumber.toString())
        return inflater.inflate(R.layout.fragment_b, container, false)
    }


}