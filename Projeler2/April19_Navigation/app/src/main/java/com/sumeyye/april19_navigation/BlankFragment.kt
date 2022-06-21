package com.sumeyye.april19_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.sumeyye.april19_navigation.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    //private lateinit var button: Button
    private lateinit var fragmentBlankBinding: FragmentBlankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentBlankBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_blank,container,false)
        //val view=inflater.inflate(R.layout.fragment_blank,container,false)

        return fragmentBlankBinding.root
        //return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       fragmentBlankBinding.button.setOnClickListener {
           findNavController().navigate(R.id.action_blankFragment_to_blankFragment22)
        }

       /* button=view.findViewById(R.id.button)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_blankFragment22) //nav_graph içinde yer alan action id'si
            //butona tıklandığında öbür sayfaya geçiş sağlanıyor

        } */
    }

}