package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
final class zzar implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzat zzatVar) {
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
        int i = this.zzb;
        str = this.zza.zza;
        if (i >= str.length()) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return new zzat(String.valueOf(i));
    }
}
