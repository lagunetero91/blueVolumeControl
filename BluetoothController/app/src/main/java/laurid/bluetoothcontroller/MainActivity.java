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

import static laurid.bluetoothcontroller.R.id.myList;


public class MainActivity extends AppCompatActivity {
    BluetoothControl bluetoothcontrol = null;
    private ListView listView;
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
         if(bluetoothcontrol!=null){
             ArrayAdapter <String> toList= new ArrayAdapter<String>(this,R.layout.activity_main);
             listView = (ListView) findViewById(R.id.myList);
             Toast toast = Toast.makeText(this, "Antes de .", Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.CENTER, 0, 0);
             toast.show();
             listView.setAdapter(new ArrayAdapter<String>(this,R.layout.activity_main,bluetoothcontrol.getDevices()));
            // myList(new ArrayAdapter<String>(this,R.layout.myList,bluetoothcontrol.getBoundedDevices()));
             toast = Toast.makeText(this, "Despues de .", Toast.LENGTH_SHORT);
             toast.setGravity(Gravity.CENTER, 0, 0);
             toast.show();
         }
     }

}
