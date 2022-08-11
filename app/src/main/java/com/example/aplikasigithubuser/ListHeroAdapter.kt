package com.example.aplikasigithubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.collections.ArrayList


class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickDetail: OnItemClickCallBack
    private var filterUsers: ArrayList<Hero> = listHero

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickDetail = onItemClickCallBack
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivAvatar: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = filterUsers[position]
        Glide.with(holder.itemView)
            .load(user.Avatar)
            .circleCrop()
            .into(holder.ivAvatar)
        with(holder) {
            tvName.text = user.Name
            tvUsername.text = user.Username
            itemView.setOnClickListener { onItemClickDetail.onItemClicked(filterUsers[holder.adapterPosition]) }
        }
    }

    override fun getItemCount(): Int = listHero.size

    interface OnItemClickCallBack {
        fun onItemClicked(data: Hero)
    }

}