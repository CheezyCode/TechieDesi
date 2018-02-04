package com.cheezycode.techiedesi;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        showNotification(remoteMessage.getNotification().getBody());
    }

    public void showNotification(String message) {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("Techie Desi")
                .setContentText(message)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}
