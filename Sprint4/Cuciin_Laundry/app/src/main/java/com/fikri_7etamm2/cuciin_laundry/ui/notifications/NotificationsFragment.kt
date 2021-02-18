package com.fikri_7etamm2.cuciin_laundry.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fikri_7etamm2.cuciin_laundry.LoginActivity
import com.fikri_7etamm2.cuciin_laundry.MapsActivity
import com.fikri_7etamm2.cuciin_laundry.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var intent: Intent
    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notifications, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()

        keluar_btn.setOnClickListener{
            auth.signOut()
            Intent(this.context, LoginActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}