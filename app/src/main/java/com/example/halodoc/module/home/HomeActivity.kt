package com.example.halodoc.module.home

import android.os.Bundle
import com.example.halodoc.R
import com.example.halodoc.base.BaseActivity
import com.example.halodoc.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private var pagerAdapter: HomePagerAdapter? = null

    override fun getLayoutId(): Int  = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLayout()
    }

    private fun setupLayout() {
        with(getViewBinder()) {

            setupAdapter()

            onBoardingPager.adapter = pagerAdapter
        }
    }

    private fun setupAdapter() {
        pagerAdapter = HomePagerAdapter(
            supportFragmentManager, lifecycle
        ).apply {
            setFragments(
                HomeOnBoardingFragment(),
                HomeOnBoardingFragment(),
                HomeOnBoardingFragment()
            )
        }
    }
}