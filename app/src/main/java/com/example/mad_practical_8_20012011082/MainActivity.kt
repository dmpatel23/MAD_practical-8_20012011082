package com.example.mad_practical_8_20012011082

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setalarm(militime:Long,action:String){
        val intentalarm = Intent(applicationContext,AlramBroadcastReciver::class.java)
        intentalarm.putExtra(AlramBroadcastReciver.ALARMKEY,action)

        val pendingintent = PendingIntent.getBroadcast(App,2345,intentalarm,PendingIntent)
        val manager = getSystemService(ALARM_SERVICE) as AlarmManager

        if(action == AlramBroadcastReciver.ALARM_START){
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingintent)
        }
    }
}