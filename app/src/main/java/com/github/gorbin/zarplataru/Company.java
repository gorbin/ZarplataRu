package com.github.gorbin.zarplataru;

import android.os.Parcel;
import android.os.Parcelable;

public class Company implements Parcelable {

    private int id;
    private String title;
    private CompanyLogo logo;


    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CompanyLogo getLogo() {
        return logo;
    }

    public void setLogo(CompanyLogo logo) {
        this.logo = logo;
    }

    protected Company(Parcel in) {
        id = in.readInt();
        title = in.readString();
        logo = (CompanyLogo) in.readValue(CompanyLogo.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeValue(logo);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };
}