package com.sumeyye.sm

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.sumeyye.sm.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var fAuth:FirebaseAuth

    private var _binding: FragmentLoginBinding?=null
    private val binding get()=_binding!!


    override fun onCreate(savedInstanceState: Bundle?) { //sadece sayfa açılır. Bunun bilgisi gelir
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(  //xml tasarımı oluşturulur
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater)

        fAuth= FirebaseAuth.getInstance()
        return binding.root
    }



    override fun onViewCreated( // tüm kodlar buraya
        view: View,
        savedInstanceState: Bundle?
    ) { //tasarıma ait işlemler yapılır
        super.onViewCreated(view, savedInstanceState)

        binding.txtAccount.setOnClickListener{
            clicksignup()
        }
        binding.txtAccount.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_forgtFragment)

        }
        /*
        binding.button.setOnClickListener{
            googleAuth()
        }
         */

        binding.btnLogin.setOnClickListener {
            validateForm()
        }

    }

    private fun clicksignup()
    {
        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
    }

    /*
    private fun googleAuth(){
        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.your_web_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(true)
                    .build())
            .build()
    } */

    private fun firebbaseLogin(){

        fAuth.signInWithEmailAndPassword(binding.lEmail.text.toString(),binding.lPassword.text.toString()).addOnCompleteListener{
                task ->
            if (task.isSuccessful){
                findNavController().navigate(R.id.action_loginFragment_to_nav_graph)
                Toast.makeText(context,"Giriş Başarılı",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,task.exception?.message,Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateForm() {
        val icon = AppCompatResources.getDrawable(
            requireContext(),
            R.drawable.ic_baseline_error_outline_24
        )


        icon?.setBounds(0, 0, icon.intrinsicWidth, icon.intrinsicHeight)
        when {
            TextUtils.isEmpty(binding.lEmail.text.toString().trim()) -> {
                binding.lEmail.setError("Lütfen email adresinizi giriniz", icon)
            }
            TextUtils.isEmpty(binding.lPassword.text.toString().trim()) -> {
                binding.lPassword.setError("Lütfen parolanızı giriniz", icon)
            }
            binding.lPassword.text.toString().isNotEmpty() &&
                    binding.lEmail.text.toString().isNotEmpty() -> {

                if (binding.lPassword.text.toString().length >= 5) {
                    firebbaseLogin()
                } else {
                    binding.lPassword.setError("Parola en az 5 karakter olmalıdır", icon)
                }


            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}