// MainViewModel.kt
package com.robbyyehezkiel.androidbeginner.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationInfo
import com.robbyyehezkiel.androidbeginner.data.repository.OrganizationRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _organizationList = MutableLiveData<List<OrganizationInfo>>()
    val organizationList: LiveData<List<OrganizationInfo>> get() = _organizationList

    private val organizationRepository = OrganizationRepository(application)

    fun initializeOrganizationList() {
        try {
            val organizations = organizationRepository.getOrganizationList()
            _organizationList.postValue(organizations)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
