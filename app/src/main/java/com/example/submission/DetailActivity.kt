package com.example.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA = "extra_value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(tb_detail)
        supportActionBar?.title = "GithubUserApp"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val userGithub = intent.getParcelableExtra<UserGithub>(EXTRA) as UserGithub

        tv_name_detail.text = userGithub.name
        tv_username.text = userGithub.username
        tv_value_repository.text = userGithub.repository.toString()
        tv_value_follower.text = userGithub.follower.toString()
        tv_value_following.text = userGithub.following.toString()
        tv_company_detail.text = userGithub.company
        tv_location_detail.text = userGithub.location
        loadImage(iv_profile, userGithub.avatar)


    }

    private fun loadImage(img: ImageView, link: String){
        Picasso.get()
            .load(resources.getIdentifier(link,"drawable", packageName))
            .into(img)
    }
}