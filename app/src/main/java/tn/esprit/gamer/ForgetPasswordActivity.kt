package tn.esprit.gamer

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import tn.esprit.gamer.databinding.ActivityForgetPasswordBinding

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityForgetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater,null,false)
        setContentView(binding.root)

        binding.forgetPassMailNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                var forgetText = s?.toString()
                if (forgetText != null && isItInt(forgetText) ) {
                    phoneValidate(forgetText)
                }else if(forgetText != null) {
                    emailValidate(forgetText)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var forgetText = s?.toString()
                if (forgetText != null && isItInt(forgetText) ) {
                    phoneValidate(forgetText)
                }else if(forgetText != null) {
                    emailValidate(forgetText)
                }
            }


                override fun afterTextChanged(s: Editable?) {
                var forgetText = s?.toString()
                if (forgetText != null && isItInt(forgetText) ) {
                    phoneValidate(forgetText)
                }else if(forgetText != null) {
                    emailValidate(forgetText)
                }
                }
        })


    }

    fun isItInt(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
    private fun emailValidate(email: String): Boolean {
        val emailRegex = "^[a-zA-Z0-9._%+-]+@esprit\\.tn\$".toRegex()
        if(email.matches(emailRegex) && email.isNotEmpty()) {
            binding.forgetPassMail.helperText = ""
            return true
        }else if(email.isEmpty()){
            binding.forgetPassMail.helperText = "Must not be empty !"
            return false

        }
        else{
            binding.forgetPassMail.helperText = "Not the right format !"
            return false
        }
    }
        private fun phoneValidate(phone: String): Boolean {

            if(phone.length >=8) {
                binding.forgetPassMail.helperText = ""
                return true
            }else{
                binding.forgetPassMail.helperText = "Minimum 8 numbers !"
                return false
            }
        }



}