package com.robbyyehezkiel.androidbeginner.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationInfo
import com.robbyyehezkiel.androidbeginner.data.repository.OrganizationRepository
import com.robbyyehezkiel.androidbeginner.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _organizationList = MutableLiveData<Resource<List<OrganizationInfo>>>()
    val organizationList: LiveData<Resource<List<OrganizationInfo>>> get() = _organizationList

    private val organizationRepository = OrganizationRepository(application)

    fun initializeOrganizationList() {
        _organizationList.postValue(Resource.loading(null))
        viewModelScope.launch {
            try {
                val organizations = organizationRepository.getOrganizationList()
                _organizationList.postValue(Resource.success(organizations))
            } catch (e: Exception) {
                _organizationList.postValue(Resource.error(e.toString(), null))
            }
        }
    }
}
