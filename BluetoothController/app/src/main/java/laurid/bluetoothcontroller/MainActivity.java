package laurid.bluetoothcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import laurid.bluetoothcontroller.BluetoothControl.BluetoothControl;


public class MainActivity extends AppCompatActivity {
    BluetoothControl bluetoothcontrol = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void activateButtonAction(View v){
         bluetoothcontrol = new BluetoothControl();
         bluetoothcontrol.turnOn();
         Toast toast = Toast.makeText(this,"Bluetooth habilitado.",Toast.LENGTH_SHORT);
         toast.setGravity(Gravity.CENTER,0,0);
         toast.show();
     }

     public void disableBluetooth(View v){
         if(bluetoothcontrol!=null) {
             bluetoothcontrol.turnOff();
             Toast toast = Toast.makeText(this, "Bluetooth deshabilitado.", Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.CENTER, 0, 0);
             toast.show();
         }
     }

     public void lookingForDevices(View v){

     }

}
