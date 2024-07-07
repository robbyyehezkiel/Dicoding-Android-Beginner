package com.robbyyehezkiel.androidbeginner.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.robbyyehezkiel.androidbeginner.R
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationDataHolder
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationInfo
import com.robbyyehezkiel.androidbeginner.databinding.ActivityMainBinding
import com.robbyyehezkiel.androidbeginner.utils.Status
import com.robbyyehezkiel.androidbeginner.view.adapter.OrganizationListAdapter
import com.robbyyehezkiel.androidbeginner.view.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var organizationAdapter: OrganizationListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.main_page_title)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        organizationAdapter = OrganizationListAdapter { data ->
            navigateToDetailActivity(data)
        }

        setupRecyclerView()
        observeViewModel()

        viewModel.initializeOrganizationList()
    }

    private fun setupRecyclerView() {
        binding.rvOrganizations.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = organizationAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.organizationList.observe(this) { result ->
            when (result.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    result.data?.let {
                        organizationAdapter.setOrganizationList(it)
                    }
                }

                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(binding.root, result.message ?: "Error", Snackbar.LENGTH_LONG)
                        .show()
                }

                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun navigateToDetailActivity(data: OrganizationInfo) {
        OrganizationDataHolder.organization = data
        startActivity(Intent(this, DetailActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                startActivity(AboutActivity.newIntent(this))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
