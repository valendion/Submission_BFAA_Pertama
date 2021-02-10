package com.example.submission

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterUserGithub(
    private val dataList: ArrayList<UserGithub>,
    private val context: Context
) :RecyclerView.Adapter<AdapterUserGithub.UserGithubHolder>() {


    class UserGithubHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindUserGithub(userGithub: UserGithub, context: Context){
            with(itemView){
                tv_name.text = userGithub.name
                Picasso.get()
                    .load(resources.getIdentifier(userGithub.avatar,
                    "drawable", context.packageName))
                    .into(iv_avatar)
                cv_list_item.setOnClickListener {
                    context.startActivity(Intent(context.applicationContext, DetailActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .putExtra(DetailActivity.EXTRA,userGithub))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserGithubHolder {
        return UserGithubHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: UserGithubHolder, position: Int) {
        holder.bindUserGithub(dataList[position],context)
    }


}