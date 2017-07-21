package android.example.com.squawker.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by Quang Huy on 7/22/2017.
 */

public class SquawkFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "SquawkFirebaseMessaging";
    private static final int NEW_MESSAGE_NOTIFICATION_ID = 12345;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived() called with: remoteMessage = [" + remoteMessage + "]");
        super.onMessageReceived(remoteMessage);
        Map<String, String> data = remoteMessage.getData();
        String test = data.get("test");
        String author = data.get("author");
        String authorKey = data.get("authorKey");
        String message = data.get("message");
        String date = data.get("date");

        //Todo: make notification and implement content provider to put this message to database
        // Show notification
        NotificationCompat.Builder builder = new android.support.v7.app.NotificationCompat.Builder(this)
                .setContentTitle("You have new message!")
                .setContentText(message.substring(0, 29));

        if (Build.VERSION.SDK_INT >= 16) {
            builder.setPriority(Notification.PRIORITY_HIGH);
        }

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NEW_MESSAGE_NOTIFICATION_ID, builder.build());
    }
}
