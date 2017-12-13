package com.example.riccde.scannerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String[] values = new String[] {"India", "China", "australia", "Portugle", "America", "New Zealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final int REQ_CODE_TAKE_PICTURE = 30210;

    public void scanButtonClick(View view){
        // Finds Scan Button and setup initial scan
        Button sbutt = (Button) findViewById(R.id.scan_button);
        Toast.makeText(this,"Scanning",Toast.LENGTH_SHORT).show();



        Intent picintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(picintent, REQ_CODE_TAKE_PICTURE);

    }
    public void listButtonClick(View view) {
        Toast.makeText(this,"Generating List",Toast.LENGTH_SHORT).show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        String re = scanResult.getContents();
        // Continue to scan for result
        if (scanResult != null) {
            if(scanResult.getContents() == null){
                Toast.makeText(this,"You cancelled the scanning", Toast.LENGTH_SHORT).show();
            }
            else{
                // Toast.makeText(this,re,Toast.LENGTH_SHORT).show();
                ListView lv = (ListView)findViewById(R.id.list_number);
                lv.setAdapter(adapter);
            }
            Log.d("code", re);
        }
        // else continue with any other code you need in the method
        else {

        }
    }

}
