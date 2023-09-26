package com.example.mad_practical_8_20012011082

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun showTimerDialog(){
        val cldr: Calendar = Calendar.getInstance()
        val hour: Int = cldr.get(Calendar.HOUR_OF_DAY)
        val minutes: Int = cldr.get(Calendar.MINUTE)
        val picker = TimePickerDialog(this,{tp,sHour,sMinute -> sendDialogDataToActivity(sHour,sMinute)},hour,minutes,false)

    }
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun setAlarm(militime:Long, action:String){
        val intentalarm = Intent(applicationContext,AlramBroadcastReciver::class.java)
        intentalarm.putExtra(AlramBroadcastReciver.ALARMKEY,action)

        val pendingintent = PendingIntent.getBroadcast(applicationContext,2345,intentalarm,
            PendingIntent.FLAG_CANCEL_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val manager = getSystemService(ALARM_SERVICE) as AlarmManager

        if(action == AlramBroadcastReciver.ALARM_START){
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingintent)
        }
    }
}