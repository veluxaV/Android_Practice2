package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCarActivityActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private Button go_back;
    private EditText car_name;
    private EditText car_brandname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_car_activity);
        go_back = findViewById(R.id.GoBackButton);

        car_name = findViewById(R.id.name_edit_text);
        car_brandname = findViewById(R.id.brand_edit_text);

    }

    public void ButtonClicked(View view){
        Log.d(TAG, "Нажата кнопка Назад на главный экран");
        Intent intent = new Intent();
        String name = car_name.getText().toString();
        String brand = car_brandname.getText().toString();
        intent.putExtra(MainActivity.NAME, name);
        intent.putExtra(MainActivity.BRAND, brand);
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}