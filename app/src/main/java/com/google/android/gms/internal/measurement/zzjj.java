package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes7.dex */
public final class zzjj extends IOException {
    zzjj() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzjj(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjj(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
