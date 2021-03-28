package com.example.swipeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class HomeActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gestureDetectorCompat = new GestureDetectorCompat(this, new GestureClass());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class GestureClass extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e2.getX() > e1.getX()) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            return true;
        }
    }
}