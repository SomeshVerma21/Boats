package com.infoware.boats.mainUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.infoware.boats.R
import com.infoware.boats.mainUI.fragments.BoatListFragment
import com.infoware.boats.mainUI.fragments.CollectionFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
    }

    private fun setupUI()
    {
        supportFragmentManager.beginTransaction()
            .add(R.id.idMainScreenFragmentContainer,BoatListFragment())
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.idMyCollection->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.idMainScreenFragmentContainer,CollectionFragment.newInstance())
                    .setReorderingAllowed(true)
                    .addToBackStack("collection")
                    .commit()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_action_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        super.onBackPressed()
//        if (supportFragmentManager.backStackEntryCount ==0)
//            finish()
    }
}