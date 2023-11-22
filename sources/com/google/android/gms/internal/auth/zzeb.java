package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class zzeb extends zzea {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzee) && zzd() == ((zzee) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (obj instanceof zzeb) {
                zzeb zzebVar = (zzeb) obj;
                int zzj = zzj();
                int zzj2 = zzebVar.zzj();
                if (zzj == 0 || zzj2 == 0 || zzj == zzj2) {
                    int zzd = zzd();
                    if (zzd > zzebVar.zzd()) {
                        throw new IllegalArgumentException("Length too large: " + zzd + zzd());
                    } else if (zzd > zzebVar.zzd()) {
                        throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzebVar.zzd());
                    } else if (zzebVar instanceof zzeb) {
                        byte[] bArr = this.zza;
                        byte[] bArr2 = zzebVar.zza;
                        zzebVar.zzc();
                        int i = 0;
                        int i2 = 0;
                        while (i < zzd) {
                            if (bArr[i] != bArr2[i2]) {
                                return false;
                            }
                            i++;
                            i2++;
                        }
                        return true;
                    } else {
                        return zzebVar.zzf(0, zzd).equals(zzf(0, zzd));
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzee
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.auth.zzee
    protected final int zze(int i, int i2, int i3) {
        return zzez.zzd(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public final zzee zzf(int i, int i2) {
        int zzi = zzi(0, i2, zzd());
        return zzi == 0 ? zzee.zzb : new zzdy(this.zza, 0, zzi);
    }

    @Override // com.google.android.gms.internal.auth.zzee
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public final boolean zzh() {
        return zzhm.zzd(this.zza, 0, zzd());
    }
}
