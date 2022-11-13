package com.example.notes;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NoteContentsFragment extends Fragment {

    static final String ARG_INDEX = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_contents, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();

        //аргументы могут быть = null, делаем проверку

        if (arguments != null) {
            int index = arguments.getInt(ARG_INDEX);
            //найдем в root нужный нам TextView
            TextView textNoteContents = (TextView)view.findViewById(R.id.note_contents_fragment);
            //получаем из ресурсов массив строк с текстом заметок
            TypedArray contentStrings = getResources().obtainTypedArray(R.array.contents);
            Log.e("", getResources().getString(contentStrings.getResourceId(index, 0)));
            //возьмем нужную строку и отобразим в TextView
            textNoteContents.setText(contentStrings.getResourceId(index, 0));
            contentStrings.recycle();
        }
    }

    //рекомендуемый способ создания фрагмента через фабричный метод
    public static NoteContentsFragment newInstance(int index){

        NoteContentsFragment noteContentsFragment = new NoteContentsFragment();
        //передача параметров через Bundle
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        noteContentsFragment.setArguments(args);
        return  noteContentsFragment;

    }

}