package com.robbyyehezkiel.androidbeginner.view.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.robbyyehezkiel.androidbeginner.R
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationDataHolder
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationInfo
import com.robbyyehezkiel.androidbeginner.databinding.ActivityDetailBinding
import com.robbyyehezkiel.androidbeginner.utils.loadImage

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var organization: OrganizationInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        organization = OrganizationDataHolder.organization
        organization?.let {
            setupActionBar(it)
            setupUI(it)
            setupSocialMediaIcons()
        } ?: run {
            logNoDataWarning()
            Snackbar.make(binding.root, "No data received", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun setupUI(organization: OrganizationInfo) {
        with(binding) {
            organizationIconImageView.loadImage(
                organization.organizationIcon,
                R.drawable.placeholder
            )
            iconFrameLayout.setBackgroundColor(organization.color)
            organizationPhotoImageView.loadImage(organization.photoResId, R.drawable.placeholder)
            organizationMembers.text = organization.members.toString()
            organizationMembers.setTextColor(organization.color)
            organizationLeaders.text = organization.leaderName
            organizationLeaders.setTextColor(organization.color)
            organizationDescriptionTextView.text = organization.description
        }
    }

    private fun setupActionBar(organization: OrganizationInfo) {
        supportActionBar?.apply {
            title = organization.organizationName
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupSocialMediaIcons() {
        binding.socialMediaIconInstagram.setOnClickListener {
            openSocialMediaUrl("https://www.instagram.com/himasiunja/")
        }

        binding.socialMediaIconYoutube.setOnClickListener {
            openSocialMediaUrl("https://www.youtube.com/@sisteminformasiuniversitas5901")
        }

        binding.socialMediaLinkedIn.setOnClickListener {
            openSocialMediaUrl("https://www.linkedin.com/company/himasi-unja/?originalSubdomain=id")
        }
    }

    private fun openSocialMediaUrl(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    private fun logNoDataWarning() {
        Log.w(getString(R.string.log_tag_detail_activity), "No data received.")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                organization?.let {
                    shareOrganizationDetails(it)
                }
                true
            }

            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareOrganizationDetails(organization: OrganizationInfo) {
        val shareText = getString(
            R.string.share_text_format,
            organization.organizationName,
            organization.description
        )
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }
        val chooser = Intent.createChooser(intent, getString(R.string.share_chooser_title))
        if (chooser.resolveActivity(packageManager) != null) {
            startActivity(chooser)
        } else {
            Log.e(getString(R.string.log_tag_detail_activity), "No app to handle the share action.")
        }
    }
}
