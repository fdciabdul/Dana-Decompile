package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;

/* loaded from: classes3.dex */
final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return COSEAlgorithmIdentifier.fromCoseValue(parcel.readInt());
        } catch (COSEAlgorithmIdentifier.UnsupportedAlgorithmIdentifierException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new COSEAlgorithmIdentifier[i];
    }
}
