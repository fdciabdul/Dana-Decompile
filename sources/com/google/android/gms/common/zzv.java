package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzv extends zzx {
    private final Callable zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzv(Callable callable, zzu zzuVar) {
        super();
        this.zze = callable;
    }

    @Override // com.google.android.gms.common.zzx
    final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
