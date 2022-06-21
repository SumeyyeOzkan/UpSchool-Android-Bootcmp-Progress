package com.sumeyye.april_26_navigation_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private  lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar:Toolbar =findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout=findViewById(R.id.drawer_layout)
        val navigationView:NavigationView=findViewById(R.id.nav_view)
        navController=findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration= AppBarConfiguration(setOf(R.id.list,R.id.favorites,R.id.settings),drawerLayout)

        setupActionBarWithNavController(navController,appBarConfiguration)
        navigationView.setupWithNavController(navController)
        //toolbar.setupWithNavController(navController) // bunu koyarsak başka bir sayfaya girdiğimizde yukarıda geri tuşu çıkar menü tuşu gözükmüyor


      // val navigationView:NavigationView=findViewById(R.id.navigation_view)
        navigationView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    //settings sayfasına gitmemizi sağlar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                if(navController.currentDestination?.id != R.id.settings) { //iki defa settings'e tıklandığında geri tuşu da 2 defa da geriye gider. Bir defa da geriye gitmesi için if içindekiler yazılır
                    navController.navigate(R.id.settings)
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}