package com.latihan.capstoneproject.data.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.latihan.capstoneproject.databinding.ListItemBinding
import com.latihan.capstoneproject.response.ItemsItem
import com.latihan.capstoneproject.ui.main.DetailActivity

class ListAdapter(private val listUser: ArrayList<ItemsItem>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
    inner class ListViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        holder.binding.nama.text = user.name
        holder.binding.alamat.text = user.address
        Glide.with(holder.binding.rvStory.context)
            .load(user.photo)
            .circleCrop()
            .into(holder.binding.rvStory)

        holder.itemView.setOnClickListener {
            val selectedUser = listUser[holder.bindingAdapterPosition]
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_NAME, selectedUser.name)
            intent.putExtra(DetailActivity.EXTRA_ADDRESS, selectedUser.address)
            intent.putExtra(DetailActivity.EXTRA_PHOTO, selectedUser.photo)
            intent.putExtra(DetailActivity.EXTRA_DESCRIPTION, selectedUser.description)
            intent.putExtra(DetailActivity.SET, listUser[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: ItemsItem)
    }
    interface OnItemClickListener {
        fun onItemSelect(data: ItemsItem)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(itemsItem: ArrayList<ItemsItem>) {
        listUser.clear()
        listUser.addAll(itemsItem)
        notifyDataSetChanged()
    }
}
