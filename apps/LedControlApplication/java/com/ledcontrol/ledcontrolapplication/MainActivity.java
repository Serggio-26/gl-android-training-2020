package com.ledcontrol.ledcontrolapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.ledcontrol.ledcontrolservice.ILedControlInterface;


public class MainActivity extends AppCompatActivity {

    final static String TAG = "LedControlApp";
    private ILedControlInterface mService;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (null != service) {
                mService = ILedControlInterface.Stub.asInterface(service);
            } else {
                Log.e(TAG, "Null Pointer Exception!");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton led1Button = (ToggleButton)findViewById(R.id.led1Button);
        led1Button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    mService.ledControl(1, isChecked);
                    if (isChecked) {
                        // The toggle is enabled
                        Log.d(TAG, "LED 1 Button is On");
                    } else {
                        // The toggle is disabled
                        Log.d(TAG, "LED 1 Button is Off");
                    }
                } catch (
                    RemoteException e) {
                    Log.e(TAG, "Remote Exception! " + e.getMessage());
                } catch (NullPointerException e) {
                    Log.e(TAG, "Null Pointer Exception! " + e.getMessage());
                }
            }
        });

        final ToggleButton led2Button = (ToggleButton)findViewById(R.id.led2Button);
        led2Button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    mService.ledControl(2, isChecked);
                    if (isChecked) {
                        // The toggle is enabled
                        Log.d(TAG, "LED 2 Button is On");
                    } else {
                        // The toggle is disabled
                        Log.d(TAG, "LED 2 Button is Off");
                    }
                } catch (
                        RemoteException e) {
                    Log.e(TAG, "Remote Exception! " + e.getMessage());
                } catch (NullPointerException e) {
                    Log.e(TAG, "Null Pointer Exception! " + e.getMessage());
                }
            }
        });

        final ToggleButton led3Button = (ToggleButton)findViewById(R.id.led3Button);
        led3Button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    mService.ledControl(3, isChecked);
                    if (isChecked) {
                        // The toggle is enabled
                        Log.d(TAG, "LED 3 Button is On");
                    } else {
                        // The toggle is disabled
                        Log.d(TAG, "LED 3 Button is Off");
                    }
                } catch (
                        RemoteException e) {
                    Log.e(TAG, "Remote Exception! " + e.getMessage());
                } catch (NullPointerException e) {
                    Log.e(TAG, "Null Pointer Exception! " + e.getMessage());
                }
            }
        });

        final ToggleButton led4Button = (ToggleButton)findViewById(R.id.led4Button);
        led4Button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    mService.ledControl(4, isChecked);
                    if (isChecked) {
                        // The toggle is enabled
                        Log.d(TAG, "LED 4 Button is On");
                    } else {
                        // The toggle is disabled
                        Log.d(TAG, "LED 4 Button is Off");
                    }
                } catch (
                        RemoteException e) {
                    Log.e(TAG, "Remote Exception! " + e.getMessage());
                } catch (NullPointerException e) {
                    Log.e(TAG, "Null Pointer Exception! " + e.getMessage());
                }
            }
        });

        Intent intent = new Intent();
        intent.setClassName("com.ledcontrol.ledcontrolservice", "com.ledcontrol.ledcontrolservice.LedControlService");
        try {
            bindService(intent, mConnection, BIND_AUTO_CREATE);
            Log.d(TAG, "Bind to service success!");
        } catch (SecurityException e) {
            Log.e(TAG, "Bind to service failed: " + e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        Log.d(TAG, "Unbind from service success!");
        super.onDestroy();
    }
}
