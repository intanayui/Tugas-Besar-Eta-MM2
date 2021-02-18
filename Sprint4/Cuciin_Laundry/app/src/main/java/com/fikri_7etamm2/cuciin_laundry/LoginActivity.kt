package com.fikri_7etamm2.cuciin_laundry

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.fikri_7etamm2.cuciin_laundry.Broadcast.BroadcastReceiverActivity
import com.fikri_7etamm2.cuciin_laundry.Broadcast.SmsReceiverActivity
import com.fikri_7etamm2.cuciin_laundry.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener(this)
        binding.daftarBtn.setOnClickListener(this)

        auth = Firebase.auth

    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.login_btn -> {
                login(binding.usernameEt.text.toString(),
                    binding.passEt.text.toString())
            }
            R.id.daftar_btn -> {
                val intent = Intent(this@LoginActivity, DaftarActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun login(email: String, password: String) {
        if (!validateForm()) {
            return
        }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    finish()
                    val intent = Intent(this@LoginActivity,
                        MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun validateForm(): Boolean {
        var valid = true
        val email = binding.usernameEt.text.toString()
        if (TextUtils.isEmpty(email)) {
            binding.usernameEt.error = "Required."
            valid = false
        } else {
            binding.usernameEt.error = null
        }
        val password = binding.passEt.text.toString()
        if (TextUtils.isEmpty(password)) {
            binding.passEt.error = "Required."
            valid = false
        } else {
            binding.passEt.error = null
        }
        return valid
    }
}

