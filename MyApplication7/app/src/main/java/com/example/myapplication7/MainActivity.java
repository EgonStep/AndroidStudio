package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    /**
     * https://developer.android.com/guide/components/activities/?hl=pt-br
     * @param savedInstanceState
     */

    private Spinner spinnerExample;
    private EditText editValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerExample = findViewById(R.id.spinnerExample);
        editValue = findViewById(R.id.editValue);

        Log.d("CYCLE", "onCreate execute(MainActivity)");
    }

    @Override
    protected void onStart() {
         super.onStart();
         Log.d("CYCLE", "onStart execute(MainActivity)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CYCLE", "onResume execute(MainActivity)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CYCLE", "onPause execute(MainActivity)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CYCLE", "onStop execute(MainActivity)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CYCLE", "onDestroy execute(MainActivity)");
    }

    public void changeScreen(View view) {
        Intent intent = new Intent(MainActivity.this, DashActivity.class);

        Bundle bundle= new Bundle();
        String example = spinnerExample.getSelectedItem().toString();
        double value = Double.parseDouble(editValue.getText().toString());

        bundle.putString("EXAMPLE", example);
        bundle.putDouble("VALUE", value);

        intent.putExtras(bundle);

        startActivity(intent);
        // finish(); to current activity
    }
}
