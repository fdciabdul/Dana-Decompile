package com.iap.ac.config.lite.a;

import java.io.Serializable;
import java.text.DecimalFormat;

/* loaded from: classes3.dex */
public class i implements Serializable {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 63;
    private static final int MAXLABELS = 128;
    private static final int MAXNAME = 255;
    private static final int MAXOFFSETS = 7;
    private static final DecimalFormat byteFormat;
    private static final byte[] emptyLabel = {0};
    private static final byte[] lowercase;
    private static final long serialVersionUID = -7257019940971525644L;
    private byte[] name;
    private long offsets;

    static {
        int i = 0;
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        lowercase = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        while (true) {
            byte[] bArr = lowercase;
            if (i >= bArr.length) {
                return;
            }
            if (i >= 65 && i <= 90) {
                bArr[i] = (byte) ((i - 65) + 97);
            } else {
                bArr[i] = (byte) i;
            }
            i++;
        }
    }

    public i(String str) throws Exception {
        byte[] bArr = new byte[64];
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            byte charAt = (byte) str.charAt(i2);
            if (charAt == 46) {
                bArr[0] = (byte) (i - 1);
                appendFromString(bArr, 0, 1);
                i = 1;
            } else if (i <= 63) {
                bArr[i] = charAt;
                i++;
            } else {
                throw new a("label too long");
            }
        }
        appendFromString(emptyLabel, 0, 1);
    }

    private void append(byte[] bArr, int i, int i2) throws Exception {
        byte[] bArr2 = this.name;
        int length = bArr2 == null ? 0 : bArr2.length - offset(0);
        int i3 = i;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i3];
            if (i6 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i7 = i6 + 1;
            i3 += i7;
            i4 += i7;
        }
        int i8 = length + i4;
        if (i8 <= 255) {
            int i9 = getlabels();
            int i10 = i9 + i2;
            if (i10 <= 128) {
                byte[] bArr3 = new byte[i8];
                if (length != 0) {
                    System.arraycopy(this.name, offset(0), bArr3, 0, length);
                }
                System.arraycopy(bArr, i, bArr3, length, i4);
                this.name = bArr3;
                for (int i11 = 0; i11 < i2; i11++) {
                    setoffset(i9 + i11, length);
                    length += bArr3[length] + 1;
                }
                setlabels(i10);
                return;
            }
            throw new IllegalStateException("too many labels");
        }
        throw new a("name too long!");
    }

    private void appendFromString(byte[] bArr, int i, int i2) throws Exception {
        append(bArr, i, i2);
    }

    public static i fromString(String str) throws Exception {
        return new i(str);
    }

    private int getlabels() {
        return (int) (this.offsets & 255);
    }

    private int offset(int i) {
        if (i == 0 && getlabels() == 0) {
            return 0;
        }
        if (i < 0 || i >= getlabels()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i < 7) {
            return ((int) (this.offsets >>> ((7 - i) * 8))) & 255;
        }
        int offset = offset(6);
        for (int i2 = 6; i2 < i; i2++) {
            offset += this.name[offset] + 1;
        }
        return offset;
    }

    private void setlabels(int i) {
        this.offsets = (this.offsets & (-256)) | i;
    }

    private void setoffset(int i, int i2) {
        if (i >= 7) {
            return;
        }
        int i3 = (7 - i) * 8;
        this.offsets = (i2 << i3) | (this.offsets & ((255 << i3) ^ (-1)));
    }

    public boolean isAbsolute() {
        int labels = labels();
        return labels != 0 && this.name[offset(labels - 1)] == 0;
    }

    public int labels() {
        return getlabels();
    }

    public String toString() {
        byte[] bArr = this.name;
        return bArr == null ? "" : new String(bArr);
    }

    public void toWire(c cVar) {
        if (isAbsolute()) {
            int labels = labels();
            for (int i = 0; i < labels - 1; i++) {
                int offset = offset(i);
                byte[] bArr = this.name;
                cVar.a(bArr, offset, bArr[offset] + 1);
            }
            cVar.b(0);
            return;
        }
        throw new IllegalArgumentException("toWire() called on non-absolute name");
    }

    public i(b bVar) throws Exception {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int f = bVar.f();
            int i = f & 192;
            if (i != 0) {
                if (i == 192) {
                    int f2 = bVar.f() + ((f & (-193)) << 8);
                    if (f2 < bVar.b() - 2) {
                        if (!z2) {
                            bVar.i();
                            z2 = true;
                        }
                        bVar.a(f2);
                    } else {
                        throw new a("bad compression");
                    }
                } else {
                    throw new a("bad label type");
                }
            } else if (getlabels() >= 128) {
                throw new a("too many labels");
            } else {
                if (f == 0) {
                    append(emptyLabel, 0, 1);
                    z = true;
                } else {
                    bArr[0] = (byte) f;
                    bVar.a(bArr, 1, f);
                    append(bArr, 0, 1);
                }
            }
        }
        if (z2) {
            bVar.h();
        }
    }
}
