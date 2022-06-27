package com.sumeyye.sm

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.sumeyye.sm.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    private lateinit var fAuth:FirebaseAuth

    private var _binding:FragmentSignupBinding?=null
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding=FragmentSignupBinding.inflate(inflater)


        fAuth= FirebaseAuth.getInstance()

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding.btnRegister.setOnClickListener {
           validateEmptyForm()

        }
        binding.txtForgetPas.setOnClickListener{
            clicklogin()
        }
    }

    private fun clicklogin()
    {
        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
    }





    private fun firebbaseSignUp(){
        fAuth.createUserWithEmailAndPassword(binding.email.text.toString(),binding.password.text.toString()).addOnCompleteListener{
            task ->
            if (task.isSuccessful){
                findNavController().navigate(R.id.action_signupFragment_to_nav_graph)
                Toast.makeText(context,"Giriş Başarılı",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,task.exception?.message,Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateEmptyForm(){
        val icon= AppCompatResources.getDrawable(requireContext(),
            R.drawable.ic_baseline_error_outline_24)


        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)
        when{
           // binding.apply {  }

            TextUtils.isEmpty(binding.email.text.toString().trim())-> {
                binding.email.setError("Lütfen email adresinizi giriniz", icon)
            }
            TextUtils.isEmpty(binding.password.text.toString().trim())-> {
                binding.password.setError("Lütfen parolanızı giriniz", icon)
            }
                    binding.password.text.toString().isNotEmpty() &&
                    binding.email.text.toString().isNotEmpty() ->
            {

                if(binding.password.text.toString().length>=6){
                    firebbaseSignUp()
                }
                else{
                    binding.password.setError("Parola en az 5 karakter olmalıdır",icon)
                }

            }
        }
    }

}
