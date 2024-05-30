package com.example.bank_app;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnotherValueWindow extends AppCompatActivity {
    private LinearLayout valueContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_value_win);
        valueContainer = findViewById(R.id.containerValue);

        addValue("American dollar", "63,72", "60,88");
        addValue("American dollar", "63,72", "60,88");
        addValue("American dollar", "63,72", "60,88");

    }

    private void addValue(String valueName, String valueBuy, String valueSell) {
        LinearLayout valueLayout = new LinearLayout(this);
        valueLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        valueLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView valueName1 = new TextView(this);
        valueName1.setText(valueName);
        valueLayout.addView(valueName1);

        TextView valueBuy1 = new TextView(this);
        valueBuy1.setText(valueBuy);
        valueLayout.addView(valueBuy1);

        TextView valueSell1 = new TextView(this);
        valueSell1.setText(valueSell);
        valueLayout.addView(valueSell1);

        valueContainer.addView(valueLayout);
    }
}
