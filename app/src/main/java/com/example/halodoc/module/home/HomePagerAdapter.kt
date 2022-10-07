package com.example.halodoc.module.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = arrayListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun setFragments(vararg fragments: Fragment) {
        this.fragments.clear()
        this.fragments.addAll(fragments)
    }
}