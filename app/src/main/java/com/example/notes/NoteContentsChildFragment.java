package com.example.notes;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class NoteContentsChildFragment extends Fragment {

    static final String ARG_INDEX_CHILD = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_note_contents_child, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();

        //аргументы могут быть = null, делаем проверку

        if (arguments != null) {

            StructureNote note = arguments.getParcelable(ARG_INDEX_CHILD);
            note.getContent();

            view.findViewById(R.id.note_contents_fragment_child_button_back).setOnClickListener(view1 -> {

                getParentFragmentManager().popBackStack();
            });

        }
    }

    public static NoteContentsChildFragment newInstance(StructureNote note) {

        NoteContentsChildFragment noteContentsChildFragment = new NoteContentsChildFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX_CHILD, note);
        noteContentsChildFragment.setArguments(args);
        return noteContentsChildFragment;

    }
}