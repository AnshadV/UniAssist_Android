package com.android.uniassist.auth

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.android.uniassist.MainActivity
import com.android.uniassist.OnboardingActivity
import com.android.uniassist.R
import com.android.uniassist.data.SharedPref
import com.android.uniassist.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toRegister.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
        auth = Firebase.auth

        //check if already logged in

        if(isFirstLaunch()) {
            startActivity(Intent(this, OnboardingActivity::class.java))
            finish()
        }




        if(auth.currentUser!=null) {
            val user = auth.currentUser
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            if(user!=null) {
                intent.putExtra("user_id", user.uid)
                intent.putExtra("email_id", user.email)
            }
            startActivity(intent)
            finish()

        }

        binding.Loginbutton.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.editTextTextEmailAddress2.text.toString().trim { it <=' '}) -> {
                    Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.editTextTextPassword2.text.toString().trim { it <=' '}) -> {
                    Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val email: String = binding.editTextTextEmailAddress2.text.toString().trim { it <=' '}
                    val password: String = binding.editTextTextPassword2.text.toString().trim { it <=' '}

                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) {task ->
                            if(task.isSuccessful) {
                                val user = auth.currentUser
                                if (user != null) {
                                    if(user.isEmailVerified) {
                                        val intent = Intent(this, MainActivity::class.java)
                                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        intent.putExtra("user_id", user.uid)
                                        intent.putExtra("email_id", email)
                                        startActivity(intent)
                                        finish()
                                    }
                                    else{
                                        Toast.makeText(this, "Please verify your email address", Toast.LENGTH_SHORT).show()
                                    }
                                }

                            }
                            else {
                                Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }
    }
    private fun isFirstLaunch() : Boolean {
        return SharedPref.getInstance(applicationContext).isFirstLaunch()
    }
}