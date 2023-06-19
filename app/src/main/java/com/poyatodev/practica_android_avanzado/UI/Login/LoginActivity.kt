package com.poyatodev.practica_android_avanzado.UI.Login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.poyatodev.practica_android_avanzado.MainActivity
import com.poyatodev.practica_android_avanzado.R
import com.poyatodev.practica_android_avanzado.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel : LoginViewModel by viewModels()
    private val TAG_EMAIL = "MyEmail"
    private val TAG_PASSWROD = "MyPassword"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadDataFromPreferences()

        viewModel.login.observe(this){
            Log.d("LOGIN", it.toString())
            if(binding.cbSaveData.isChecked){
                saveDataInPreferences(binding.etEmail.text.toString(),binding.etPassword.text.toString())
                launchMainActivity()
            }else{
                //TODO start activity sending the token or somehing, stat the activity sengind the token
                launchMainActivity()
            }
        }

        binding.btLogin.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if(!email.isEmpty() && !password.isEmpty()){
                viewModel.performLogin(email,password)
            }else{
                binding.etEmail.setError("This field is empty or the email is invalid")
                //TODO set more validations in case email or password are incorreect
            }
        }
    }

    private fun launchMainActivity(){
        MainActivity.launch(this)
    }

    //Save in saveInPreferences
    private fun saveDataInPreferences(mail: String, pass: String) {
        getPreferences(Context.MODE_PRIVATE).edit().apply {
            putString(TAG_EMAIL, mail).apply()
            putString(TAG_PASSWROD, pass).apply()

        }
    }
    //Retrieve
    private fun loadDataFromPreferences() {
        getPreferences(Context.MODE_PRIVATE).apply {
            binding.etEmail.setText(getString(TAG_EMAIL, ""))
            binding.etPassword.setText(getString(TAG_PASSWROD, ""))
            if (binding.etEmail.text.toString() != "" && binding.etPassword.text.toString() != "") {
                binding.cbSaveData.isChecked = true
            }
        }
    }
}