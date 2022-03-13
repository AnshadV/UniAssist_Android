package com.android.uniassist.auth

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.android.uniassist.R
import com.android.uniassist.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        binding.toLogin.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.editTextTextEmailAddress.text.toString().trim { it <=' '}) -> {
                    Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.editTextTextPassword.text.toString().trim { it <=' '}) -> {
                    Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val email: String = binding.editTextTextEmailAddress.text.toString().trim{it <=' '}
                    val password: String = binding.editTextTextPassword.text.toString().trim{it <=' '}
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) {task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser

                                user?.sendEmailVerification()
                                    ?.addOnCompleteListener(this) {task ->
                                        if(task.isSuccessful) {
                                            Toast.makeText(this, "Registered successfully. Please check your email for verification", Toast.LENGTH_SHORT).show()
                                            val intent = Intent(this, LoginActivity::class.java)
                                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                            if (user != null) {
                                                intent.putExtra("user_id", user.uid)
                                            }
                                            intent.putExtra("email_id", email)
                                            startActivity(intent)
                                            finish()
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
}