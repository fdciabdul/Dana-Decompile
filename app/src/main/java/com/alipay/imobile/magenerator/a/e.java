package com.alipay.imobile.magenerator.a;

import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final byte[][] f7009a;
    private final int b;
    private final int c;

    public e(int i, int i2) {
        this.f7009a = (byte[][]) Array.newInstance(Byte.TYPE, i2, i);
        this.b = i;
        this.c = i2;
    }

    public final byte a(int i, int i2) {
        return this.f7009a[i2][i];
    }

    public final int a() {
        return this.c;
    }

    public final void a(byte b) {
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                this.f7009a[i][i2] = b;
            }
        }
    }

    public final void a(int i, int i2, int i3) {
        this.f7009a[i2][i] = (byte) i3;
    }

    public final void a(int i, int i2, boolean z) {
        this.f7009a[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public final int b() {
        return this.b;
    }

    public final byte[][] c() {
        return this.f7009a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b = this.f7009a[i][i2];
                sb.append(b != 0 ? b != 1 ? "  " : " 1" : " 0");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
