package com.alipay.imobile.magenerator.a;

import id.dana.cashier.view.InputCardNumberView;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class b implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int[] f7006a;
    private int b;

    public b() {
        this.b = 0;
        this.f7006a = new int[1];
    }

    b(int[] iArr, int i) {
        this.f7006a = iArr;
        this.b = i;
    }

    private void b(int i) {
        if (i > this.f7006a.length * 32) {
            int[] c = c(i);
            int[] iArr = this.f7006a;
            System.arraycopy(iArr, 0, c, 0, iArr.length);
            this.f7006a = c;
        }
    }

    private static int[] c(int i) {
        return new int[(i + 31) / 32];
    }

    public final int a() {
        return this.b;
    }

    public final void a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        b(this.b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i2--;
        }
    }

    public final void a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (a(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public final void a(b bVar) {
        int i = bVar.b;
        b(this.b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(bVar.a(i2));
        }
    }

    public final void a(boolean z) {
        b(this.b + 1);
        if (z) {
            int[] iArr = this.f7006a;
            int i = this.b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.b++;
    }

    public final boolean a(int i) {
        return ((1 << (i & 31)) & this.f7006a[i / 32]) != 0;
    }

    public final int b() {
        return (this.b + 7) / 8;
    }

    public final void b(b bVar) {
        if (this.f7006a.length != bVar.f7006a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f7006a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ bVar.f7006a[i];
            i++;
        }
    }

    /* renamed from: c  reason: merged with bridge method [inline-methods] */
    public final b clone() {
        return new b((int[]) this.f7006a.clone(), this.b);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.b == bVar.b && Arrays.equals(this.f7006a, bVar.f7006a);
        }
        return false;
    }

    public final int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.f7006a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.b);
        for (int i = 0; i < this.b; i++) {
            if ((i & 7) == 0) {
                sb.append(InputCardNumberView.DIVIDER);
            }
            sb.append(a(i) ? 'X' : '.');
        }
        return sb.toString();
    }
}
