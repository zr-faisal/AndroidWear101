package com.bjit.androidwear101;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MobileActivity extends Activity {

    private static final int REQUEST_CALL = 1;
    private static final String MOBILE_NUMBER = "+8801670886364";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mobile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Button action
//    public void sendNotification(View v) {
//        Log.d(this.getClass().getSimpleName(), "Send Notification from device...");
//        callMe();
//    }

    private void openAUrl() {
        Intent webIntent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("http://www.yahoo.com");
        webIntent.setData(uri);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, webIntent, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
        notificationBuilder.setContentTitle("YAHOO!!");
        notificationBuilder.setContentText("Go to YAHOO");
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.addAction(R.drawable.ic_launcher, "Test Notification", pendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, notificationBuilder.build());
    }

    private void sendNotification() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + MOBILE_NUMBER);
        callIntent.setData(uri);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQUEST_CALL, callIntent, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
        notificationBuilder.setContentTitle("Urgent !!");
        notificationBuilder.setContentText("Please call me back at " + MOBILE_NUMBER);
        notificationBuilder.addAction(R.drawable.ic_launcher, "Callback", pendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(REQUEST_CALL, notificationBuilder.build());
    }
}
