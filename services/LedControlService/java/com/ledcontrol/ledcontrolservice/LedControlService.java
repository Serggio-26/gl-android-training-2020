package com.ledcontrol.ledcontrolservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import vendor.gls.hardware.LedControl.V1_0.ILedControlHW;
import vendor.gls.hardware.LedControl.V1_0.leds_t;
import vendor.gls.hardware.LedControl.V1_0.ledState_t;
import vendor.gls.hardware.LedControl.V1_0.result_t;

public class LedControlService extends Service {
    ILedControlHW mLedControlHW;

    public LedControlService() {
    }

    final static String TAG = "LedControlService";

    private ILedControlInterface.Stub mService = new ILedControlInterface.Stub() {
        @Override
        public void ledControl(int ledId, boolean stateOn) throws RemoteException {
            try {
                byte iLedId;
                byte iState;
                byte iResult;

                switch (ledId) {
                    case 1:
                        iLedId = leds_t.LED1;
                        break;
                    case 2:
                        iLedId = leds_t.LED2;
                        break;
                    case 3:
                        iLedId = leds_t.LED3;
                        break;
                    case 4:
                        iLedId = leds_t.LED4;
                        break;
                    default:
			return;
                }

                if(stateOn) {
                    iState = ledState_t.ON;
                } else {
                    iState = ledState_t.OFF;
                }

                iResult = mLedControlHW.iLedControlHW(iLedId, iState);
                if (iResult == result_t.RES_OK) {
                    Log.d(TAG, "call iledControlHW. Led ID - " + leds_t.toString(iLedId) + ". State - " + ledState_t.toString(iState));
                } else {
                    Log.d(TAG, "call iledControlHW returned ERROR");
                }

            } catch (Exception e) {
                Log.e(TAG, "Call ILedControlHW failed: " + e.getMessage());
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Bind Led Control Service.");
        return mService;
    }

    @Override
    public void onCreate() {
        try {
            mLedControlHW = ILedControlHW.getService(true);
        } catch (Exception e) {
            Log.e(TAG, "Getting LedControlHW srvice failed: " + e.getMessage());
        }
    }
}
