package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.todo.databinding.FragmentSIngUpBinding
import com.google.firebase.auth.FirebaseAuth

class SIngUpFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth

    //    lateinit var navController: NavController
    lateinit var binding: FragmentSIngUpBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        firebaseAuth = FirebaseAuth.getInstance()
        binding = FragmentSIngUpBinding.inflate(inflater, container, false)

        binding.singUp.setOnClickListener {
            val name = binding.name.editText?.text.toString().trim()
            val email = binding.Semail.editText?.text.toString().trim()
            val password = binding.Spassword.editText?.text.toString().trim()
            val conPass = binding.cpassword.editText?.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && conPass.isNotEmpty()) {
                if (password == conPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                findNavController().navigate(R.id.action_SIngUpFragment_to_homeFragment)

                            } else {
                                Toast.makeText(context, "network problem", Toast.LENGTH_SHORT)
                                    .show()

                            }
                        }

                } else {
                    Toast.makeText(context, "not match password ", Toast.LENGTH_SHORT).show()

                }

            } else {

                Toast.makeText(context, "please fill the all information ", Toast.LENGTH_SHORT)
                    .show()


            }

        }

        nextPage()

        return binding.root
    }

   private fun nextPage(){
       binding.tsing.setOnClickListener {
           findNavController().navigate(R.id.action_SIngUpFragment_to_singinFragment)

       }

    }




}