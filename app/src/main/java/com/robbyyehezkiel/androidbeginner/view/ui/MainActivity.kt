// MainActivity.kt
package com.robbyyehezkiel.androidbeginner.view.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.robbyyehezkiel.androidbeginner.R
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationInfo
import com.robbyyehezkiel.androidbeginner.databinding.ActivityMainBinding
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
        viewModel.organizationList.observe(this) { organizations ->
            organizations?.let {
                organizationAdapter.setOrganizationList(it)
            }
        }
    }

    private fun navigateToDetailActivity(data: OrganizationInfo) {
        startActivity(DetailActivity.newIntent(this, data))
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
