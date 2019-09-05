package com.example.listviewandradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup1, radioGroup2, radioGroup3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup3 = findViewById(R.id.radioGroup3);
    }


    public void check(View view) {
        int[] ids = {
                radioGroup1.getCheckedRadioButtonId(),
                radioGroup2.getCheckedRadioButtonId(),
                radioGroup3.getCheckedRadioButtonId()
        };

        String text = "";
        int sum = 0;
        for (int id : ids) {
            if (id == R.id.radio4_1 || id == R.id.radio3_2 ||
                    id == R.id.radio1_3) {
                sum++;
            }
        }

        switch (sum){
            case 0:
                text = "None";
                break;
            case 1:
                text = "Minor";
                break;
            case 2:
                text = "Average";
                break;
            case 3:
                text = "Perfect!";
                break;
        }

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
