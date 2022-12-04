package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.notes.NoteContentsFragment.ARG_INDEX;
import static com.example.notes.NoteContentsFragment.newInstance;

public class NoteStructureFragment extends Fragment {

    private RecyclerView notesRV;
    private NotesAdapter adapter;

    //при создании фрагмента укажем его макет

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_structure, container, false);

    }

    //метод вызывается когда макет экрана создан и готов к отображению
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        notesRV = (RecyclerView) view.findViewById(R.id.notes_recycler);
        initList(view);

        adapter.setOnClickListener(new NotesAdapter.OnItemClickListener() {
            @Override
            public void itemClick(StructureNote note) {
                //Toast.makeText(getContext(), String.format("%s - %d", "Позиция", position), Toast.LENGTH_SHORT).show();
                showPortContents(note);
            }

        });

    }

    //метод создает список на основе ресурсов, вызывается в методе onViewCreated
    private void initList(View view) {

        adapter = new NotesAdapter(NotesMock.getNotes());
        notesRV.setAdapter(adapter);

       /* LinearLayout layoutView = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes);

        for (int i = 0; i < notes.length; i++) {

            String currentNote = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(currentNote);
            tv.setTextSize(30);
            layoutView.addView(tv);
            final int position = i;
            tv.setOnClickListener(v -> {

                showPortContents(new Note(position, currentNote));
            });

        }*/

    }

    //показываем содержимое заметки в портретной ориентации
    private void showPortContents(StructureNote note) {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction
                .addToBackStack("")
                .add(R.id.fragment_container, newInstance(note)).commit();
    }

}