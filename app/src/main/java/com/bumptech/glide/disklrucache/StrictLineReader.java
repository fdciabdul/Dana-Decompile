package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class StrictLineReader implements Closeable {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final Charset MyBillsEntityDataFactory;
    private final InputStream PlaceComponentResult;
    private byte[] getAuthRequestContext;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private StrictLineReader(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(Util.MyBillsEntityDataFactory)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.PlaceComponentResult = inputStream;
        this.MyBillsEntityDataFactory = charset;
        this.getAuthRequestContext = new byte[8192];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.PlaceComponentResult) {
            if (this.getAuthRequestContext != null) {
                this.getAuthRequestContext = null;
                this.PlaceComponentResult.close();
            }
        }
    }

    public final String getAuthRequestContext() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.PlaceComponentResult) {
            if (this.getAuthRequestContext == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.BuiltInFictitiousFunctionClassFactory >= this.KClassImpl$Data$declaredNonStaticMembers$2) {
                MyBillsEntityDataFactory();
            }
            for (int i3 = this.BuiltInFictitiousFunctionClassFactory; i3 != this.KClassImpl$Data$declaredNonStaticMembers$2; i3++) {
                byte[] bArr2 = this.getAuthRequestContext;
                if (bArr2[i3] == 10) {
                    int i4 = this.BuiltInFictitiousFunctionClassFactory;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] == 13) {
                            String str = new String(bArr2, i4, i2 - i4, this.MyBillsEntityDataFactory.name());
                            this.BuiltInFictitiousFunctionClassFactory = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    String str2 = new String(bArr2, i4, i2 - i4, this.MyBillsEntityDataFactory.name());
                    this.BuiltInFictitiousFunctionClassFactory = i3 + 1;
                    return str2;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.KClassImpl$Data$declaredNonStaticMembers$2 - this.BuiltInFictitiousFunctionClassFactory) + 80) { // from class: com.bumptech.glide.disklrucache.StrictLineReader.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, StrictLineReader.this.MyBillsEntityDataFactory.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr3 = this.getAuthRequestContext;
                int i5 = this.BuiltInFictitiousFunctionClassFactory;
                byteArrayOutputStream.write(bArr3, i5, this.KClassImpl$Data$declaredNonStaticMembers$2 - i5);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
                MyBillsEntityDataFactory();
                i = this.BuiltInFictitiousFunctionClassFactory;
                while (i != this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    bArr = this.getAuthRequestContext;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.BuiltInFictitiousFunctionClassFactory;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.BuiltInFictitiousFunctionClassFactory = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 == -1;
    }

    private void MyBillsEntityDataFactory() throws IOException {
        InputStream inputStream = this.PlaceComponentResult;
        byte[] bArr = this.getAuthRequestContext;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = read;
    }
}
