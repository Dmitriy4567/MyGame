package com.example.mygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout:DrawerLayout=findViewById(R.id.drawerLayout)
        val navView: NavigationView=findViewById(R.id.navView)

        val header:View=navView.inflateHeaderView(R.layout.nav_header)
        var userName:TextView=header.findViewById(R.id.user_name)
        var ivPhotoPersonsNav:ImageView=header.findViewById(R.id.ivPhotoPersonsNav)
        var tvNumberSilaNav:TextView=header.findViewById(R.id.tvNumberSilaNav)
        var tvNumberLovkostNav:TextView=header.findViewById(R.id.tvNumberLovkostNav)
        var tvNumberIntelectNav:TextView=header.findViewById(R.id.tvNumberIntelectNav)
        var tvNumberRazmerNav:TextView=header.findViewById(R.id.tvNumberRazmerNav)
        var tvOpisanieNav:TextView=header.findViewById(R.id.tvOpisanieNav)

        val bundle: Bundle? =intent.extras
        val name= bundle!!.getString("Name")
        val photoPersons= bundle!!.getInt("PhotoPersons")
        val numberSila= bundle!!.getString("NumberSila")
        val numberLovkost= bundle!!.getString("NumberLovkost")
        val numberIntelect= bundle!!.getString("NumberIntelect")
        val numberRazmer= bundle!!.getString("NumberRazmer")
        val opisanie= bundle!!.getString("Opisanie")

        userName.text=name
        ivPhotoPersonsNav.setImageResource(photoPersons)
        tvNumberSilaNav.text=numberSila
        tvNumberLovkostNav.text=numberLovkost
        tvNumberIntelectNav.text=numberIntelect
        tvNumberRazmerNav.text=numberRazmer
        tvOpisanieNav.text=opisanie

        toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){

                R.id.nav_harakteristiki-> replaceFragment(HarakteristikiFragment(), it.title.toString())
                R.id.nav_inventar-> replaceFragment(ItemFragment(), it.title.toString())
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if ( toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}