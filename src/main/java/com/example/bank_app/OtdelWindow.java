package com.example.bank_app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class OtdelWindow extends AppCompatActivity {
    private LinearLayout container;
    private Button buttonFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otdelenia_bankomati_win);

        container = findViewById(R.id.containerValue);
        buttonFilter = findViewById(R.id.buttonFilter);

        addNewATD("Название банкомата 1", "Местоположение 1", false, "08:00");
        addNewATD("Название банкомата 2", "Местоположение 2", false, "08:00");
        addNewATD("Название отделения ", "Местоположение", true, "09:00");
        addNewATD("Название банкомата 4", "Местоположение 4", true, "12:00");
        addNewATD("Название отделения 1", "Местоположение 1", true, "00:00");

        buttonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterDialog();
            }
        });
    }

    private void addNewATD(String name, String location, boolean isOpen, String openingTime) {
        LinearLayout atmLayout = new LinearLayout(this);
        atmLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        atmLayout.setOrientation(LinearLayout.VERTICAL);

        TextView atmName = new TextView(this);
        atmName.setText(name);
        atmLayout.addView(atmName);

        TextView atmLocation = new TextView(this);
        atmLocation.setText(location);
        atmLayout.addView(atmLocation);

        TextView atmStatus = new TextView(this);
        atmStatus.setText("Статус: " + (isOpen ? "Открыт" : "Закрыт"));
        atmStatus.setTextColor(getResources().getColor(isOpen ? R.color.colorGreen : R.color.colorRed));
        atmLayout.addView(atmStatus);

        TextView atmTime = new TextView(this);
        atmTime.setText("Время открытия: " + openingTime);
        atmTime.setTextColor(getResources().getColor(R.color.colorGray));
        atmLayout.addView(atmTime);

        container.addView(atmLayout);
    }
    private void showFilterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Фильтр");
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_filter, null);
        builder.setView(dialogView);

        final RadioGroup radioGroup = dialogView.findViewById(R.id.radioGroupFilter);

        builder.setPositiveButton("Применить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(selectedId);
                if (radioButton != null) {
                    String filterOption = radioButton.getText().toString();
                    applyFilter(filterOption);
                }
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    private void applyFilter(String filterOption) {
        String isTrue;
        boolean isVisible = false;

        switch (filterOption) {
            case "Все":
                for(int i = 0; i < container.getChildCount(); i++)
                {
                    View child = container.getChildAt(i);
                    isVisible = true;
                    child.setVisibility(isVisible ? View.VISIBLE : View.GONE);
                }
                break;
            case "Работающие банкоматы":
                for (int i = 0; i < container.getChildCount(); i++) {
                    View child = container.getChildAt(i);
                    TextView checkStatus = child.findViewById(R.id.atmStatus);
                    isTrue = checkStatus.getText().toString();

                    if(isTrue == "Статус: Открыт")
                    {
                        isVisible = true;
                        child.setVisibility(isVisible ? View.VISIBLE : View.GONE);
                    }
                    else
                    {
                        isVisible = false;
                        child.setVisibility(isVisible ? View.VISIBLE : View.GONE);
                    }
                }
                break;
            case "Не работающие банкоматы":
                for (int i = 0; i < container.getChildCount(); i++) {
                    View child = container.getChildAt(i);
                    TextView atmStatus = child.findViewById(R.id.atmStatus);
                    isTrue = atmStatus.getText().toString();

                    if(isTrue == "Статус: Закрыт")
                    {
                        isVisible = true;
                        child.setVisibility(isVisible ? View.VISIBLE : View.GONE);
                    }
                    else
                    {
                        isVisible = false;
                        child.setVisibility(isVisible ? View.VISIBLE : View.GONE);
                    }
                }

                break;
        }

    }
}
