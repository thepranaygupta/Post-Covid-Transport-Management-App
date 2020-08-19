package com.example.postcovidtransport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mLoginBtn, mSignupBtn;
    ImageView logoimage;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkInternetConnection();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title= findViewById(R.id.title);
        mLoginBtn = findViewById(R.id.login);
        mSignupBtn = findViewById(R.id.signup);
        //logoimage = findViewById(R.id.logoimg);
        mSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                Log.e("A","sign up is caleed");
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                //startActivity(new Intent(getApplicationContext(),Signup.class));
                mSignupBtn.startAnimation(animation);
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                mLoginBtn.startAnimation(animation);
            }
        });
    }
    private void checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =  connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null){
            opendialog();
        }

    }
    private void opendialog() {
        DialogforConnectivity dialog = new DialogforConnectivity();
        dialog.show(getSupportFragmentManager(),"example");
    }
}