package com.robbyyehezkiel.androidbeginner.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.robbyyehezkiel.androidbeginner.data.model.OrganizationInfo
import com.robbyyehezkiel.androidbeginner.databinding.ItemRowOrganizationBinding

class OrganizationListAdapter(private val onItemClickCallback: (OrganizationInfo) -> Unit) :
    RecyclerView.Adapter<OrganizationListAdapter.OrganizationViewHolder>() {

    private var organizationList: List<OrganizationInfo> = emptyList()

    fun setOrganizationList(newList: List<OrganizationInfo>) {
        val diffResult =
            DiffUtil.calculateDiff(OrganizationListDiffCallback(organizationList, newList))
        organizationList = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationViewHolder {
        val binding =
            ItemRowOrganizationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrganizationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrganizationViewHolder, position: Int) {
        holder.bind(organizationList[position])
    }

    override fun getItemCount(): Int = organizationList.size

    inner class OrganizationViewHolder(private val binding: ItemRowOrganizationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(organization: OrganizationInfo) {
            binding.apply {
                tvItemId.text = organization.id.toString()
                tvItemOrganizationName.text = organization.organizationName
                imgItemOrganizationIcon.setImageResource(organization.organizationIcon)
                cardView.setCardBackgroundColor(organization.color)

                root.setOnClickListener {
                    onItemClickCallback.invoke(organization)
                }
            }
        }
    }

    private class OrganizationListDiffCallback(
        private val oldList: List<OrganizationInfo>,
        private val newList: List<OrganizationInfo>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}
