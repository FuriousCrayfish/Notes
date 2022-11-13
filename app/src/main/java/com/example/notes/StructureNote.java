package com.example.notes;

import java.util.Calendar;

public class StructureNote {
    //3. Создайте класс данных со структурой заметок: название заметки, описание заметки, дата создания и т. п.
    // структурный класс заметки, содержит переменные основных параметров,
    // их геттеры и сеттеры

    private String name; // название заметки
    private String content; //содержание заметки
    private Calendar date; //дата создания заметки

    public StructureNote(String name, String content, Calendar date) {
        this.name = name;
        this.content = content;
        this.date = date;
    }

    public void greatNote(String name, String content){

        this.name = name;
        this.content = content;

    }

    public String getName(){

        return name;

    }

    public void setName(){

        this.name = name;

    }

    public String getContent(){

        return content;

    }

    public void setContent(){

        this.content = content;

    }

    public Calendar getDate(){

        return date;

    }

    public void setDate(){

        this.date = date;

    }
}
