package com.example.notes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

public class NoteContentsFragment extends Fragment {

    static final String ARG_INDEX = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_note_contents, container, false);
    }

    private TextView textView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();

        //аргументы могут быть = null, делаем проверку

        if (arguments != null) {

            Note note = arguments.getParcelable(ARG_INDEX);
            //найдем в root нужный нам TextView
            /*TextView textNoteContents*/
            textView = view.findViewById(R.id.note_contents_fragment_2);

            /*textNoteContents*/
            textView.setText(note.getNoteName());

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
            for (Fragment fragment : fragments) {
                if (fragment instanceof NoteContentsFragment && fragment.isVisible())
                    fragmentManager.beginTransaction().remove(fragment).commit();
            }

        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.menu_fragment, menu);

        MenuItem itemAbout = menu.findItem(R.id.action_about);
        if (itemAbout != null) {
            itemAbout.setVisible(false);
        }

        MenuItem itemSearch = menu.findItem(R.id.action_search);
        if (itemSearch != null) {
            itemSearch.setVisible(false);
        }

        MenuItem itemAdd = menu.findItem(R.id.action_add);
        if (itemAdd != null) {
            itemAdd.setVisible(false);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_send) {
            textView.setText(R.string.send);
            Toast.makeText(getContext(), "Note sent", Toast.LENGTH_LONG).show();
            return true;
        }

        if (item.getItemId() == R.id.action_delete) {

            new AlertDialog.Builder(getContext())
                    .setTitle("Attention!")
                    .setMessage("do you want to delete this item?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    textView.setText(R.string.delete);
                                    Toast.makeText(getContext(), "Note deleted", Toast.LENGTH_LONG).show();
                                }
                            }
                    )
                    .setNegativeButton("No", null)
                    .show();



            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    //рекомендуемый способ создания фрагмента через фабричный метод
    public static NoteContentsFragment newInstance(Note note) {

        NoteContentsFragment noteContentsFragment = new NoteContentsFragment();
        //передача параметров через Bundle
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, note);
        noteContentsFragment.setArguments(args);
        return noteContentsFragment;

    }

}