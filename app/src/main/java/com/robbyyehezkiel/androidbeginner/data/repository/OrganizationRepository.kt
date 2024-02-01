package com.robbyyehezkiel.androidbeginner.data.repository

import android.app.Application
import com.robbyyehezkiel.androidbeginner.R
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationInfo

class OrganizationRepository(private val application: Application) {

    fun getOrganizationList(): List<OrganizationInfo> {
        val organizationList = mutableListOf<OrganizationInfo>()

        val dataId = application.resources.getIntArray(R.array.organization_ids)
        val dataName = application.resources.getStringArray(R.array.organization_names)
        val dataIcon = application.resources.obtainTypedArray(R.array.organization_icons)
        val dataLeader = application.resources.getStringArray(R.array.organization_leaders)
        val dataDescription =
            application.resources.getStringArray(R.array.organization_descriptions)
        val dataMembers = application.resources.getIntArray(R.array.organization_members)
        val dataColors = application.resources.getIntArray(R.array.organization_colors)
        val dataPhotos = application.resources.obtainTypedArray(R.array.organization_photos)

        for (i in dataId.indices) {
            val organization = OrganizationInfo(
                dataId[i],
                dataName[i],
                dataIcon.getResourceId(i, -1),
                dataLeader[i],
                dataDescription[i],
                dataMembers[i],
                dataColors[i],
                dataPhotos.getResourceId(i, -1)
            )
            organizationList.add(organization)
        }

        dataIcon.recycle()
        dataPhotos.recycle()

        return organizationList
    }
}
