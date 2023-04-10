package com.example.mygame

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment

class NewGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        supportActionBar?.hide()
        replaseFragment(NewGameFragment())

        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                    val builder = AlertDialog.Builder(ContextThemeWrapper(this@NewGameActivity, android.R.style.Theme_DeviceDefault_Panel))
                    builder.setTitle("Выход")
                    builder.setMessage("Вы действительно хотите выйти?")

                    builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                        finishAffinity()
                        Toast.makeText(applicationContext,
                            android.R.string.yes, Toast.LENGTH_SHORT).show()
                    }

                    builder.setNegativeButton(android.R.string.no) { dialog, which ->
                        Toast.makeText(applicationContext,
                            android.R.string.no, Toast.LENGTH_SHORT).show()
                    }
                    builder.show()

            }

        })
    }

    private fun replaseFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayoutNG,fragment)
        fragmentTransaction.commit()
    }
}