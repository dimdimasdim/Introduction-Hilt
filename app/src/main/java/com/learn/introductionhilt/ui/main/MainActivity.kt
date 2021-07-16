package com.learn.introductionhilt.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learn.introductionhilt.R
import com.learn.introductionhilt.data.model.User
import com.learn.introductionhilt.ui.adapter.MainAdapter
import com.learn.introductionhilt.ui.viewmodel.MainViewModel
import com.learn.introductionhilt.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    private var listUser: RecyclerView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiateUIComponent()
        setupUI()
        setupObserver()
    }

    private fun initiateUIComponent() {
        listUser = findViewById(R.id.listUser)
        progressBar = findViewById(R.id.progressBar)
    }

    private fun setupUI() {
        adapter = MainAdapter(arrayListOf())
        listUser?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
            adapter = this@MainActivity.adapter
        }
    }

    private fun setupObserver() {
        mainViewModel.users.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar?.isVisible = false
                    it.data?.let { users -> renderList(users) }
                }
                Status.LOADING -> {
                    progressBar?.isVisible = true
                    listUser?.isVisible = false
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar?.isVisible = false
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        listUser?.isVisible = true
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

}