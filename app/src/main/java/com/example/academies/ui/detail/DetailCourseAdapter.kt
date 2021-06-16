package com.example.academies.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.academies.data.source.local.entity.ModuleEntity
import com.example.academies.databinding.ItemsModuleListBinding

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {

    private val listModule = ArrayList<ModuleEntity>()

    fun setModule(modules: List<ModuleEntity>?) {
        if (modules == null) return
        this.listModule.clear()
        this.listModule.addAll(modules)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModuleViewHolder {
        val itemModuleListBinding =
            ItemsModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(itemModuleListBinding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = listModule[position]
        holder.bind(module)
    }

    override fun getItemCount(): Int = listModule.size

    inner class ModuleViewHolder(private val binding: ItemsModuleListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }

    }
}