package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes7.dex */
public final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = null;
        zzs zzsVar = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
                hashSet.add(1);
            } else if (fieldId == 2) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzu.CREATOR);
                hashSet.add(2);
            } else if (fieldId == 3) {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
                hashSet.add(3);
            } else if (fieldId == 4) {
                zzsVar = (zzs) SafeParcelReader.createParcelable(parcel, readHeader, zzs.CREATOR);
                hashSet.add(4);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            throw new SafeParcelReader.ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
        }
        return new zzo(hashSet, i, arrayList, i2, zzsVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
