package com.ledcontrol.ledcontrolservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class LedControlService extends Service {
    public LedControlService() {
    }

    final static String TAG = "LedControlService";

    private ILedControlInterface.Stub mService = new ILedControlInterface.Stub() {
        @Override
        public void ledControl(int ledId, boolean stateOn) throws RemoteException {
            Log.d(TAG, "call ledControl. Led ID - " + ledId + ". State ON - " + stateOn);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Bind Led Control Service.");
        return mService;
    }
}
