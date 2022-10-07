package com.example.halodoc.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<out T : ViewBinding> : AppCompatActivity() {

    private lateinit var viewBinder: T

    protected fun getViewBinder() = viewBinder

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performViewBinding()
    }

    private fun performViewBinding() {
        viewBinder = DataBindingUtil.setContentView(this, getLayoutId())

    }
}