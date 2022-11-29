package com.example.notes;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

final class Note implements Parcelable {

    private final int contentIndex;
    private final String noteName;

    public Note(int contentIndex, String noteName) {
        this.contentIndex = contentIndex;
        this.noteName = noteName;
    }

    protected Note(Parcel in) {
        //сначала индекс, затем имя!
        contentIndex = in.readInt();
        noteName = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getContentIndex() {
        return contentIndex;
    }

    public String getNoteName() {
        return noteName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //сначала индекс, затем имя!
        dest.writeInt(contentIndex);
        dest.writeString(noteName);
    }
}
