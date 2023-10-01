package tn.esprit.gamer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamer.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding :ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)

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
        val email = binding.mailL.text.toString()
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
            binding.mailLogin.helperText = null
            return true
        }else{
            binding.mailLogin.helperText = "Must not be empty !"
            binding.mailLogin.setPlaceholderText("@esprit.tn")
            return false
            }
        }


         private fun passwordValidation(pwd :String) :Boolean {
             if (pwd.length < 8){
                 binding.passwordLogin.helperText = " Must not be empty !"
                 return false
             }

             if (pwd.filter { it.isDigit() }.firstOrNull() == null)
                 return false
             if (pwd.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null)
                 return false
             if (pwd.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null)
                 return false

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