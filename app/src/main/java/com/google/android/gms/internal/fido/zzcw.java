package com.google.android.gms.internal.fido;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class zzcw extends zzcv {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcw(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzcz) && zzd() == ((zzcz) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (obj instanceof zzcw) {
                zzcw zzcwVar = (zzcw) obj;
                int zzk = zzk();
                int zzk2 = zzcwVar.zzk();
                if (zzk == 0 || zzk2 == 0 || zzk == zzk2) {
                    int zzd = zzd();
                    if (zzd > zzcwVar.zzd()) {
                        throw new IllegalArgumentException("Length too large: " + zzd + zzd());
                    } else if (zzd <= zzcwVar.zzd()) {
                        if (zzcwVar instanceof zzcw) {
                            byte[] bArr = this.zza;
                            byte[] bArr2 = zzcwVar.zza;
                            int zzc = zzc();
                            int zzc2 = zzc();
                            int zzc3 = zzcwVar.zzc();
                            while (zzc2 < zzc + zzd) {
                                if (bArr[zzc2] != bArr2[zzc3]) {
                                    return false;
                                }
                                zzc2++;
                                zzc3++;
                            }
                            return true;
                        }
                        return zzcwVar.zzg(0, zzd).equals(zzg(0, zzd));
                    } else {
                        throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzcwVar.zzd());
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    protected final int zzf(int i, int i2, int i3) {
        byte[] bArr = this.zza;
        int zzc = zzc();
        byte[] bArr2 = zzde.zzd;
        for (int i4 = zzc; i4 < zzc + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final zzcz zzg(int i, int i2) {
        int zzj = zzj(i, i2, zzd());
        return zzj == 0 ? zzcz.zzb : new zzct(this.zza, zzc() + i, zzj);
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final InputStream zzh() {
        return new ByteArrayInputStream(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.fido.zzcz
    public final ByteBuffer zzi() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }
}
