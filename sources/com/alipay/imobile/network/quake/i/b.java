package com.alipay.imobile.network.quake.i;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private char[] f7053a;
    private int b;

    public b(int i) {
        if (i >= 0) {
            this.f7053a = new char[i];
            return;
        }
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    private void a(int i) {
        char[] cArr = new char[Math.max(this.f7053a.length << 1, i)];
        System.arraycopy(this.f7053a, 0, cArr, 0, this.b);
        this.f7053a = cArr;
    }

    public final String toString() {
        return new String(this.f7053a, 0, this.b);
    }

    public final void a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.b + length;
        if (i > this.f7053a.length) {
            a(i);
        }
        str.getChars(0, length, this.f7053a, this.b);
        this.b = i;
    }
}
