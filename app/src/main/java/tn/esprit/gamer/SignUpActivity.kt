package tn.esprit.gamer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamer.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {


    private lateinit  var binding : ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)
        binding.regBtn.setOnClickListener {
            register()
        }
        binding.pP.setOnClickListener {
            Snackbar.make(binding.root,"coming soon !", Snackbar.LENGTH_LONG).show()
        }


    }

    fun register(){
        val email = binding.mailR.text.toString()
        val fullName = binding.fullnameText.text.toString()
        val pwd = binding.passwordR.text.toString()
        val confPwd = binding.conPasswordR.text.toString()
        if(fullNameValidation(fullName) && emailValidateRegister(email)
            && passwordValidationRegister(pwd) && confPasswordValidationRegister(confPwd)){
            val  intent = Intent(this ,LoginActivity::class.java)
            startActivity(intent)

        }else{
            Snackbar.make(binding.root,"you have some errors in your inputs!", Snackbar.LENGTH_LONG).show()
        }


    }

    private fun fullNameValidation(name : String): Boolean {
        if (name.length < 3 && name.isEmpty()) {
            return false
        }
        return true
    }


    private fun emailValidateRegister(email: String): Boolean {
        val emailRegex = "^[a-zA-Z0-9._%+-]+@esprit\\.tn\$".toRegex()
        if(email.matches(emailRegex) && email.isNotEmpty()) {
            binding.mailReg.helperText = null
            return true
        }else{
            binding.mailReg.helperText = "Must not be empty !"
            binding.mailReg.setPlaceholderText("@esprit.tn")
            return false
        }
    }


    private fun passwordValidationRegister(pwd :String) :Boolean {
        if (pwd.length < 8){
            binding.passwordReg.helperText = " Must not be empty !"
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

        private fun confPasswordValidationRegister(pwd :String) :Boolean {
        if (pwd.length < 8){
            binding.conPasswordReg.helperText = " Must not be empty !"
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



}