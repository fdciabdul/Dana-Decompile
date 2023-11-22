package com.uc.crashsdk;

import java.io.File;

/* loaded from: classes8.dex */
final class c implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        String z;
        boolean z2;
        Object[] F;
        try {
            z = b.z();
            boolean unused = b.w = !new File(z).exists();
            z2 = b.w;
            if (z2 || b.e) {
                F = b.F();
                b.b(F);
                b.e = false;
            }
        } catch (Exception e) {
            com.uc.crashsdk.a.a.a(e, false);
        }
    }
}
