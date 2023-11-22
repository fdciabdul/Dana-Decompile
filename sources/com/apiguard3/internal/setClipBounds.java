package com.apiguard3.internal;

import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class setClipBounds extends FilterInputStream {
    private byte[] AGState;
    private byte[] APIGuard;
    private int APIGuard$Callback;
    private int analyzeResponse;
    private int checkCertificates;
    private int generateHeaders;
    private int getRequestHeaders;
    private int initialize;
    private int parseResponseHeaders;
    private int updateKernel;
    private byte[] valueOf;
    private int values;
    private static final short getSharedInstance = (short) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d));
    private static int log;
    private static int getState = (log + 97) % 128;

    public setClipBounds(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        super(inputStream);
        this.initialize = Integer.MAX_VALUE;
        this.valueOf = new byte[8];
        this.APIGuard = new byte[8];
        this.AGState = new byte[8];
        this.values = 8;
        this.getRequestHeaders = 8;
        this.analyzeResponse = Math.min(Math.max(i2, 5), 16);
        this.generateHeaders = i3;
        if (i3 == 3) {
            System.arraycopy(bArr, 0, this.APIGuard, 0, 8);
        }
        AGState((iArr[1] & 4294967295L) | ((iArr[0] & 4294967295L) << 32), i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        log = (getState + 51) % 128;
        AGState();
        int i = this.values;
        if (i < this.getRequestHeaders) {
            byte[] bArr = this.valueOf;
            this.values = i + 1;
            byte b = bArr[i];
            log = (getState + 109) % 128;
            return b & 255;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        log = (getState + 81) % 128;
        int i3 = i + i2;
        int i4 = i;
        while (i4 < i3) {
            AGState();
            int i5 = this.values;
            if (!(i5 < this.getRequestHeaders)) {
                if ((i4 == i ? '5' : Typography.quote) != '\"') {
                    log = (getState + 121) % 128;
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.valueOf;
            this.values = i5 + 1;
            bArr[i4] = bArr2[i5];
            i4++;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (true) {
            if (!(j2 < j)) {
                break;
            }
            getState = (log + 109) % 128;
            if ((read() != -1 ? '.' : 'W') != '.') {
                break;
            }
            j2++;
            log = (getState + 51) % 128;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        log = (getState + 117) % 128;
        AGState();
        int i = this.getRequestHeaders;
        int i2 = this.values;
        int i3 = log + 53;
        getState = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 0 : (char) 3) == 3) {
            return i - i2;
        }
        throw new NullPointerException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        log = (getState + 1) % 128;
        return false;
    }

    private void AGState(long j, int i) {
        if (!(i != 0)) {
            int i2 = log + 3;
            getState = i2 % 128;
            boolean z = i2 % 2 == 0;
            getSharedInstance(j);
            if (z) {
                throw new NullPointerException();
            }
            int i3 = getState + 107;
            log = i3 % 128;
            if (i3 % 2 == 0) {
                return;
            }
            throw new NullPointerException();
        }
        int i4 = (int) j;
        this.parseResponseHeaders = i4;
        this.checkCertificates = i4 * i;
        this.APIGuard$Callback = i ^ i4;
        this.updateKernel = (int) (j >> 32);
        getState = (log + 63) % 128;
    }

    private void getSharedInstance(long j) {
        int i = (log + 21) % 128;
        getState = i;
        this.parseResponseHeaders = (int) j;
        long j2 = j >> 3;
        long j3 = getSharedInstance;
        this.checkCertificates = (int) ((j3 * j2) >> 32);
        this.APIGuard$Callback = (int) (j >> 32);
        this.updateKernel = (int) (j2 + j3);
        int i2 = i + 85;
        log = i2 % 128;
        if ((i2 % 2 == 0 ? 'J' : (char) 21) == 'J') {
            return;
        }
        throw new ArithmeticException();
    }

    private void APIGuard() {
        if ((this.generateHeaders == 3 ? '^' : Typography.less) != '<') {
            log = (getState + 27) % 128;
            byte[] bArr = this.valueOf;
            System.arraycopy(bArr, 0, this.AGState, 0, bArr.length);
        }
        byte[] bArr2 = this.valueOf;
        int i = ((bArr2[0] << Ascii.CAN) & (-16777216)) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i2 = ((-16777216) & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        log = (getState + 43) % 128;
        int i3 = 0;
        while (true) {
            int i4 = this.analyzeResponse;
            if (!(i3 < i4)) {
                break;
            }
            int i5 = (i4 - i3) * getSharedInstance;
            i2 -= ((i5 + i) ^ ((i << 4) + this.APIGuard$Callback)) ^ ((i >>> 5) + this.updateKernel);
            i -= ((i5 + i2) ^ ((i2 << 4) + this.parseResponseHeaders)) ^ ((i2 >>> 5) + this.checkCertificates);
            i3++;
            log = (getState + 11) % 128;
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
        if ((this.generateHeaders == 3 ? '*' : ':') == '*') {
            values();
            byte[] bArr4 = this.AGState;
            System.arraycopy(bArr4, 0, this.APIGuard, 0, bArr4.length);
            log = (getState + 37) % 128;
        }
    }

    private void values() {
        log = (getState + 85) % 128;
        int i = 0;
        while (true) {
            if (!(i < 8)) {
                return;
            }
            byte[] bArr = this.valueOf;
            bArr[i] = (byte) (bArr[i] ^ this.APIGuard[i]);
            i++;
            log = (getState + 63) % 128;
        }
    }

    private int AGState() throws IOException {
        if (this.initialize == Integer.MAX_VALUE) {
            this.initialize = ((FilterInputStream) this).in.read();
        }
        if (!(this.values != 8)) {
            int i = (log + 85) % 128;
            getState = i;
            byte[] bArr = this.valueOf;
            int i2 = this.initialize;
            bArr[0] = (byte) i2;
            if (i2 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            log = (i + 109) % 128;
            int i3 = 1;
            do {
                int read = ((FilterInputStream) this).in.read(this.valueOf, i3, 8 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } while (!(i3 >= 8));
            if (i3 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            APIGuard();
            int read2 = ((FilterInputStream) this).in.read();
            this.initialize = read2;
            this.values = 0;
            this.getRequestHeaders = !(read2 >= 0) ? 8 - (this.valueOf[7] & 255) : 8;
        }
        return this.getRequestHeaders;
    }
}
