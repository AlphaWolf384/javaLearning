package com.example.riccde.myfirstappmodified;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.validation.Validator;

public class MainActivity extends AppCompatActivity {

    private static Socket s;
    private static ServerSocket ss;
    private static InputStream isr;
    private static BufferedReader br;
    private static PrintWriter writer;

    Button connectButton;
    Button disconnectButton;
    Button sendButton;
    Button listButton;
    EditText messageText;
    EditText addressText;
    EditText portText;
    TextView statusText;
    ArrayList<String> addList;
    ArrayAdapter<String> adapter;

    protected String ip = ""; // 10.0.17.59
    protected String port = "0";
    String message = "";
    String[] list = {}; // TODO Save list for later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,addList);

        connectButton = (Button) findViewById(R.id.connectButton);
        disconnectButton = (Button) findViewById(R.id.disconnectButton);
        sendButton = (Button) findViewById(R.id.send_button);
        listButton = (Button) findViewById(R.id.listButton);
        messageText = (EditText) findViewById(R.id.messageText);
        addressText = (EditText) findViewById(R.id.addressText);
        portText = (EditText) findViewById(R.id.portText);
        statusText = (TextView) findViewById(R.id.statusText);

        statusText.setText("Status Unfound!");

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        disconnectButton.setClickable(false);
        disconnectButton.setEnabled(false);

    }
    // Send message to Server in PC and list
    public void sendMessage(View view) {
        String txtIp = addressText.getText().toString();
        String txtPort = portText.getText().toString();
        message = messageText.getText().toString();
        addList.add(message); //TODO Add localdatetime for subitem


        if(txtIp != null && txtPort != null) { // TODO Create Ability to save file on Android as well
            myTask mt = new myTask();
            mt.execute();
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        messageText.setText("");
    }
    // Send scan result to Server in PC and list
    public void sendScan (View view) {
        Toast.makeText(this, "Scanning", Toast.LENGTH_SHORT).show();
        IntentIntegrator it = new IntentIntegrator(this);
        it.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        it.setOrientationLocked(false);
        it.initiateScan();
    }
    // Connect a Server with input IP and port
    public void connectServer (View view){
        String txtIp = addressText.getText().toString();
        String txtPort = portText.getText().toString();

        if (txtIp != null && txtPort != null) {
            statusText.setText("Status: Connected to " + txtIp + " and " + txtPort);
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();

            ip = txtIp;
            port = txtPort;

            connectButton.setClickable(false);
            connectButton.setEnabled(false);
            disconnectButton.setClickable(true);
            disconnectButton.setEnabled(true);
            addressText.setEnabled(false);
            portText.setEnabled(false);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }
        else {
            statusText.setText("Status: Connected to null");
            Toast.makeText(this, "Nullified", Toast.LENGTH_SHORT).show();
        }
    }
    // Disconnect a Server and clear the texts
    public void disconnectServer (View view) {
        addressText.setText("");
        portText.setText("");

        ip = "";
        port = "0";

        connectButton.setClickable(true);
        connectButton.setEnabled(true);
        disconnectButton.setClickable(false);
        disconnectButton.setEnabled(false);
        addressText.setEnabled(true);
        portText.setEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show();
        statusText.setText("Status: Disconnected!");
    }
    // Second Page with list and data created
    public void listPage (View view) {
        System.out.println(addList); //TODO Bug: Won't save data if switched back to Main Activity
        // Hide Keyboard down to show list
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        // Check if there is something in the list
        if (addList.size() == 0 && list.length == 0) {
            System.out.println("Creating NULL List");
            Toast.makeText(this, "Empty List!", Toast.LENGTH_SHORT).show();
        }
        // Confirmed there is something in list
        else {
            System.out.println("Creating List");
            listButton.setEnabled(true);
            setContentView(R.layout.activity_list);
            ListView lv = (ListView) findViewById(R.id.mainList);
            lv.setAdapter(adapter);
        }
    }
    class myTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... params){
            Integer intPort = Integer.parseInt(port);

            try {
                s = new Socket(ip, intPort);
                writer = new PrintWriter(s.getOutputStream());
                writer.write(message);
                writer.flush();
                writer.close();
                s.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
    // Adding ability to go back to Main Screen
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    // Get the results from IntentIntegrater scanning
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String txtIp = addressText.getText().toString();
        String txtPort = portText.getText().toString();

        if (ip != null && port != "0"){
            if (result != null && resultCode == RESULT_OK) {
                // Confirmed result and add it to list
                Toast.makeText(this, "Scan completed", Toast.LENGTH_SHORT).show();
                addList.add(result.getContents());
                //String message = "";
                message = result.getContents();

                if(txtIp != null && txtPort != null) {
                    myTask mt = new myTask();
                    mt.execute();
                }
            }
            else {
                // User decided to go back
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }

            ip = txtIp;
            port = txtPort;
        }
        else {
            // Assuming IP and port are not connected but resume scanning on device
            if (result != null && resultCode == RESULT_OK) {
                System.out.println("Sending data to mainList");
                // Confirmed result and add it to list
                Toast.makeText(this, "Scan completed", Toast.LENGTH_SHORT).show();
                addList.add(result.getContents());
            }
            else {
                // User decided to go back
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
