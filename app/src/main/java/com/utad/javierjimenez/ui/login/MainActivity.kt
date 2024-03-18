package com.utad.javierjimenez.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.utad.javierjimenez.R
import com.utad.javierjimenez.databinding.ActivityMainBinding
import com.utad.javierjimenez.ui.tarea.TaskProjectActivity

class MainActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainBinding
    private val binding : ActivityMainBinding get() = _binding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tbnAcceso.setOnClickListener{
            saveUser()

        }
    }

    private fun saveUser() {
        val name = binding.etName.text.toString().trim()
        if(!name.isNullOrEmpty()){
            viewModel.saveUserName(this,name)
            goToHomeWork()
        }else{
            Toast.makeText(this,"introduce texto", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToHomeWork() {
        val intent = Intent(this, TaskProjectActivity::class.java)
        startActivity(intent)
        finish()
    }
}