package com.example.tabslayout

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager.widget.ViewPager
import com.example.tabslayout.databinding.ActivityMainBinding
import com.example.tabslayout.databinding.FragmentHomeBinding
import com.example.tabslayout.databinding.FragmentQuizBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), QuizFragment.FragmentInteractionListener,  HomeFragment.FragmentInteractionListener {
    private lateinit var binding: ActivityMainBinding
    companion object {
        @StringRes
        private  val TAB_TITLES = intArrayOf(
            R.string.tabHome,
            R.string.tabQuiz
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

    // Handle the login button click from the fragment
    override fun onLoginButtonClicked(username: String, password: String) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(SecondActivity.EXTRA_NAME, username)
            putExtra(SecondActivity.EXTRA_PASSWORD, password)
        }
        startActivity(intent)
    }



}





//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_options, menu)
//        return true
//    }

//    private lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        with(binding){
//            viewPager.adapter = TabAdapter(supportFragmentManager)
//            // Hubungkan ViewPager dengan TabLayout
//            tabLayout.setupWithViewPager(viewPager)
//        }
//    }

