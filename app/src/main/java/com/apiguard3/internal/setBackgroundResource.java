package com.apiguard3.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setBackgroundResource extends FilterInputStream {
    private static int APIGuard$Callback = 1;
    private static int getState;
    private byte[] AGState;
    private byte[] APIGuard;
    private int analyzeResponse;
    private int[] generateHeaders;
    private int getRequestHeaders;
    private setBackgroundColor getSharedInstance;
    private int initialize;
    private int parseResponseHeaders;
    private final int valueOf;
    private byte[] values;

    public setBackgroundResource(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) throws IOException {
        super(inputStream);
        this.analyzeResponse = Integer.MAX_VALUE;
        int min = Math.min(Math.max(i, 3), 16);
        this.valueOf = min;
        this.AGState = new byte[8];
        byte[] bArr2 = new byte[8];
        this.values = bArr2;
        this.APIGuard = new byte[8];
        this.generateHeaders = new int[2];
        this.initialize = 8;
        this.getRequestHeaders = 8;
        this.parseResponseHeaders = i2;
        if (i2 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.getSharedInstance = new setBackgroundColor(iArr, min, true, z);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        APIGuard$Callback = (getState + 41) % 128;
        APIGuard();
        int i = this.initialize;
        if (i < this.getRequestHeaders) {
            byte[] bArr = this.AGState;
            this.initialize = i + 1;
            byte b = bArr[i];
            getState = (APIGuard$Callback + 85) % 128;
            return b & 255;
        }
        int i2 = getState + 111;
        APIGuard$Callback = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        APIGuard$Callback = (getState + 77) % 128;
        int i3 = i + i2;
        int i4 = i;
        while (true) {
            if (i4 < i3) {
                APIGuard();
                int i5 = this.initialize;
                if ((i5 >= this.getRequestHeaders ? (char) 22 : '\'') != '\'') {
                    if ((i4 == i ? 'c' : 'a') != 'c') {
                        return i2 - (i3 - i4);
                    }
                    APIGuard$Callback = (getState + 47) % 128;
                    return -1;
                }
                byte[] bArr2 = this.AGState;
                this.initialize = i5 + 1;
                bArr[i4] = bArr2[i5];
                i4++;
            } else {
                getState = (APIGuard$Callback + 63) % 128;
                return i2;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        getState = (APIGuard$Callback + 87) % 128;
        long j2 = 0;
        while (true) {
            if ((j2 < j ? Typography.amp : ';') != '&') {
                break;
            }
            int i = getState + 103;
            APIGuard$Callback = i % 128;
            if (!(i % 2 == 0)) {
                if (read() == -1) {
                    break;
                }
                getState = (APIGuard$Callback + 71) % 128;
                j2++;
            } else {
                read();
                throw new NullPointerException();
            }
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        int i;
        int i2 = getState + 77;
        APIGuard$Callback = i2 % 128;
        if (!(i2 % 2 != 0)) {
            APIGuard();
            i = this.getRequestHeaders << this.initialize;
        } else {
            APIGuard();
            i = this.getRequestHeaders - this.initialize;
        }
        APIGuard$Callback = (getState + 29) % 128;
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        getState = (APIGuard$Callback + 69) % 128;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        if ((r26.parseResponseHeaders != 2) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        com.apiguard3.internal.setBackgroundResource.getState = (r2 + 17) % 128;
        r1 = r26.AGState;
        java.lang.System.arraycopy(r1, 0, r26.APIGuard, 0, r1.length);
        com.apiguard3.internal.setBackgroundResource.APIGuard$Callback = (com.apiguard3.internal.setBackgroundResource.getState + 91) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if ((r26.parseResponseHeaders == 4 ? '%' : 'H') != 'H') goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getSharedInstance() {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setBackgroundResource.getSharedInstance():void");
    }

    private void valueOf() {
        int i = (getState + 45) % 128;
        APIGuard$Callback = i;
        getState = (i + 121) % 128;
        int i2 = 0;
        while (true) {
            if (i2 >= 8) {
                return;
            }
            byte[] bArr = this.AGState;
            bArr[i2] = (byte) (bArr[i2] ^ this.values[i2]);
            i2++;
        }
    }

    private int APIGuard() throws IOException {
        int i = APIGuard$Callback;
        int i2 = i + 27;
        getState = i2 % 128;
        if (i2 % 2 == 0) {
            if (this.analyzeResponse == Integer.MAX_VALUE) {
                int i3 = i + 47;
                getState = i3 % 128;
                if (i3 % 2 != 0) {
                    this.analyzeResponse = ((FilterInputStream) this).in.read();
                    throw new ArithmeticException();
                }
                this.analyzeResponse = ((FilterInputStream) this).in.read();
            }
            if (this.initialize == 8) {
                byte[] bArr = this.AGState;
                int i4 = this.analyzeResponse;
                bArr[0] = (byte) i4;
                if (i4 < 0) {
                    throw new IllegalStateException("unexpected block size");
                }
                int i5 = 1;
                do {
                    int read = ((FilterInputStream) this).in.read(this.AGState, i5, 8 - i5);
                    if (!(read > 0)) {
                        break;
                    }
                    i5 += read;
                } while (i5 < 8);
                if (i5 < 8) {
                    throw new IllegalStateException("unexpected block size");
                }
                getSharedInstance();
                int read2 = ((FilterInputStream) this).in.read();
                this.analyzeResponse = read2;
                this.initialize = 0;
                this.getRequestHeaders = read2 < 0 ? 8 - (this.AGState[7] & 255) : 8;
                getState = (APIGuard$Callback + 125) % 128;
            }
            return this.getRequestHeaders;
        }
        throw null;
    }
}
