package com.iap.ac.config.lite.a;

import java.util.List;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private l f7620a;
    private i b;
    private int c;
    private int d;

    public g(i iVar, int i, int i2) {
        this.b = iVar;
        this.c = i;
        this.d = i2;
    }

    public final void a(l lVar) {
        this.f7620a = lVar;
    }

    public final List<k> a() throws Exception {
        h a2 = this.f7620a.a(h.a(k.a(this.b, this.c, this.d)));
        int c = a2.a().c();
        if (c == 0 || c == 3) {
            return a(a2);
        }
        return null;
    }

    public g(String str) throws Exception {
        this(i.fromString(str), 16, 1);
    }

    private List<k> a(h hVar) {
        k b = hVar.b();
        int c = hVar.a().c();
        if ((c == 0 || c == 3) && b != null) {
            return hVar.a(1);
        }
        return null;
    }
}
