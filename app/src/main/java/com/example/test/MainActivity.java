package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2Question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.viewPager2Question = findViewById(R.id.viewPager2_question);

        QuestionFragmentStateAdapter adapter = new QuestionFragmentStateAdapter(this);
        this.viewPager2Question.setAdapter(adapter);

    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}