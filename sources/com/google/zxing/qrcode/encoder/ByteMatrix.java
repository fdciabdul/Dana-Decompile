package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int i, int i2) {
        this.bytes = (byte[][]) Array.newInstance(Byte.TYPE, i2, i);
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final byte get(int i, int i2) {
        return this.bytes[i2][i];
    }

    public final byte[][] getArray() {
        return this.bytes;
    }

    public final void set(int i, int i2, byte b) {
        this.bytes[i2][i] = b;
    }

    public final void set(int i, int i2, int i3) {
        this.bytes[i2][i] = (byte) i3;
    }

    public final void set(int i, int i2, boolean z) {
        this.bytes[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public final void clear(byte b) {
        for (byte[] bArr : this.bytes) {
            Arrays.fill(bArr, b);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i = 0; i < this.height; i++) {
            byte[] bArr = this.bytes[i];
            for (int i2 = 0; i2 < this.width; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b == 1) {
                    sb.append(" 1");
                } else {
                    sb.append("  ");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
