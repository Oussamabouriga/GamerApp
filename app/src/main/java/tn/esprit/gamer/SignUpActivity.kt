package tn.esprit.gamer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamer.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {


    private lateinit  var binding : ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)

        binding.fullnameText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val fullName = s?.toString()
                if (fullName != null) {
                    fullNameValidation(fullName)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val fullName = s?.toString()
                if (fullName != null) {
                    fullNameValidation(fullName)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                val fullName = s?.toString()
                if (fullName != null) {
                    fullNameValidation(fullName)
                }
            }
        })

        binding.mailR.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val email = s?.toString()
                if (email != null) {
                    emailValidateRegister(email)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val email = s?.toString()
                if (email != null) {
                    emailValidateRegister(email)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                val email = s?.toString()
                if (email != null) {
                    emailValidateRegister(email)
                }
            }
        })

         binding.passwordR.addTextChangedListener(object : TextWatcher {
             override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                 val password = s?.toString()
                 if (password != null) {
                     passwordValidationRegister(password)                }
             }

             override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                 val password = s?.toString()
                 if (password != null) {
                     passwordValidationRegister(password)                }
             }

             override fun afterTextChanged(s: Editable?) {
                 val password = s?.toString()
                 if (password != null) {
                     passwordValidationRegister(password)
                 }
             }
         })

        binding.conPasswordR.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val passwordc = s?.toString()
                if (passwordc != null) {
                    confPasswordValidationRegister(passwordc)                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val passwordc = s?.toString()
                if (passwordc != null) {
                    confPasswordValidationRegister(passwordc)                }
            }

            override fun afterTextChanged(s: Editable?) {
                val passwordc = s?.toString()
                if (passwordc != null) {
                    confPasswordValidationRegister(passwordc)
                }
            }
        })


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
        if (name.isEmpty()) {
            binding.mailReg.helperText = "Must not be empty !"
            return false
        }
        if(name.length < 3 ){
            binding.mailReg.helperText = "Minimum 3 characters !"
        }
        binding.mailReg.helperText = ""
        return true
    }


    private fun emailValidateRegister(email: String): Boolean {
        val emailRegex = "^[a-zA-Z0-9._%+-]+@esprit\\.tn\$".toRegex()
        if(email.matches(emailRegex) && email.isNotEmpty()) {
            binding.mailReg.helperText = ""
            return true
        }else if(email.isEmpty()){
            binding.mailReg.helperText = "Must not be empty !"
            binding.mailReg.setPlaceholderText("@esprit.tn")
            return false

        }
        else{
            binding.mailReg.helperText = "Not the right format !"
            return false
        }
    }


    private fun passwordValidationRegister(pwd :String) :Boolean {
            if (pwd.length < 8){
                binding.passwordReg.helperText = "Minimum 8 characters !"
                return false
            }
            if(pwd.isEmpty()){
                binding.passwordReg.helperText = " Must not be empty !"
            }
            if(pwd.isNotEmpty()){
                binding.passwordReg.helperText = ""

            }
            if (pwd.filter { it.isDigit() }.firstOrNull() == null) {
                binding.passwordReg.helperText = " Must contain Numbers"
                return false
            }
            if (pwd.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null){
                binding.passwordReg.helperText = " Must contain UpperCase"
                return false
            }
            if (pwd.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) {
                binding.passwordReg.helperText = " Must contain LowerCase"
                return false
            }
            return true
        }

        private fun confPasswordValidationRegister(pwd :String) :Boolean {
            if (pwd.length < 8){
                binding.conPasswordReg.helperText = "Minimum 8 characters !"
                return false
            }
            if(pwd.isEmpty()){
                binding.conPasswordReg.helperText = " Must not be empty !"
            }
            if(pwd.isNotEmpty()){
                binding.conPasswordReg.helperText = ""

            }
            if (pwd.filter { it.isDigit() }.firstOrNull() == null) {
                binding.conPasswordReg.helperText = " Must contain Numbers"
                return false
            }
            if (pwd.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null){
                binding.conPasswordReg.helperText = " Must contain UpperCase"
                return false
            }
            if (pwd.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) {
                binding.conPasswordReg.helperText = " Must contain LowerCase"
                return false
            }
            return true
        }



}