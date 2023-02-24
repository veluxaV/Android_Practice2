package com.example.pr2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private Button add_car;
    private TextView add_car_text;
    private ImageView icon;

    static final String NAME = "NAME";
    static final String BRAND="BRAND";
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    //TextView textView = findViewById(R.id.textView);
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        String name = intent.getStringExtra(NAME);
                        String brand = intent.getStringExtra(BRAND);
                        add_car_text.setText("Ваша машина: " + name + " " + brand);
                    }
                    else{
                        add_car_text.setText("Ошибка");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_car_text = findViewById(R.id.add_car_text);
        add_car = findViewById(R.id.add_car_button);
        icon = findViewById(R.id.Car);

        icon.setImageResource(R.drawable.car);
        add_car_text.setText(R.string.car_is_not_added);

    }
    public void ButtonClicked(View view){
        Log.d(TAG, "Нажата кнопка Добавить автомобиль");
        Intent intent = new Intent(this, AddCarActivityActivity.class);
        mStartForResult.launch(intent);
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