package com.example.airbus_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fmain, fone, ftwo, fthree;
    Float translationYaxis =100f;
    Boolean menuOpen = false;
    OvershootInterpolator interpolator = new OvershootInterpolator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ShowMenu();
    }

    private void ShowMenu() {

        fmain = findViewById(R.id.fab_main);
        fone = findViewById(R.id.fab_one);
        ftwo = findViewById(R.id.fab_two);
        fthree = findViewById(R.id.fab_three);

        fone.setAlpha(0f);
        ftwo.setAlpha(0f);
        fthree.setAlpha(0f);

        fone.setTranslationY(translationYaxis);
        ftwo.setTranslationY(translationYaxis);
        fthree.setTranslationY(translationYaxis);

        fmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuOpen){
                    Closemenu();
                }
                else{
                    Openmenu();
                }
            }
        });

        fone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),ChatBot.class);
                startActivity(intent);
                Closemenu();

            }
        });

        ftwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BugReport.class);
                startActivity(intent);
                Closemenu();
            }
        });

        fthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You can search contents here", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Closemenu() {

        menuOpen =! menuOpen;
        fmain.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
        fone.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        ftwo.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fthree.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

    }

    private void Openmenu() {

        menuOpen =! menuOpen;
        fmain.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        fone.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        ftwo.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fthree.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();

    }
}