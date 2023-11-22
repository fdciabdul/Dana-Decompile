package com.google.android.gms.internal.auth;

import java.io.IOException;

/* loaded from: classes7.dex */
final class zzga implements zzgh {
    private final zzfw zza;
    private final zzgy zzb;
    private final zzel zzc;

    private zzga(zzgy zzgyVar, zzel zzelVar, zzfw zzfwVar) {
        this.zzb = zzgyVar;
        this.zzc = zzelVar;
        this.zza = zzfwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzga zzb(zzgy zzgyVar, zzel zzelVar, zzfw zzfwVar) {
        return new zzga(zzgyVar, zzelVar, zzfwVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final int zza(Object obj) {
        return this.zzb.zza(obj).hashCode();
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final Object zzd() {
        return ((zzes) ((zzeu) this.zza).zzi(5, null, null)).zzg();
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zze(Object obj) {
        this.zzb.zze(obj);
        this.zzc.zzb(obj);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzf(Object obj, Object obj2) {
        zzgj.zzf(this.zzb, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzds zzdsVar) throws IOException {
        zzeu zzeuVar = (zzeu) obj;
        if (zzeuVar.zzc == zzgz.zza()) {
            zzeuVar.zzc = zzgz.zzc();
        }
        zzet zzetVar = (zzet) obj;
        throw null;
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzh(Object obj, Object obj2) {
        return this.zzb.zza(obj).equals(this.zzb.zza(obj2));
    }

    @Override // com.google.android.gms.internal.auth.zzgh
    public final boolean zzi(Object obj) {
        this.zzc.zza(obj);
        throw null;
    }
}
