package com.example.notes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NoteStructureFragment extends Fragment {

    //при создании фрагмента укажем его макет

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_note_structure, container, false);
       /* TextView textView = rootView.findViewById(R.id.some_id);
        return rootView;*/
    }

   //метод вызывается когда макет экрана создан и готов к отображению
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);
        initList(view);

    }

    //метод создает список на основе ресурсов, вызывается в методе onViewCreated
    private void initList(View view){

        LinearLayout layoutView = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes);

        /*for(String note : notes){
            TextView tv = new TextView(getContext());
            tv.setText(note);
            tv.setTextSize(30);
            layoutView.addView(tv);

        }*/
        for(int i = 0; i< notes.length; i++){

            String note = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(note);
            tv.setTextSize(30);
            layoutView.addView(tv);
            final int position = i;
            tv.setOnClickListener(v ->{
                showContents(position);
            });

        }

    }

    private void showContents(int index){

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            showLandContents(index);
        }else {

            showPortContents(index);

        }

    }

    //показываем содержимое заметки в портретной ориентации
    private void showPortContents(int index){

        NoteContentsFragment noteContentsFragment = NoteContentsFragment.newInstance(index);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //добавляем фрагмент через add
        fragmentTransaction.add(R.id.fragment_container, noteContentsFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.setTransition(fragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

    }

    //показываем содержимое заметки в ландшафтной ориентации
    private void showLandContents(int index){

        //создаем фрагмент с ландшафтной позицией
        NoteContentsFragment detail = NoteContentsFragment.newInstance(index);

        //выполняем транзакцию по замене фрагмента
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.note_contents_fragment_text_view, detail);//замена фрагмента
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

    }

}