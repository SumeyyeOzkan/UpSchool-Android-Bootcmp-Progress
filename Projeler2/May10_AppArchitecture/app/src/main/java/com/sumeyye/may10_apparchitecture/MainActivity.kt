package com.sumeyye.may10_apparchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import java.security.acl.Owner

class MainActivity : AppCompatActivity() , DefaultLifecycleObserver {

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(this)

    }

    override fun onStart() {
        super<AppCompatActivity>.onStart()
        Log.v("AKBANK","ON_START")
        playSound()
    }

    override fun onStart(owner: LifecycleOwner) {
        super<DefaultLifecycleObserver>.onStart(owner)
        Log.v("AKBANK","ON_START")
        playSound()
    }

    fun playSound(){

    }

    /*
    //lifecycle.addObserver(lifecycleEventObserver) //bunu override fun içine ekleyeceksin
    private val lifecycleEventObserver=LifecycleEventObserver { source, event ->
        if (event==Lifecycle.Event.ON_RESUME){
            Log.v("AKBANK","RESUMED")
        }
        else if  (event==Lifecycle.Event.ON_PAUSE){
            Log.v("AKBANK","PAUSED")
        }
    }

     */

    /*
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun playSound(){
        Log.v("AKBANK","ON_START")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun playVideo(){
        Log.v("AKBANK","ON_START")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopVideo(){
        Log.v("AKBANK","ON_PAUSE")

    }

     */
}