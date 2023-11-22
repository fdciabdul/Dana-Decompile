package com.alipay.imobile.magenerator.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final n f7018a;
    private final int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f7018a = nVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int i2 = length - i;
        int[] iArr2 = new int[i2];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, i2);
    }

    final int a(int i) {
        return this.b[(r0.length - 1) - i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o a(int i, int i2) {
        if (i >= 0) {
            if (i2 == 0) {
                return this.f7018a.a();
            }
            int length = this.b.length;
            int[] iArr = new int[i + length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f7018a.c(this.b[i3], i2);
            }
            return new o(this.f7018a, iArr);
        }
        throw new IllegalArgumentException();
    }

    final o a(o oVar) {
        if (this.f7018a.equals(oVar.f7018a)) {
            if (c()) {
                return oVar;
            }
            if (oVar.c()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = oVar.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr3[i] = n.b(iArr2[i - length], iArr[i]);
            }
            return new o(this.f7018a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] a() {
        return this.b;
    }

    final int b() {
        return this.b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o b(o oVar) {
        if (this.f7018a.equals(oVar.f7018a)) {
            if (c() || oVar.c()) {
                return this.f7018a.a();
            }
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = oVar.b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[(length + length2) - 1];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = n.b(iArr3[i4], this.f7018a.c(i2, iArr2[i3]));
                }
            }
            return new o(this.f7018a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    final boolean c() {
        return this.b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o[] c(o oVar) {
        if (this.f7018a.equals(oVar.f7018a)) {
            if (oVar.c()) {
                throw new IllegalArgumentException("Divide by 0");
            }
            o a2 = this.f7018a.a();
            int c = this.f7018a.c(oVar.a(oVar.b()));
            o oVar2 = this;
            while (oVar2.b() >= oVar.b() && !oVar2.c()) {
                int b = oVar2.b() - oVar.b();
                int c2 = this.f7018a.c(oVar2.a(oVar2.b()), c);
                o a3 = oVar.a(b, c2);
                a2 = a2.a(this.f7018a.a(b, c2));
                oVar2 = oVar2.a(a3);
            }
            return new o[]{a2, oVar2};
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public final String toString() {
        char c;
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b = b(); b >= 0; b--) {
            int a2 = a(b);
            if (a2 != 0) {
                if (a2 < 0) {
                    sb.append(" - ");
                    a2 = -a2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b == 0 || a2 != 1) {
                    int b2 = this.f7018a.b(a2);
                    if (b2 == 0) {
                        c = '1';
                    } else if (b2 == 1) {
                        c = 'a';
                    } else {
                        sb.append("a^");
                        sb.append(b2);
                    }
                    sb.append(c);
                }
                if (b != 0) {
                    if (b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b);
                    }
                }
            }
        }
        return sb.toString();
    }
}
