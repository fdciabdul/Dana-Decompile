package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzbg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List list = zzbf.zza;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = Long.MAX_VALUE;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                switch (fieldId) {
                    case 5:
                        list = SafeParcelReader.createTypedList(parcel, readHeader, ClientIdentity.CREATOR);
                        continue;
                    case 6:
                        str = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 7:
                        z = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 8:
                        z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 9:
                        z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 10:
                        str2 = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 11:
                        z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 12:
                        z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 13:
                        str3 = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 14:
                        j = SafeParcelReader.readLong(parcel, readHeader);
                        continue;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        continue;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel, readHeader, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzbf(locationRequest, list, str, z, z2, z3, str2, z4, z5, str3, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbf[i];
    }
}
