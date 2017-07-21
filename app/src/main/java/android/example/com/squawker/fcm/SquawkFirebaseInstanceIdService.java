package android.example.com.squawker.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Quang Huy on 7/21/2017.
 */

public class SquawkFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG = "SquawkFirebaseInstanceI";

    public SquawkFirebaseInstanceIdService() {
        super();
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d(TAG, "onTokenRefresh: " + FirebaseInstanceId.getInstance().getToken());
    }
}
