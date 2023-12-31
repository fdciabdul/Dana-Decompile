package com.alipay.iap.android.aplog.util.zip;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class LZ_OutWindow {
    byte[] _buffer;
    int _pos;
    OutputStream _stream;
    int _streamPos;
    int _windowSize = 0;

    public void Create(int i) {
        if (this._buffer == null || this._windowSize != i) {
            this._buffer = new byte[i];
        }
        this._windowSize = i;
        this._pos = 0;
        this._streamPos = 0;
    }

    public void SetStream(OutputStream outputStream) throws IOException {
        ReleaseStream();
        this._stream = outputStream;
    }

    public void ReleaseStream() throws IOException {
        Flush();
        this._stream = null;
    }

    public void Init(boolean z) {
        if (z) {
            return;
        }
        this._streamPos = 0;
        this._pos = 0;
    }

    public void Flush() throws IOException {
        int i = this._pos;
        int i2 = this._streamPos;
        int i3 = i - i2;
        if (i3 == 0) {
            return;
        }
        this._stream.write(this._buffer, i2, i3);
        if (this._pos >= this._windowSize) {
            this._pos = 0;
        }
        this._streamPos = this._pos;
    }

    public void CopyBlock(int i, int i2) throws IOException {
        int i3 = (this._pos - i) - 1;
        if (i3 < 0) {
            i3 += this._windowSize;
        }
        while (i2 != 0) {
            int i4 = this._windowSize;
            if (i3 >= i4) {
                i3 = 0;
            }
            byte[] bArr = this._buffer;
            int i5 = this._pos;
            int i6 = i5 + 1;
            this._pos = i6;
            bArr[i5] = bArr[i3];
            if (i6 >= i4) {
                Flush();
            }
            i2--;
            i3++;
        }
    }

    public void PutByte(byte b) throws IOException {
        byte[] bArr = this._buffer;
        int i = this._pos;
        int i2 = i + 1;
        this._pos = i2;
        bArr[i] = b;
        if (i2 >= this._windowSize) {
            Flush();
        }
    }

    public byte GetByte(int i) {
        int i2 = (this._pos - i) - 1;
        if (i2 < 0) {
            i2 += this._windowSize;
        }
        return this._buffer[i2];
    }
}
