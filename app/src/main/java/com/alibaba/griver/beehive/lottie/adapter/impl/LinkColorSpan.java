package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* loaded from: classes6.dex */
public class LinkColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    private final int mColor;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.text.ParcelableSpan
    public int getSpanTypeId() {
        return 0;
    }

    public int getSpanTypeIdInternal() {
        return 7;
    }

    public LinkColorSpan(int i) {
        this.mColor = i;
    }

    public LinkColorSpan(Parcel parcel) {
        this.mColor = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        writeToParcelInternal(parcel, i);
    }

    public void writeToParcelInternal(Parcel parcel, int i) {
        parcel.writeInt(this.mColor);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.linkColor = this.mColor;
    }
}
