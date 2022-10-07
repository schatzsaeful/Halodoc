package com.example.halodoc.module.login

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.example.halodoc.R
import com.example.halodoc.base.BaseActivity
import com.example.halodoc.databinding.ActivityLoginBinding
import com.example.halodoc.module.home.HomeActivity
import com.example.halodoc.module.register.RegisterActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    override fun getLayoutId(): Int  = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLayout()
    }

    private fun setupLayout() {
        with(getViewBinder()) {
            setupActivatedButton()

            setupInputText(emailTil.editText)
            setupInputText(passwordTil.editText)

            registerTv.setOnClickListener {
                val intent = Intent(applicationContext, RegisterActivity::class.java)
                startActivity(intent)
            }

            forgotPasswordTv.setOnClickListener {

            }

            loginBtn.setOnClickListener {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setupInputText(et: EditText?) {
        et?.doAfterTextChanged {
            setupActivatedButton()
        }
    }

    private fun setupActivatedButton() {
        with(getViewBinder()) {
            val email = emailTil.editText?.text.toString()
            val password = passwordTil.editText?.text.toString()

            loginBtn.isEnabled = (email.isNotEmpty() && password.isNotEmpty())

        }
    }
}