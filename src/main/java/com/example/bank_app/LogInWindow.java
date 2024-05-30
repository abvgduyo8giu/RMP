package com.example.bank_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInWindow extends AppCompatActivity {
    private Button btnTryToLogin;
    private EditText username, userPass;
    private TextView isLoginLocked;
    int tryLogIn = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTryToLogin = findViewById(R.id.btnLogIn);
        username = findViewById(R.id.inputLogin);
        userPass = findViewById(R.id.inputPassword);
        isLoginLocked = findViewById(R.id.loginLocked);
    }


    public void Login(View view) {
        if (username.getText().toString().equals("admin") && userPass.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Неправильные данные!", Toast.LENGTH_SHORT).show();
            tryLogIn--;
            if (tryLogIn == 0) {
                btnTryToLogin.setEnabled(false);
                isLoginLocked.setVisibility(View.VISIBLE);
                isLoginLocked.setBackgroundColor(Color.RED);
                isLoginLocked.setText("Вход заблокирован!!!");
            }
        }
    }
}

