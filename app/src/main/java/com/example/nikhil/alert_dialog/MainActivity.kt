package com.example.nikhil.alert_dialog

import android.content.DialogInterface
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.example.nikhil.alert_dialog.R.id.English
import com.example.nikhil.alert_dialog.R.id.Hindi
import org.intellij.lang.annotations.Language

lateinit var  tv:TextView
lateinit var language: String
lateinit var shared_preference:SharedPreferences

class MainActivity : AppCompatActivity() {

    fun set_language(language: String){


        shared_preference.edit().putString("language",language).apply()
        tv.text=language
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menu_inflator:MenuInflater=menuInflater
        menu_inflator.inflate(R.menu.main_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.English)
        {

            language="English"
            set_language(language)
        }
        else
        {
            language="Hindi"
            set_language(language)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv=findViewById(R.id.tv)
        shared_preference=this@MainActivity.getSharedPreferences("com.example.nikhil.alert_dialog",android.content.Context.MODE_PRIVATE)
        language=shared_preference.getString("language", "")




        if(language==""){
            AlertDialog.Builder(this@MainActivity)
                    .setTitle("Are You Sure")
                    .setMessage("Which language would you like?")
                    .setIcon(android.R.drawable.ic_btn_speak_now)
                    .setNegativeButton("English",object :DialogInterface.OnClickListener{
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            Toast.makeText(this@MainActivity,"English ",Toast.LENGTH_SHORT).show()
                            language="English"
                            set_language(language)

                        }


                    })

                    .setPositiveButton("Hindi",object :DialogInterface.OnClickListener{
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            Toast.makeText(this@MainActivity,"Hindi  ",Toast.LENGTH_SHORT).show()
                            language="Hindi"
                            set_language(language)
                        }


                    })
                    .show()
        }
        else{


            set_language(language)
        }

    }
}



