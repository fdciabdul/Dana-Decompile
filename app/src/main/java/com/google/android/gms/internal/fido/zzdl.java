package com.google.android.gms.internal.fido;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class zzdl extends IOException {
    public zzdl(String str) {
        super(str);
    }

    public zzdl(String str, Throwable th) {
        super("Error in decoding CborValue from bytes", th);
    }
}
