package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todo.databinding.FragmentSinginBinding
import com.google.firebase.auth.FirebaseAuth

class SinginFragment : Fragment() {

    lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: FragmentSinginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseAuth = FirebaseAuth.getInstance()

        binding = FragmentSinginBinding.inflate(inflater, container, false)


        binding.singIn.setOnClickListener {
            val email = binding.email.editText?.text.toString().trim()
            val passWord = binding.password.editText?.text.toString().trim()

            if (email.isNotEmpty() && passWord.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, passWord).addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(R.id.action_singinFragment_to_homeFragment)

                    } else {
                        Toast.makeText(context, "create New account ", Toast.LENGTH_SHORT)
                            .show()


                    }
                }

            } else {
                Toast.makeText(context, "please fill the all information ", Toast.LENGTH_SHORT)
                    .show()

            }
        }


        createNewAccount()
        return binding.root

    }

    private fun createNewAccount() {
        binding.newAccount.setOnClickListener {
            findNavController().navigate(R.id.action_singinFragment_to_SIngUpFragment)
        }
    }


}