package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class zzja extends zziz {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzja(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzjd) && zzd() == ((zzjd) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (obj instanceof zzja) {
                zzja zzjaVar = (zzja) obj;
                int zzk = zzk();
                int zzk2 = zzjaVar.zzk();
                if (zzk == 0 || zzk2 == 0 || zzk == zzk2) {
                    int zzd = zzd();
                    if (zzd > zzjaVar.zzd()) {
                        throw new IllegalArgumentException("Length too large: " + zzd + zzd());
                    } else if (zzd > zzjaVar.zzd()) {
                        throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzjaVar.zzd());
                    } else if (zzjaVar instanceof zzja) {
                        byte[] bArr = this.zza;
                        byte[] bArr2 = zzjaVar.zza;
                        zzjaVar.zzc();
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
                        return zzjaVar.zzf(0, zzd).equals(zzf(0, zzd));
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjd
    public byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    protected final int zze(int i, int i2, int i3) {
        return zzkm.zzd(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final zzjd zzf(int i, int i2) {
        int zzj = zzj(0, i2, zzd());
        return zzj == 0 ? zzjd.zzb : new zzix(this.zza, 0, zzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjd
    public final void zzh(zzit zzitVar) throws IOException {
        ((zzji) zzitVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final boolean zzi() {
        return zznc.zzf(this.zza, 0, zzd());
    }
}
