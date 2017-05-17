package laurid.bluetoothcontroller.BluetoothControl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BluetoothControl extends AppCompatActivity{
    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter blueAdapter;
    private Set<BluetoothDevice> devices;

    // Constructor.
    public BluetoothControl(){
        blueAdapter = BluetoothAdapter.getDefaultAdapter();
        if(blueAdapter == null){
            Toast toast = Toast.makeText(this,"Fallo",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }

    // Enable Bluetooth device.
    // User must allow it.
    public void turnOn(){
        if(!blueAdapter.isEnabled()) {
            blueAdapter.enable();       //TODO: Fix for use ACTION_REQUEST_ENABLE
          //  Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            //startActivityForResult(intent,REQUEST_ENABLE_BT);
        }
    }

    // Stop Bluetooth device.
    public void turnOff() {
        if (blueAdapter.isEnabled())
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

    // Devices Bounded.
    public List<String> getDevices(){
        List<String> adapters = new ArrayList<>();
            devices = blueAdapter.getBondedDevices();
            if(devices != null) {                   //TODO: Arreglar esto.
                if (devices.size() > 0) {
                    for (BluetoothDevice device : devices) {
                        adapters.add(device.getName());
                        Toast toast = Toast.makeText(this, device.getName(), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
            }
       return adapters;
    }


}
