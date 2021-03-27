package com.example.carepal;

import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;

import android.provider.Settings;

import java.util.Timer;
import java.util.TimerTask;

public class Alarm extends BroadcastReceiver
{
    static final String CHANNEL_ID = "CHANNEL_SAMPLE";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.start();
        // Get id & message
        int notificationId = intent.getIntExtra("notificationId", 0);
        String message = intent.getStringExtra("message");

        // Call Monitoring when notification is tapped.
        Intent mainIntent = new Intent(context, main_monitor.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent, 0);

        // NotificationManager
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // For API 26 and above
            CharSequence channelName = "My Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            notificationManager.createNotificationChannel(channel);
        }

        // Prepare Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("REMINDER")
                .setContentText(message)
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);

        // Notify
        notificationManager.notify(notificationId, builder.build());

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                mediaPlayer.stop();
            }
        },10000);
    }
}
