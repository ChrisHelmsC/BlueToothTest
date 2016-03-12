package com.example.chris.bluetoothtest;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Set;

public class MainActivity extends AppCompatActivity
{

    private BluetoothAdapter BA;
    

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BA = BluetoothAdapter.getDefaultAdapter();

        if(!BA.isEnabled())
        {
            turnOnAdapter();
        }

        Set<BluetoothDevice> pairedSet = BA.getBondedDevices();
        if(pairedSet.size() > 0)
        {
            for(BluetoothDevice device : pairedSet)
            {

            }
        }
    }

    private void turnOnAdapter()
    {
        Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(turnOn, 0);
    }
}
