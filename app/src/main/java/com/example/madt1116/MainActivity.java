package com.example.madt1116;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvContent;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
        this.listView = findViewById(R.id.listView);

    }

    public void setAdapter(ArrayList<String> result){
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, result);
        listView.setAdapter(arrayAdapter);
    }

    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("Loading...");
        new DataLoader(){
            @Override
            public void onPostExecute(ArrayList<String> result)
            {
                //tvContent.setText(result);
                setAdapter(result);
                tvContent.setText("Downloaded");
            }
        }.execute();
    }
}