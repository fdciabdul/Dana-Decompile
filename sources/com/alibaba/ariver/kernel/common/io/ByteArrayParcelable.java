package com.alibaba.ariver.kernel.common.io;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class ByteArrayParcelable implements Parcelable {
    public static final Parcelable.Creator<ByteArrayParcelable> CREATOR = new Parcelable.Creator<ByteArrayParcelable>() { // from class: com.alibaba.ariver.kernel.common.io.ByteArrayParcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ByteArrayParcelable createFromParcel(Parcel parcel) {
            return new ByteArrayParcelable(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ByteArrayParcelable[] newArray(int i) {
            return new ByteArrayParcelable[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private byte[] f6123a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ByteArrayParcelable(byte[] bArr) {
        this.f6123a = bArr;
    }

    protected ByteArrayParcelable(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt > 0) {
            byte[] bArr = new byte[readInt];
            this.f6123a = bArr;
            parcel.readByteArray(bArr);
        }
    }

    public byte[] getBytes() {
        return this.f6123a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        byte[] bArr = this.f6123a;
        int length = bArr == null ? 0 : bArr.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.f6123a);
        }
    }
}
