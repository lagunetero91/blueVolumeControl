package laurid.bluetoothcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import laurid.bluetoothcontroller.BluetoothControl.BluetoothControl;



public class MainActivity extends AppCompatActivity {
    BluetoothControl bluetoothcontrol = null;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluetoothcontrol = new BluetoothControl();
    }

     public void activateButtonAction(View v){
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

     // Looking for Bluetooth Devices in the zone and show it in a list.
     public void lookingForDevices(View v){
         if(bluetoothcontrol!=null){
             setContentView(R.layout.activity_main);
             ListView lista;
             ArrayAdapter <String> toList;
             lista = (ListView) findViewById(R.id.myList);
             toList = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bluetoothcontrol.getDevices());
             lista.setAdapter(toList);
         }
     }

}
