package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes8.dex */
public class ew extends ey {
    protected InputStream BuiltInFictitiousFunctionClassFactory;
    protected OutputStream getAuthRequestContext;

    protected ew() {
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext = null;
    }

    public ew(OutputStream outputStream) {
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext = outputStream;
    }

    @Override // com.xiaomi.push.ey
    public final void MyBillsEntityDataFactory(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.getAuthRequestContext;
        if (outputStream == null) {
            throw new ez(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new ez(0, e);
        }
    }

    @Override // com.xiaomi.push.ey
    public final int getAuthRequestContext(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.BuiltInFictitiousFunctionClassFactory;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new ez(4);
            } catch (IOException e) {
                throw new ez(0, e);
            }
        }
        throw new ez(1, "Cannot read from null inputStream");
    }
}
