package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
final class zzas implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String str;
        int i = this.zzb;
        str = this.zza.zza;
        return i < str.length();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        String str;
        String str2;
        int i = this.zzb;
        zzat zzatVar = this.zza;
        str = zzatVar.zza;
        if (i >= str.length()) {
            throw new NoSuchElementException();
        }
        str2 = zzatVar.zza;
        this.zzb = i + 1;
        return new zzat(String.valueOf(str2.charAt(i)));
    }
}
