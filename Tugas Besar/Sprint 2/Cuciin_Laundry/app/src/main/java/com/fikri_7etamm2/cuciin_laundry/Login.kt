package com.fikri_7etamm2.cuciin_laundry

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.setOnClickListener{

            if(username_et.text.trim().isNotEmpty() || pass_et.text.trim().isNotEmpty()){
                //
                Toast.makeText(this,"Success", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
            }

        }

        daftar.setOnClickListener {
            val intent = Intent(this, DaftarActivity::class.java);
            startActivity(intent)
        }
    }
}