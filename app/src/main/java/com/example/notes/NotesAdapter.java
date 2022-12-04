package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private List<StructureNote> notes;
    private OnItemClickListener itemClickListener;

    public NotesAdapter(List<StructureNote> notes) {
        this.notes = notes;
    }

    interface OnItemClickListener {
        void itemClick(StructureNote note);
        /* View view, int position*/
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView content;
        private TextView date;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_note);
            content = itemView.findViewById(R.id.content_note);
            date = itemView.findViewById(R.id.date_note);
        }

        public void bind(StructureNote      note) {

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

            title.setText(note.getName());
            content.setText(note.getContent());
            date.setText(formatter.format(note.getDate()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.itemClick(note);
                    }
                }
            });
        }
    }
}