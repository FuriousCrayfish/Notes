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

public class NoteContentsFragment extends Fragment {

    static final String ARG_INDEX = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_note_contents, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();

        //аргументы могут быть = null, делаем проверку

        if (arguments != null) {

            Note note = arguments.getParcelable(ARG_INDEX);
            //найдем в root нужный нам TextView
            TextView textNoteContents = view.findViewById(R.id.note_contents_fragment_2);

            textNoteContents.setText(note.getNoteName());

           getChildFragmentManager().beginTransaction().addToBackStack("")
                    .replace(R.id.note_contents_fragment_child_container, NoteContentsChildFragment.newInstance(note))
                    .commit();
        }
        Button buttonBack = view.findViewById(R.id.note_contents_fragment_button_back);

        buttonBack.setOnClickListener(view1 -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        view.findViewById(R.id.note_contents_fragment_button_remove).setOnClickListener(view1 -> {

            final FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            final List<Fragment> fragments = fragmentManager.getFragments();
            for(Fragment fragment: fragments){
                if(fragment instanceof NoteContentsFragment && fragment.isVisible())
                    fragmentManager.beginTransaction().remove(fragment).commit();
            }

        });

    }

    //рекомендуемый способ создания фрагмента через фабричный метод
    public static NoteContentsFragment newInstance(Note note){

        NoteContentsFragment noteContentsFragment = new NoteContentsFragment();
        //передача параметров через Bundle
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, note);
        noteContentsFragment.setArguments(args);
        return  noteContentsFragment;

    }

}