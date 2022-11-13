package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(checkOrientation());

       /* //создаем фрагмент
        NoteStructureFragment noteStructureFragment = new NoteStructureFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().
                beginTransaction();

        // вызываем менеджер франментов
        fragmentTransaction.replace(R.id.fragment_container, noteStructureFragment);
        fragmentTransaction.commit();*/
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new NoteStructureFragment())
                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.note_contents_fragment_text_view, NoteContentsFragment.newInstance(0))
                    .commit();
        }else {

            getSupportFragmentManager()
                    .beginTransaction().
                    replace(R.id.fragment_container, new NoteStructureFragment())
                    .commit();

        }

    }

    private int checkOrientation(){

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            return R.layout.land_activity_main;

        }else {
            return R.layout.activity_main;
        }

    }
}