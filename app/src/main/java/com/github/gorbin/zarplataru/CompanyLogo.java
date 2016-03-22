package com.github.gorbin.zarplataru;

import android.os.Parcel;
import android.os.Parcelable;

public class CompanyLogo implements Parcelable {
    private String url;

    public CompanyLogo() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected CompanyLogo(Parcel in) {
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CompanyLogo> CREATOR = new Parcelable.Creator<CompanyLogo>() {
        @Override
        public CompanyLogo createFromParcel(Parcel in) {
            return new CompanyLogo(in);
        }

        @Override
        public CompanyLogo[] newArray(int size) {
            return new CompanyLogo[size];
        }
    };
}