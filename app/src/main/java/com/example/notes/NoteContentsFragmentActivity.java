package com.example.notes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.notes.NoteContentsFragment.ARG_INDEX;

public class NoteContentsFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_port);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            //если устройство перевернули в альбомную ориентацию, закрываем эту активити
            finish();
            return;

        }

        // Если эта activity запускается первый раз (с каждым новым гербом первый раз),
        // то перенаправим параметр фрагменту и запустим фрагмент
        if(savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.note_contents_fragment_container, NoteContentsFragment.newInstance(getIntent()
                            .getExtras().getInt(ARG_INDEX))).commit();

    }
}
