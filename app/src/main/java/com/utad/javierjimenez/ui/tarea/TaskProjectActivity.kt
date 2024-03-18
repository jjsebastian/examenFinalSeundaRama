package com.utad.javierjimenez.ui.tarea

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.javierjimenez.R
import com.utad.javierjimenez.databinding.ActivityTaskProjectBinding
import com.utad.javierjimenez.ui.adapter.TaskProjectAdapter

class TaskProjectActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityTaskProjectBinding
    private val binding : ActivityTaskProjectBinding get() = _binding
    private val viewModel: TaskProjectViewModel by viewModels()
    private val adapter: TaskProjectAdapter = TaskProjectAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTaskProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProjects.layoutManager = LinearLayoutManager(this)
        binding.rvProjects.adapter = adapter

        viewModel.getUserName(this)
        observerViewModel()

    }

    private fun observerViewModel() {
        viewModel.userName.observe(this){userName ->
            if(userName!= null){
                viewModel.getTask(userName)
            }
        }
        viewModel.uiState.observe(this){uiState ->
            if(uiState.response!=null){

            }
        }
    }
}