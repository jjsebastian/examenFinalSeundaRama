package com.utad.javierjimenez.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.utad.javierjimenez.data.network.EmpresaResponseItem
import com.utad.javierjimenez.databinding.ItemBaseBinding

class TaskProjectAdapter(): ListAdapter<EmpresaResponseItem, TaskProjectAdapter.BaseViewHolder>(BaseItemCallBack) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBaseBinding.inflate(inflater, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)

        //TODO pintar datos de la recycler view

        holder.binding.tvTaskTitle.text = item.taskTitle
        holder.binding.tvDescription.text = item.description
        holder.binding.tvProyect.text = "${item.project?.title} - ${item.project?.department}"
        holder.binding.tvDeadline.text = item.deadLine
        holder.binding.tvDetails.text = item.details.toString()
        holder.binding.tvEmployee.text = item.employee



    }


    inner class BaseViewHolder(val binding: ItemBaseBinding) : RecyclerView.ViewHolder(binding.root)


}


object BaseItemCallBack : DiffUtil.ItemCallback<EmpresaResponseItem>() {
    override fun areItemsTheSame(oldItem: EmpresaResponseItem, newItem: EmpresaResponseItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EmpresaResponseItem, newItem: EmpresaResponseItem): Boolean {
        return oldItem == newItem
    }

}