package com.example.bank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTuday, setTvEUR, setTvUSD;
    private Button btnLogin;
    boolean isUserLogin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_bank_win);
        tvTuday = findViewById(R.id.tvDay);
        setTvEUR = findViewById(R.id.tvEURValue);
        setTvUSD = findViewById(R.id.tvUSDValue);
    }

    public void setToLiginWindow(View view){
        Intent intent = new Intent(this, LogInWindow.class);
        startActivity(intent);
    }
    public void setToValueWindow(View view){
        Intent intent = new Intent(this, AnotherValueWindow.class);
        startActivity(intent);
    }
    public void setToOtdelWindow(View view){
        Intent intent = new Intent(this, OtdelWindow.class);
        startActivity(intent);
    }
}