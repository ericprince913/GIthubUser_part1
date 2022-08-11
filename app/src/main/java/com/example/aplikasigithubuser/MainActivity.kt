package com.example.aplikasigithubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val list = java.util.ArrayList<Hero>()
    private lateinit var rvHeroes: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        list.addAll(listHeroes)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: Hero) {
                showSelectedUser(data)
            }
        })
    }

    private val listHeroes: java.util.ArrayList<Hero>
        get() {
            val dataAvatar = resources.obtainTypedArray(R.array.Avatar)
            val dataName = resources.getStringArray(R.array.Name)
            val dataUsername = resources.getStringArray(R.array.Username)
            val dataFollowers = resources.getStringArray(R.array.Follower)
            val dataFollowing = resources.getStringArray(R.array.Following)
            val dataCompany = resources.getStringArray(R.array.Company)
            val dataLocation = resources.getStringArray(R.array.Location)
            val dataRepository = resources.getStringArray(R.array.Repository)

            val listHero = java.util.ArrayList<Hero>()
            for (position in dataName.indices) {
                val user = Hero(
                    dataAvatar.getResourceId(position, -1),
                    dataName[position],
                    dataUsername[position],
                    dataFollowers[position],
                    dataFollowing[position],
                    dataCompany[position],
                    dataLocation[position],
                    dataRepository[position],

                )
                listHero.add(user)
            }
            return listHero
        }

    private fun showSelectedUser(data: Hero) {
        val moveObjectWithIntent = Intent(this@MainActivity, HeroDetail::class.java)
        moveObjectWithIntent.putExtra(HeroDetail.EXTRA_PERSON, data)
        startActivity(moveObjectWithIntent)
    }


}