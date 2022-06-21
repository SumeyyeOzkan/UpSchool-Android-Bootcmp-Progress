package com.sumeyye.april28_activity_fragment_lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class BlankFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("AKBANK", "onCreate Called") //2. GELİR

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.v("AKBANK", "onCreateView called") //3. GELİR
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("AKBANK", "onViewCreatedView Called")
    }


    override fun onAttach(context: Context) { //1. GELİR //açılır açılmaz çalışır. fRAGMENT activity'e dokundu
        super.onAttach(context)
        Log.v("AKBANK", "onAttach Called")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.v("AKBANK", "onViewStateRestored Called")
    }

    override fun onStart() {
        super.onStart()
        Log.v("AKBANK", "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.v("AKBANK", "onResume Called")
    }

    override fun onPause() { //fragmentten ayrıldığını gösteren ilk gösterge
        super.onPause()
        Log.v("AKBANK", "onPause Called")
    }

    override fun onStop() { //fragment sonlandığında çalışır
        super.onStop()
        Log.v("AKBANK", "onStop Called")
    }

    override fun onSaveInstanceState(outState: Bundle) { //uygulama arasında geçiş ekranına geldiğinde çalışır
        super.onSaveInstanceState(outState)
        Log.v("AKBANK", "onSaveInstanceState Called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("AKBANK", "onDestroyView Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("AKBANK", "onDestroy Called")
    }

    override fun onDetach() { //Fragmentle ilgili bağlantıyı koparır
        super.onDetach()
        Log.v("AKBANK", "onDetach Called")
    }
}