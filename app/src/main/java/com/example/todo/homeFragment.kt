package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todo.databinding.FragmentHomeBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class homeFragment : Fragment(), AddTodoFragment.DialogAddBtnClickListeners {

    lateinit var binding: FragmentHomeBinding
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var database: DatabaseReference
    lateinit var todoFragment: AddTodoFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addData()
        registerEven()


    }

    private fun registerEven() {

        binding.add.setOnClickListener{

            todoFragment= AddTodoFragment()
            todoFragment.setListener(this)
            todoFragment.show(
                childFragmentManager,
                "todoFragment"
            )

        }


    }

    private fun addData(){
        firebaseAuth=FirebaseAuth.getInstance()
        database=FirebaseDatabase.getInstance().reference
    }

    override fun onSaveTask(todo: String, task: TextInputLayout) {


    }


}