package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public class COSEAlgorithmIdentifier implements Parcelable {
    public static final Parcelable.Creator<COSEAlgorithmIdentifier> CREATOR = new zzp();
    private final Algorithm zza;

    /* loaded from: classes3.dex */
    public static class UnsupportedAlgorithmIdentifierException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UnsupportedAlgorithmIdentifierException(int r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Algorithm with COSE value "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " not supported"
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier.UnsupportedAlgorithmIdentifierException.<init>(int):void");
        }
    }

    COSEAlgorithmIdentifier(Algorithm algorithm) {
        this.zza = (Algorithm) Preconditions.checkNotNull(algorithm);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static COSEAlgorithmIdentifier fromCoseValue(int i) throws UnsupportedAlgorithmIdentifierException {
        RSAAlgorithm rSAAlgorithm;
        if (i == RSAAlgorithm.LEGACY_RS1.getAlgoValue()) {
            rSAAlgorithm = RSAAlgorithm.RS1;
        } else {
            RSAAlgorithm[] values = RSAAlgorithm.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    RSAAlgorithm rSAAlgorithm2 = values[i2];
                    if (rSAAlgorithm2.getAlgoValue() == i) {
                        rSAAlgorithm = rSAAlgorithm2;
                        break;
                    }
                    i2++;
                } else {
                    for (RSAAlgorithm rSAAlgorithm3 : EC2Algorithm.values()) {
                        if (rSAAlgorithm3.getAlgoValue() == i) {
                            rSAAlgorithm = rSAAlgorithm3;
                        }
                    }
                    throw new UnsupportedAlgorithmIdentifierException(i);
                }
            }
        }
        return new COSEAlgorithmIdentifier(rSAAlgorithm);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof COSEAlgorithmIdentifier) && this.zza.getAlgoValue() == ((COSEAlgorithmIdentifier) obj).zza.getAlgoValue();
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public int toCoseValue() {
        return this.zza.getAlgoValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza.getAlgoValue());
    }
}
