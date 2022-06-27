package com.sumeyye.sm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.sumeyye.sm.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var fAuth: FirebaseAuth
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater)

        fAuth= FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileFragmentObject = this

        with(binding) {

            btnSingOut.setOnClickListener {
                fAuth.signOut()
                findNavController().navigate(R.id.action_profileFragment_to_loginFragment2)
                }
            }


            fAuth.currentUser?.let {
                binding.pEmail.text=it.email
            }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



