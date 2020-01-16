package com.game.box.applettaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yd.sdk.ApManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.applet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApManager.openAppletTask(MainActivity.this,"1222","*EFvr7Zt$GUhP7ep","1%G88@0V#8&AjV&CJGzifqw0qXo2Hf^s");
            }
        });
        findViewById(R.id.applet_api).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AppletActivity.class));
               // ApManager.openAppletTask(MainActivity.this,"1222","*EFvr7Zt$GUhP7ep","1%G88@0V#8&AjV&CJGzifqw0qXo2Hf^s");
            }
        });
    }
}
