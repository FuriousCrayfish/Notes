package com.example.notes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class StructureNote implements Parcelable {
    //3. Создайте класс данных со структурой заметок: название заметки, описание заметки, дата создания и т. п.
    // структурный класс заметки, содержит переменные основных параметров,
    // их геттеры и сеттеры


    private String name; // название заметки
    private String content; //содержание заметки
    private Date date; //дата создания заметки

    public StructureNote(String name, String content, Date date) {
        this.name = name;
        this.content = content;
        this.date = date;

    }

    protected StructureNote(Parcel in) {
        name = in.readString();
        content = in.readString();
    }

    public static final Creator<StructureNote> CREATOR = new Creator<StructureNote>() {
        @Override
        public StructureNote createFromParcel(Parcel in) {
            return new StructureNote(in);
        }

        @Override
        public StructureNote[] newArray(int size) {
            return new StructureNote[size];
        }
    };

    public void greatNote(String name, String content) {

        this.name = name;
        this.content = content;


    }

    public String getName() {

        return name;

    }

    public void setName() {

        this.name = name;

    }

    public String getContent() {

        return content;

    }

    public void setContent() {

        this.content = content;

    }

    public Date getDate() {

        return date;

    }

    public void setDate() {

        this.date = date;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(content);
    }
}
