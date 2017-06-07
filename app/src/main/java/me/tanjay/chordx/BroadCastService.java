package me.tanjay.chordx;

/*
 *
 * Created by tanushajayasinghe on 3/15/17.
 *
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/*
 * Created by tanushajayasinghe on 11/29/16.
 */

public class BroadCastService extends WakefulBroadcastReceiver {

    private final String TAG = "FirebaseDataReceiver";
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "I'm in!!!");
        Log.d(TAG, intent.getData().toString());
        Log.d(TAG, intent.getStringExtra("name"));
        Bundle dataBundle = intent.getBundleExtra("data");
        Log.d(TAG, dataBundle.toString());

    }
}