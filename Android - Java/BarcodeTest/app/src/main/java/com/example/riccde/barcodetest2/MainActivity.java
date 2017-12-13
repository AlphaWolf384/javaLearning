package com.example.riccde.barcodetest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final int REQ_CODE_TAKE_PICTURE = 30210;

    public void scanButtonClick(View view){
        Button sbutt = (Button) findViewById(R.id.scan_button);
        Toast.makeText(this,"Scanning",Toast.LENGTH_SHORT).show();

        Intent picintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(picintent, REQ_CODE_TAKE_PICTURE);
    }

    public void listButtonClick(View view) {
        Button lbutt = (Button) findViewById(R.id.list_button);
        Toast.makeText(this,"Generating List",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQ_CODE_TAKE_PICTURE && resultCode == RESULT_OK) {
            Bitmap bmp = (Bitmap) intent.getExtras().get("data");
            ImageView img = (ImageView) findViewById(R.id.photo);
            img.setImageBitmap(bmp);
            if (requestCode == 1)
            {
                final boolean isCamera;
                if (intent == null || intent.getData() == null)
                {
                    isCamera = true;
                }
                else
                {
                    final String action = intent.getAction();
                    if (action == null)
                    {
                        isCamera = false;
                    }
                    else
                    {
                        isCamera = action.equals(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    }
                }
            }
        }
    }
}
