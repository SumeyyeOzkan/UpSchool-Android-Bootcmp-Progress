package com.sumeyye.april_23_app_navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController


class AFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_a, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button:Button= view.findViewById(R.id.button)
        button.setOnClickListener {
            //findNavController().navigate(R.id.action_AFragment_to_dialogFragment) //a fragmentinden dialog fragmente gider
            //findNavController().navigate(R.id.action_AFragment_to_loginActivity)
           //startActivity(Intent(context,LoginActivity::class.java)) //2. YOL, bu şekilde de sayfa değişikliği yapılabilir
           //findNavController().navigate(R.id.action_AFragment_to_loginActivity, bundleOf("user" to "sumeyyeOzkan")) //sumeyyeOzkan adında veri göndereceğiz
            //findNavController().navigate(R.id.action_AFragment_to_nav_start)
            //findNavController().navigate(R.id.myaction)
            //findNavController().navigate(R.id.BFragment)
            /*val number=9
            val bundle=bundleOf("number" to number)
            findNavController().navigate(R.id.BFragment,bundle) */
            val mynumber=19
            val action=AFragmentDirections.actionAFragmentToBFragment(mynumber)
            findNavController().navigate(action)
        //findNavController().navigate(R.id.action_AFragment_to_BFragment2)
        }
    }

}