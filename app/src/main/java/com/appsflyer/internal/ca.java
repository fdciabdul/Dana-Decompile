package com.appsflyer.internal;

import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public final class ca extends FilterInputStream {
    private static final short AFInAppEventParameterName = (short) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d));
    private byte[] AFInAppEventType;
    private int AFKeystoreWrapper;
    private int AFLogger$LogLevel;
    private int AFVersionDeclaration;
    private int AppsFlyer2dXConversionCallback;
    private int getLevel;
    private int init;
    private int onAppOpenAttributionNative;
    private int onAttributionFailureNative;
    private int onDeepLinkingNative;
    private byte[] valueOf;
    private byte[] values;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    public ca(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        super(inputStream);
        this.AFVersionDeclaration = Integer.MAX_VALUE;
        this.valueOf = new byte[8];
        this.values = new byte[8];
        this.AFInAppEventType = new byte[8];
        this.AFKeystoreWrapper = 8;
        this.getLevel = 8;
        this.init = Math.min(Math.max(i2, 5), 16);
        this.AppsFlyer2dXConversionCallback = i3;
        if (i3 == 3) {
            System.arraycopy(bArr, 0, this.values, 0, 8);
        }
        long j = ((iArr[0] & 4294967295L) << 32) | (4294967295L & iArr[1]);
        if (i != 0) {
            int i4 = (int) j;
            this.AFLogger$LogLevel = i4;
            this.onAppOpenAttributionNative = i4 * i;
            this.onAttributionFailureNative = i4 ^ i;
            this.onDeepLinkingNative = (int) (j >> 32);
            return;
        }
        this.AFLogger$LogLevel = (int) j;
        long j2 = j >> 3;
        long j3 = AFInAppEventParameterName;
        this.onAppOpenAttributionNative = (int) ((j3 * j2) >> 32);
        this.onAttributionFailureNative = (int) (j >> 32);
        this.onDeepLinkingNative = (int) (j2 + j3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        valueOf();
        int i = this.AFKeystoreWrapper;
        if (i >= this.getLevel) {
            return -1;
        }
        byte[] bArr = this.valueOf;
        this.AFKeystoreWrapper = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            valueOf();
            int i5 = this.AFKeystoreWrapper;
            if (i5 >= this.getLevel) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.valueOf;
            this.AFKeystoreWrapper = i5 + 1;
            bArr[i4] = bArr2[i5];
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        valueOf();
        return this.getLevel - this.AFKeystoreWrapper;
    }

    private void values() {
        if (this.AppsFlyer2dXConversionCallback == 3) {
            byte[] bArr = this.valueOf;
            System.arraycopy(bArr, 0, this.AFInAppEventType, 0, bArr.length);
        }
        byte[] bArr2 = this.valueOf;
        int i = ((bArr2[0] << Ascii.CAN) & (-16777216)) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i2 = ((-16777216) & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i3 = 0;
        while (true) {
            int i4 = this.init;
            if (i3 >= i4) {
                break;
            }
            int i5 = (i4 - i3) * AFInAppEventParameterName;
            i2 -= ((i5 + i) ^ ((i << 4) + this.onAttributionFailureNative)) ^ ((i >>> 5) + this.onDeepLinkingNative);
            i -= (((i2 << 4) + this.AFLogger$LogLevel) ^ (i5 + i2)) ^ ((i2 >>> 5) + this.onAppOpenAttributionNative);
            i3++;
        }
        byte[] bArr3 = this.valueOf;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.AppsFlyer2dXConversionCallback == 3) {
            for (int i6 = 0; i6 < 8; i6++) {
                byte[] bArr4 = this.valueOf;
                bArr4[i6] = (byte) (bArr4[i6] ^ this.values[i6]);
            }
            byte[] bArr5 = this.AFInAppEventType;
            System.arraycopy(bArr5, 0, this.values, 0, bArr5.length);
        }
    }

    private int valueOf() throws IOException {
        if (this.AFVersionDeclaration == Integer.MAX_VALUE) {
            this.AFVersionDeclaration = ((FilterInputStream) this).in.read();
        }
        if (this.AFKeystoreWrapper == 8) {
            byte[] bArr = this.valueOf;
            int i = this.AFVersionDeclaration;
            bArr[0] = (byte) i;
            if (i < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i2 = 1;
            do {
                int read = ((FilterInputStream) this).in.read(this.valueOf, i2, 8 - i2);
                if (read <= 0) {
                    break;
                }
                i2 += read;
            } while (i2 < 8);
            if (i2 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            values();
            int read2 = ((FilterInputStream) this).in.read();
            this.AFVersionDeclaration = read2;
            this.AFKeystoreWrapper = 0;
            this.getLevel = read2 < 0 ? 8 - (this.valueOf[7] & 255) : 8;
        }
        return this.getLevel;
    }
}
