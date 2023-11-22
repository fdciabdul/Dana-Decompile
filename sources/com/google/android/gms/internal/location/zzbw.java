package com.google.android.gms.internal.location;

import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzbw extends zzbx {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzbx zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbw(zzbx zzbxVar, int i, int i2) {
        this.zzc = zzbxVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbr.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzbx, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.location.zzbu
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.location.zzbu
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.location.zzbu
    public final boolean zzf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.location.zzbu
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.location.zzbx
    /* renamed from: zzh */
    public final zzbx subList(int i, int i2) {
        zzbr.zzc(i, i2, this.zzb);
        zzbx zzbxVar = this.zzc;
        int i3 = this.zza;
        return zzbxVar.subList(i + i3, i2 + i3);
    }
}
