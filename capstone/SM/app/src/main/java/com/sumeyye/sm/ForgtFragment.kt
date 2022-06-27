package com.sumeyye.sm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.sumeyye.sm.databinding.FragmentForgtBinding


class ForgtFragment : Fragment() {
    private lateinit var binding:FragmentForgtBinding
    private lateinit var fAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,
        R.layout.fragment_forgt,container,false)
        fAuth=FirebaseAuth.getInstance()

        binding.btnForget.setOnClickListener{
            val femail=binding.fEmail.text.toString()
            if (femail.isNotEmpty()){
                fAuth.sendPasswordResetEmail(femail).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context,"Şifreniz sıfırlanmıştır. Mailinizi kontrol ediniz",Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_forgtFragment_to_loginFragment)
                    }else{
                        Toast.makeText(context,it.exception?.message,Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(context,"Email adresinizin doğru olduğundan emin olun",Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


}