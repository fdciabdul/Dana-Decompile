package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes3.dex */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() { // from class: com.github.mikephil.charting.data.Entry.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Entry[] newArray(int i) {
            return new Entry[i];
        }
    };
    private float getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Entry() {
        this.getAuthRequestContext = 0.0f;
    }

    public Entry(byte b) {
        super(0.0f);
        this.getAuthRequestContext = 1.0f;
    }

    public Entry(float f, float f2, Object obj) {
        super(f2, obj);
        this.getAuthRequestContext = f;
    }

    public float MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        this.getAuthRequestContext = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Entry, x: ");
        sb.append(this.getAuthRequestContext);
        sb.append(" y: ");
        sb.append(getAuthRequestContext());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.getAuthRequestContext);
        parcel.writeFloat(getAuthRequestContext());
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 instanceof Parcelable) {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) this.KClassImpl$Data$declaredNonStaticMembers$2, i);
                return;
            }
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
        parcel.writeInt(0);
    }

    protected Entry(Parcel parcel) {
        this.getAuthRequestContext = 0.0f;
        this.getAuthRequestContext = parcel.readFloat();
        PlaceComponentResult(parcel.readFloat());
        if (parcel.readInt() == 1) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readParcelable(Object.class.getClassLoader());
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Entry entry) {
        return entry != null && entry.KClassImpl$Data$declaredNonStaticMembers$2 == this.KClassImpl$Data$declaredNonStaticMembers$2 && Math.abs(entry.getAuthRequestContext - this.getAuthRequestContext) <= Utils.KClassImpl$Data$declaredNonStaticMembers$2 && Math.abs(entry.getAuthRequestContext() - getAuthRequestContext()) <= Utils.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
