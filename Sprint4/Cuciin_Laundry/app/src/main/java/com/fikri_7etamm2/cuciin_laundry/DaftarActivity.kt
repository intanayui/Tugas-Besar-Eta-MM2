package com.fikri_7etamm2.cuciin_laundry


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_daftar.*

class DaftarActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        auth = FirebaseAuth.getInstance()
        daftar_btn.setOnClickListener {
            val name = input_username.text.toString().trim()
            val email = input_email.text.toString().trim()
            val password = input_password.text.toString().trim()

            if (email.isEmpty()){
                input_email.error = "Email harus diisi"
                input_email.requestFocus()
                return@setOnClickListener

            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                input_email.error = "Email tidak valid"
                input_email.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 6){
                input_password.error = "Password harus lebih dari 6 karakter"
                input_password.requestFocus()
                return@setOnClickListener
            }

            registerUser(email, password)
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Intent(this@DaftarActivity, MainActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }else{
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if(auth.currentUser != null){
            Intent(this@DaftarActivity, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}