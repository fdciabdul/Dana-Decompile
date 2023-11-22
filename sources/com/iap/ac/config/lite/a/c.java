package com.iap.ac.config.lite.a;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f7618a;
    private int b;

    public c(int i) {
        this.f7618a = new byte[i];
        this.b = 0;
    }

    private void a(long j, int i) {
        if (j < 0 || j > (1 << i)) {
            StringBuilder sb = new StringBuilder();
            sb.append(j);
            sb.append(" out of range for ");
            sb.append(i);
            sb.append(" bit value");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private void c(int i) {
        byte[] bArr = this.f7618a;
        int length = bArr.length;
        int i2 = this.b;
        if (length - i2 >= i) {
            return;
        }
        int length2 = bArr.length * 2;
        int i3 = i + i2;
        if (length2 < i3) {
            length2 = i3;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.f7618a = bArr2;
    }

    public void b(int i) {
        a(i, 8);
        c(1);
        byte[] bArr = this.f7618a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void a(int i) {
        a(i, 16);
        c(2);
        byte[] bArr = this.f7618a;
        int i2 = this.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        this.b = i3 + 1;
        bArr[i3] = (byte) (i & 255);
    }

    public c() {
        this(32);
    }

    public void a(byte[] bArr, int i, int i2) {
        c(i2);
        System.arraycopy(bArr, i, this.f7618a, this.b, i2);
        this.b += i2;
    }

    public byte[] a() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f7618a, 0, bArr, 0, i);
        return bArr;
    }
}
