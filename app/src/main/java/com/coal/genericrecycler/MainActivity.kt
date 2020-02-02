package com.coal.genericrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = object : GenericAdapter<GitRepoModel>(listOf(GitRepoModel("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","flutter/fulterAndroid","28/01/2020","Flutter make it easy and fast to build beautiful mobile apps, this happens"),
            GitRepoModel("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","flutter/fulterAndroid","28/01/2020","Flutter make it easy"),
            GitRepoModel("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","flutter/fulteriOS","02/02/2010","Flutter make it easy and fast to build beautiful mobile apps, this happens,Flutter make it easy and fast to build beautiful mobile apps, this happens"),
            GitRepoModel("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","flutter/angular","19/06/1199","Flutter make "),
            GitRepoModel("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","flutter/swift","11/10/2001","Flutter make it easy"),
            GitRepoModel("https://homepages.cae.wisc.edu/~ece533/images/airplane.png","flutter/java","28/02/1991","respo java"))) {

            override fun getResourceLayout(position: Int, obj: GitRepoModel): Int {
                return when(obj){
                    is GitRepoModel -> R.layout.item_repo_layout
                    else -> R.layout.item_repo_layout
                }
            }

            override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
                return when(viewType){
                    R.layout.item_repo_layout -> RepoHolder(this@MainActivity,view)
                    else -> RepoHolder(this@MainActivity,view)
                }
            }
        }

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter = adapter

    }

}
