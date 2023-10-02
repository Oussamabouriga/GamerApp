package tn.esprit.gamer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamer.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding :ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)

        // val  email = binding.mailL.text.toString()
        // val  password = binding.passL.text.toString()

        binding.mailL.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val email = s?.toString()
                if (email != null) {
                    emailValidate(email)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val email = s?.toString()
                if (email != null) {
                    emailValidate(email)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                val email = s?.toString()
                if (email != null) {
                    emailValidate(email)
                }
            }
        })


        binding.passL.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val password = s?.toString()
                if (password != null) {
                    passwordValidation(password)                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val password = s?.toString()
                if (password != null) {
                    passwordValidation(password)                }
            }

            override fun afterTextChanged(s: Editable?) {
                val password = s?.toString()
                if (password != null) {
                    passwordValidation(password)
                }
            }
        })



        binding.loginbtn.setOnClickListener {
            login()
        }

        binding.facebookBtn.setOnClickListener {
            loginWithFacebook()
        }
        binding.googleBtn.setOnClickListener {
            loginWithGoogle()
        }
        binding.forgetPass.setOnClickListener {
            navigateToForgetPwd()
        }
        binding.registerNow.setOnClickListener {
            val  intent = Intent(this ,SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    private fun login() {

        val  email = binding.mailL.text.toString()
        val  password = binding.passL.text.toString()
        if (emailValidate(email) && passwordValidation(password)){
            val  intent = Intent(this ,MainActivity::class.java)
            startActivity(intent)

        }else{
            Snackbar.make(binding.root,"you have some errors in your inputs!",Snackbar.LENGTH_LONG).show()
        }
    }



    private fun emailValidate(email: String): Boolean {
        val emailRegex = "^[a-zA-Z0-9._%+-]+@esprit\\.tn\$".toRegex()
        if(email.matches(emailRegex) && email.isNotEmpty()) {
            binding.mailLogin.helperText = ""
            return true
        }else if(email.isEmpty()){
            binding.mailLogin.helperText = "Must not be empty !"
            binding.mailLogin.setPlaceholderText("@esprit.tn")
            return false

        }
        else{
            binding.mailLogin.helperText = "Not the right format !"
            return false
            }
        }


         private fun passwordValidation(pwd :String) :Boolean {
             if (pwd.length < 8){
                 binding.passwordLogin.helperText = "Minimum 8 characters !"
                 return false
             }
             if(pwd.isEmpty()){
                 binding.passwordLogin.helperText = " Must not be empty !"
             }
             if(pwd.isNotEmpty()){
                 binding.passwordLogin.helperText = ""

             }
             if (pwd.filter { it.isDigit() }.firstOrNull() == null) {
                 binding.passwordLogin.helperText = " Must contain Numbers"
                 return false
             }
             if (pwd.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null){
                 binding.passwordLogin.helperText = " Must contain UpperCase"
                 return false
             }
             if (pwd.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) {
                 binding.passwordLogin.helperText = " Must contain LowerCase"
                 return false
             }
             return true
        }

        private fun loginWithFacebook(){
            Snackbar.make(binding.root,"Coming soon :)",Snackbar.LENGTH_LONG).show()
        }
        private fun loginWithGoogle(){
            Snackbar.make(binding.root,"Coming soon :)",Snackbar.LENGTH_LONG).show()
        }

        private fun navigateToForgetPwd(){
            val intent = Intent(this , ForgetPasswordActivity::class.java)
            startActivity(intent)
        }
}