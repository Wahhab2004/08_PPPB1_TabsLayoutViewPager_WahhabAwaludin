package com.example.tabslayout

import QuizFragment
import HomeFragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter (activity: AppCompatActivity) : FragmentStateAdapter (activity){
    override fun getItemCount(): Int {
       return  2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = QuizFragment ()
        }

        return fragment as Fragment
    }

}