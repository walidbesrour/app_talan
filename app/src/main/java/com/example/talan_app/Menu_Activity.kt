package com.example.talan_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.talan_app.databinding.ActivityMenuBinding
import com.example.talan_app.menu_fragments.*

class Menu_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding


    private val asetFragment = ActifFragment()
    private val homeFragment = HomeFragment()
    private val interventionFragment = InterventionFragment()
    private val serviceFragment = ServiceFragment()

//    private val actifFilsFragment = ActifFilsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val assetnum = intent.getStringExtra("assetnum")
        val siteid = intent.getStringExtra("siteid")

        val actifFilsFragment = ActifFilsFragment(siteid , assetnum)

        if(assetnum == null){
            setSupportActionBar(binding.toolbar)
            replaceFragment(homeFragment)
        }else{
            setSupportActionBar(binding.toolbar)
            replaceFragment(actifFilsFragment)
        }




        binding.chipNavigation.setOnItemSelectedListener {
            when (it){
                R.id.home ->  replaceFragment(homeFragment)
                R.id.actif ->  replaceFragment(asetFragment)
                R.id.service ->  replaceFragment(serviceFragment)
                R.id.intervention ->  replaceFragment(interventionFragment)
                     }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      var itemview = item.itemId
        when(itemview){
            R.id.notfication -> Toast.makeText(applicationContext, "notfication",Toast.LENGTH_LONG).show()
        }


        return false
    }


    private fun replaceFragment(fragment: Fragment){
        val transaction =supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

}