package com.example.fogas_app;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Pair implements Parcelable {
    private String number;
    private String text;
    private int image;

    public Pair(String number, String text, int image) {
        this.number = number;
        this.text = text;
        this.image = image;
    }

    public Pair() {
    }

    public Pair(String number, String text) {
        this.number = number;
        this.text = text;
    }

    protected Pair(Parcel in) {
        number = in.readString();
        text = in.readString();
        image = in.readInt();
    }

    public static final Creator<Pair> CREATOR = new Creator<Pair>() {
        @Override
        public Pair createFromParcel(Parcel in) {
            return new Pair(in);
        }

        @Override
        public Pair[] newArray(int size) {
            return new Pair[size];
        }
    };

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(number);
        dest.writeString(text);
        dest.writeInt(image);
    }

}
