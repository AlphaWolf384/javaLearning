package com.example.riccde.jkl;

import android.app.*;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends Activity {
    // Gather the list for ListActivity
    ArrayList<String> addList = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // Initiate Camera for scanning
    public void scanButtonClick(View view){
        Toast.makeText(this, "Scanning", Toast.LENGTH_SHORT).show();
        IntentIntegrator it = new IntentIntegrator(this);
        it.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        it.setOrientationLocked(false);
        it.initiateScan();
    }
    // List Button to open ListActivity with results and ability to export it to Excel
    public void listButtonClick(View view) {
        //Intent i = new Intent(this, ListActivity.class);

        setContentView(R.layout.activity_list);

        Toast.makeText(this, "Generating List", Toast.LENGTH_SHORT).show();
        ListView lv = (ListView)findViewById(R.id.MainList);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, addList);
        lv.setAdapter(adapter);

        for (int x = 0; x < addList.size(); x++) {
            System.out.println(addList.get(x));
        }

        Toast.makeText(this, "List Completed", Toast.LENGTH_SHORT).show();

        //startActivity(i);
    }
    // Get the results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && resultCode == RESULT_OK) {
            // Got result and Code down here to execute it
            Toast.makeText(this,result.getContents(),Toast.LENGTH_SHORT).show();
            addList.add(result.getContents());
            //adapter.notifyDataSetChanged();
        }
        else {
            // User pressed System back button to cancel scan
            Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show();
        }
    }
    // Adding ability to go back to Main Screen
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
