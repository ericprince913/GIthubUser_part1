package com.example.aplikasigithubuser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class HeroDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    private lateinit var nameUser: String
    private lateinit var usernamee: String
    private lateinit var followerUser: String
    private lateinit var followingUser: String
    private lateinit var companyUser: String
    private lateinit var locationUser: String
    private lateinit var repositoryUser: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_hero)

        val user = intent.getParcelableExtra<Hero>(EXTRA_PERSON) as Hero
        val image = user.Avatar
        val gambar = findViewById<ImageView>(R.id.tampil_avatar)
        val name = findViewById<TextView>(R.id.tampil_nama)
        val username = findViewById<TextView>(R.id.tampil_username)
        val followeruser = findViewById<TextView>(R.id.tampil_follower)
        val following = findViewById<TextView>(R.id.tampil_following)
        val company = findViewById<TextView>(R.id.tampil_company)
        val location = findViewById<TextView>(R.id.tampil_location)
        val repository = findViewById<TextView>(R.id.tampil_repository)


        nameUser = user.Name.toString()
        usernamee = user.Username.toString()
        followerUser = user.Follower.toString()
        followingUser = user.Following.toString()
        companyUser = user.Company.toString()
        locationUser = user.Location.toString()
        repositoryUser = user.Repository.toString()

        Glide.with(this).load(image).circleCrop().into(gambar)
        name.text = nameUser
        username.text = usernamee
        followeruser.text = followerUser
        following.text = followingUser
        company.text = companyUser
        location.text = locationUser
        repository.text = repositoryUser

    }
}