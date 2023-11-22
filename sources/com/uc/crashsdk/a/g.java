package com.uc.crashsdk.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class g implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        String str;
        String str2;
        obj = f.b;
        synchronized (obj) {
            f.f();
            f.b(!com.uc.crashsdk.b.t());
            str = f.f;
            if (h.b(str)) {
                str2 = f.f;
                k.b(str2);
            }
        }
    }
}
