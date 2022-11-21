package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(checkOrientation());
        setContentView(R.layout.activity_main);

        //создаем фрагмент
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new NoteStructureFragment()).commit();

    }

    private int checkOrientation() {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            return R.layout.land_activity_main;

        } else {
            return R.layout.activity_main;
        }

    }
}