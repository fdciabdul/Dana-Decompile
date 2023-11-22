package com.alibaba.ariver.kernel.api.remote;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class RemoteCallResult implements Parcelable {
    public static final Parcelable.Creator<RemoteCallResult> CREATOR = new Parcelable.Creator<RemoteCallResult>() { // from class: com.alibaba.ariver.kernel.api.remote.RemoteCallResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RemoteCallResult createFromParcel(Parcel parcel) {
            return new RemoteCallResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RemoteCallResult[] newArray(int i) {
            return new RemoteCallResult[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f6101a;
    private Object b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RemoteCallResult(Object obj) {
        this.f6101a = false;
        if (obj instanceof Throwable) {
            this.f6101a = true;
        }
        this.b = obj;
    }

    protected RemoteCallResult(Parcel parcel) {
        this.f6101a = false;
        this.f6101a = parcel.readByte() != 0;
        this.b = parcel.readValue(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f6101a ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.b);
    }

    public boolean isError() {
        return this.f6101a;
    }

    public Object getValue() {
        return this.b;
    }
}
