package Model;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.Set;

/**
 * Created by David on 17/05/2017.
 */

public class BluetoothControl extends AppCompatActivity{
    private BluetoothAdapter blueAdapter;
    private Set<BluetoothDevice> devices;

    // Constructor.
    public BluetoothControl(){
        blueAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    // Enable Bluetooth device.
    // User must allow it.
    public void turnOn(){
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(intent,1);
    }

    // Stop Bluetooth device.
    public void turnOff(){
        blueAdapter.disable();
    }

    // Return bluetooth adapter name and address.
    public String getID(){
        return blueAdapter.getName()+":"+blueAdapter.getAddress(); // Warning: Address can be seen.
    }

     public void startDiscovery(){
         blueAdapter.cancelDiscovery(); //Avoid problems
         blueAdapter.startDiscovery();
     }

     // Devices Bounnded.
     public void getBoundedDevices(){
         devices = blueAdapter.getBondedDevices();
     }


}
