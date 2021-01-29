package com.fikri_7etamm2.cuciin_laundry.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.fikri_7etamm2.cuciin_laundry.R
import com.fikri_7etamm2.cuciin_laundry.ui.notifications.data.SettingModel
import com.fikri_7etamm2.cuciin_laundry.ui.notifications.preferences.SettingPreference
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {


    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var settingModel: SettingModel
    private lateinit var mSettingPreference: SettingPreference

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        return root
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.btn_save -> {
                openSetting()
            }
        }
    }

    private fun showExistingPreference() {
        settingModel = mSettingPreference.getSetting()
        populateView(settingModel)
    }
    private fun populateView(settingModel: SettingModel) {
        if (settingModel.isDarkTheme) {
            setDefaultNightMode(MODE_NIGHT_YES)
            applyDayNight()
        }
        else {
            setDefaultNightMode(MODE_NIGHT_NO)
            applyDayNight()
        }
        this@NotificationsFragment.settingModel = settingModel
    }

    private fun applyDayNight() {
        TODO("Not yet implemented")
    }

    fun openSetting(){
        val intent = Intent(activity, SettingPreferenceActivity::class.java)
        startActivityForResult(intent, Companion.REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == SettingPreferenceActivity.RESULT_CODE) {
                showExistingPreference()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showExistingPreference()
    }

}