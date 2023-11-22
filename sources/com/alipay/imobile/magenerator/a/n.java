package com.alipay.imobile.magenerator.a;

/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f7017a = new n(4201, 4096, 1);
    public static final n b = new n(1033, 1024, 1);
    public static final n c;
    public static final n d;
    public static final n e;
    public static final n f;
    public static final n g;
    public static final n h;
    private final int[] i;
    private final int[] j;
    private final o k;
    private final int l;
    private final int m;
    private final int n;

    static {
        n nVar = new n(67, 64, 1);
        c = nVar;
        d = new n(19, 16, 1);
        e = new n(285, 256, 0);
        n nVar2 = new n(301, 256, 1);
        f = nVar2;
        g = nVar2;
        h = nVar;
    }

    public n(int i, int i2, int i3) {
        this.m = i;
        this.l = i2;
        this.n = i3;
        this.i = new int[i2];
        this.j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.i[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.j[this.i[i6]] = i6;
        }
        this.k = new o(this, new int[]{0});
        new o(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, int i2) {
        return i ^ i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(int i) {
        return this.i[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o a() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o a(int i, int i2) {
        if (i >= 0) {
            if (i2 == 0) {
                return this.k;
            }
            int[] iArr = new int[i + 1];
            iArr[0] = i2;
            return new o(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    public final int b() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b(int i) {
        if (i != 0) {
            return this.j[i];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(int i) {
        if (i != 0) {
            return this.i[(this.l - this.j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.l - 1)];
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GF(0x");
        sb.append(Integer.toHexString(this.m));
        sb.append(',');
        sb.append(this.l);
        sb.append(')');
        return sb.toString();
    }
}
