package com.alipay.imobile.magenerator.a;

/* loaded from: classes6.dex */
public final class aa {

    /* renamed from: a  reason: collision with root package name */
    private final int f7004a;
    private final z[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(int i, z... zVarArr) {
        this.f7004a = i;
        this.b = zVarArr;
    }

    public final int a() {
        return this.f7004a;
    }

    public final int b() {
        int i = 0;
        for (z zVar : this.b) {
            i += zVar.a();
        }
        return i;
    }

    public final int c() {
        return this.f7004a * b();
    }

    public final z[] d() {
        return this.b;
    }
}
