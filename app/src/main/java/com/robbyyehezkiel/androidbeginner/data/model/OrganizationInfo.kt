package com.robbyyehezkiel.androidbeginner.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrganizationInfo(
    val id: Int = 0,
    val organizationName: String = "",
    val organizationIcon: Int = 0,
    val leaderName: String = "",
    val description: String = "",
    val members: Int = 0,
    val color: Int = 0,
    val photoResId: Int = 0
) : Parcelable
