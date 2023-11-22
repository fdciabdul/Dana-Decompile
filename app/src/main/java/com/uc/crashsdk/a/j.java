package com.uc.crashsdk.a;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f7712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Runnable runnable) {
        this.f7712a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        hashMap = i.e;
        synchronized (hashMap) {
            hashMap2 = i.e;
            if (hashMap2.get(this.f7712a) != null) {
                hashMap3 = i.e;
                hashMap3.remove(this.f7712a);
            }
        }
        StringBuilder sb = new StringBuilder("pre-run: ");
        sb.append(this.f7712a);
        c.a(sb.toString());
        this.f7712a.run();
        StringBuilder sb2 = new StringBuilder("end-run: ");
        sb2.append(this.f7712a);
        c.a(sb2.toString());
    }
}
