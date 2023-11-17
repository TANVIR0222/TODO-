package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.todo.databinding.FragmentAddTodoBinding
import com.google.android.material.textfield.TextInputLayout


class AddTodoFragment : DialogFragment() {
    private lateinit var binding: FragmentAddTodoBinding
 private lateinit var listener:DialogAddBtnClickListeners


 fun setListener(listeners: homeFragment){
     this.listener=listener
 }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddTodoBinding.inflate(inflater, container, false)

        binding.tadd.setOnClickListener {

            val text = binding.task.editText?.text.toString()
            if (text.isNotEmpty()) {

                listener.onSaveTask(text, binding.task)

            } else {
                Toast.makeText(context, "Task Add ", Toast.LENGTH_SHORT)
                    .show()

            }
        }

        return binding.root

    }

    interface DialogAddBtnClickListeners {
        fun onSaveTask(todo: String, task: TextInputLayout)
    }
}