package com.google.android.gms.internal.fido;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class zzdr implements Comparable {
    private final zzdr zzc(Class cls) throws zzdq {
        if (cls.isInstance(this)) {
            return (zzdr) cls.cast(this);
        }
        throw new zzdq("Expected a " + cls.getName() + " value, but got " + getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte b) {
        return (b >> 5) & 7;
    }

    public static zzdm zzg(long j) {
        return new zzdm(j);
    }

    public static zzdp zzi(String str) {
        return new zzdp(str);
    }

    public static zzdr zzk(InputStream inputStream) throws zzdl {
        return zzds.zza(inputStream, new zzdu(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zza();

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzb() {
        return 0;
    }

    public final zzdk zze() throws zzdq {
        return (zzdk) zzc(zzdk.class);
    }

    public final zzdm zzf() throws zzdq {
        return (zzdm) zzc(zzdm.class);
    }

    public final zzdo zzh() throws zzdq {
        return (zzdo) zzc(zzdo.class);
    }

    public static zzdr zzj(byte... bArr) throws zzdl {
        bArr.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Arrays.copyOf(bArr, bArr.length));
        return zzds.zza(byteArrayInputStream, new zzdu(byteArrayInputStream));
    }
}
