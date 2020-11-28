package com.example.alarm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAlarm(19 ,24, "text1", "text2");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setAlarm(int h, int m, String msg, String tag) {

        Intent intent = new Intent(this, MyAlarmReceiver.class);
        boolean isWorking = (PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_NO_CREATE) != null);//just changed the flag
        if(isWorking == true){
            Log.e("TAG", "setAlarm:===============================" );
        }
        else {
            alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Toast.makeText(this, "OnReceive alarm test 1", Toast.LENGTH_SHORT).show();

            intent.putExtra("msg", msg);
            intent.putExtra("tag", tag);
            alarmIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, h);
            calendar.set(Calendar.MINUTE, m);
            calendar.set(Calendar.SECOND, 0);

            alarmMgr.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
            Toast.makeText(this, "OnReceive alarm test 2", Toast.LENGTH_SHORT).show();
        }
    }


}