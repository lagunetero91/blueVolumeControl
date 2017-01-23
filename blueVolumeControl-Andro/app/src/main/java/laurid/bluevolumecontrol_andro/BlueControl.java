package laurid.bluevolumecontrol_andro;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Set;

public class BlueControl extends AppCompatActivity {
    BluetoothAdapter myBlue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_control);
        init();
        if(myBlue==null){
            finish();
        }else{
            if(!myBlue.isEnabled()){
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent,1);
            }
        }
    }

    private void init() {
        myBlue = BluetoothAdapter.getDefaultAdapter();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplicationContext(),"Encienda el Bluetooth",Toast.LENGTH_SHORT).show();
        }
    }
}
