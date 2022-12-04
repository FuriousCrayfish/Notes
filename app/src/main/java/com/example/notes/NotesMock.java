package com.example.notes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotesMock {

    static List<StructureNote> notes = new ArrayList<>();

    static List<StructureNote> getNotes() {

        notes.add(new StructureNote(
                "Первая заметка",
                "Текст первой заметки",
                Calendar.getInstance().getTime()));

        notes.add(new StructureNote(
                "Вторая заметка",
                "Текст второй заметки",
                Calendar.getInstance().getTime()));

        notes.add(new StructureNote(
                "Третья заметка",
                "Текст третьей заметки",
                Calendar.getInstance().getTime()));

        notes.add(new StructureNote(
                "Четвертая заметка",
                "Текст четвертой заметки",
                Calendar.getInstance().getTime()));

        notes.add(new StructureNote(
                "Пятая заметка",
                "Текст пятой заметки",
                Calendar.getInstance().getTime()));

        notes.add(new StructureNote(
                "Шестая заметка",
                "Текст шестой заметки",
                Calendar.getInstance().getTime()));

        notes.add(new StructureNote(
                "Седьмая заметка",
                "Текст седьмой заметки",
                Calendar.getInstance().getTime()));

        return notes;

    }
}
