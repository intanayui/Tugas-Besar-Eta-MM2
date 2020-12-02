package com.fikri_7etamm2.cuciin_laundry

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_daftar.*
import kotlinx.android.synthetic.main.activity_login.*

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        daftar_btn.setOnClickListener {
            if (input_username.text.trim().isNotEmpty() || input_email.text.trim()
                    .isNotEmpty() || input_password.text.trim()
                    .isNotEmpty() || confirm_password.text.trim().isNotEmpty()
            ) {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
            }



        }
    }
}