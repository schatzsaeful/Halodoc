package com.example.halodoc.module.register

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import com.example.halodoc.R
import com.example.halodoc.base.BaseActivity
import com.example.halodoc.databinding.ActivityRegisterBinding
import com.example.halodoc.module.home.HomeActivity
import com.example.halodoc.module.login.LoginActivity

class RegisterActivity : BaseActivity<ActivityRegisterBinding>() {

    override fun getLayoutId(): Int  = R.layout.activity_register

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLayout()
    }

    private fun setupLayout() {
        with(getViewBinder()) {
            setupActivatedButton()

            setupInputText(firstNameTill.editText)
            setupInputText(lastNameTil.editText)
            setupInputText(idCardTil.editText)
            setupInputText(numberPhoneTil.editText)
            setupInputText(emailTil.editText)
            setupInputText(passwordTil.editText)
            setupInputText(confirmPasswordTil.editText)

            loginNowTv.setOnClickListener {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
            }

            registerBtn.setOnClickListener {
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
            val firstName = firstNameTill.editText?.text.toString()
            val lastName = lastNameTil.editText?.text.toString()
            val idCard = idCardTil.editText?.text.toString()
            val email = emailTil.editText?.text.toString()
            val numberPhone = numberPhoneTil.editText?.text.toString()
            val password = passwordTil.editText?.text.toString()
            val confirmPassword = confirmPasswordTil.editText?.text.toString()

            registerBtn.isEnabled = (firstName.isNotEmpty() && lastName.isNotEmpty() && idCard.isNotEmpty()
                    && email.isNotEmpty() && numberPhone.isNotEmpty() && password.isNotEmpty() &&
                    confirmPassword.isNotEmpty())

        }
    }
}