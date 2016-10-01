package com.records.irving.snoopydog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tips_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
    }

    public void INICIO (View view){

        startActivity(new Intent(Tips_Activity.this, MainActivity.class));
    }
    public void TIPS (View view){

        startActivity(new Intent(Tips_Activity.this, Tips_Activity.class));
    }
    public void MAPAS (View view){

        startActivity(new Intent(Tips_Activity.this, MapsActivity.class));
    }
}
