package com.rd.draw.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes3.dex */
public class PositionSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<PositionSavedState> CREATOR = new Parcelable.Creator<PositionSavedState>() { // from class: com.rd.draw.data.PositionSavedState.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PositionSavedState createFromParcel(Parcel parcel) {
            return new PositionSavedState(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PositionSavedState[] newArray(int i) {
            return new PositionSavedState[i];
        }
    };
    public int BuiltInFictitiousFunctionClassFactory;
    public int PlaceComponentResult;
    public int getAuthRequestContext;

    /* synthetic */ PositionSavedState(Parcel parcel, byte b) {
        this(parcel);
    }

    public PositionSavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private PositionSavedState(Parcel parcel) {
        super(parcel);
        this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        this.PlaceComponentResult = parcel.readInt();
        this.getAuthRequestContext = parcel.readInt();
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeInt(this.PlaceComponentResult);
        parcel.writeInt(this.getAuthRequestContext);
    }
}
