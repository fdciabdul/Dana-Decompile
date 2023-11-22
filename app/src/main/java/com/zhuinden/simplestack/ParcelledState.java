package com.zhuinden.simplestack;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.zhuinden.statebundle.StateBundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ParcelledState implements Parcelable {
    public static final Parcelable.Creator<ParcelledState> CREATOR = new Parcelable.Creator<ParcelledState>() { // from class: com.zhuinden.simplestack.ParcelledState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ParcelledState createFromParcel(Parcel parcel) {
            return new ParcelledState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ParcelledState[] newArray(int i) {
            return new ParcelledState[i];
        }
    };
    StateBundle bundle;
    Parcelable parcelableKey;
    StateBundle viewBundle;
    SparseArray<Parcelable> viewHierarchyState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParcelledState() {
    }

    protected ParcelledState(Parcel parcel) {
        this.parcelableKey = parcel.readParcelable(getClass().getClassLoader());
        this.viewHierarchyState = parcel.readSparseArray(getClass().getClassLoader());
        if (parcel.readByte() > 0) {
            this.bundle = (StateBundle) parcel.readParcelable(getClass().getClassLoader());
        }
        if (parcel.readByte() > 0) {
            this.viewBundle = (StateBundle) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.parcelableKey, i);
        parcel.writeSparseArray(this.viewHierarchyState);
        parcel.writeByte(this.bundle != null ? (byte) 1 : (byte) 0);
        StateBundle stateBundle = this.bundle;
        if (stateBundle != null) {
            parcel.writeParcelable(stateBundle, 0);
        }
        parcel.writeByte(this.viewBundle == null ? (byte) 0 : (byte) 1);
        StateBundle stateBundle2 = this.viewBundle;
        if (stateBundle2 != null) {
            parcel.writeParcelable(stateBundle2, 0);
        }
    }
}
