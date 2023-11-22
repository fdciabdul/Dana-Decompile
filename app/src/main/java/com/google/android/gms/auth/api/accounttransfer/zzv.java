package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* loaded from: classes7.dex */
public final class zzv implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        zzw zzwVar = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                i = SafeParcelReader.readInt(parcel, readHeader);
                hashSet.add(1);
            } else if (fieldId == 2) {
                zzwVar = (zzw) SafeParcelReader.createParcelable(parcel, readHeader, zzw.CREATOR);
                hashSet.add(2);
            } else if (fieldId == 3) {
                str = SafeParcelReader.createString(parcel, readHeader);
                hashSet.add(3);
            } else if (fieldId == 4) {
                str2 = SafeParcelReader.createString(parcel, readHeader);
                hashSet.add(4);
            } else if (fieldId == 5) {
                str3 = SafeParcelReader.createString(parcel, readHeader);
                hashSet.add(5);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            throw new SafeParcelReader.ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
        }
        return new zzu(hashSet, i, zzwVar, str, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzu[i];
    }
}
