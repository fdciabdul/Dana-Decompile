package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class BufferedOutputStream extends OutputStream {
    private ArrayPool BuiltInFictitiousFunctionClassFactory;
    private byte[] MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    private final OutputStream getAuthRequestContext;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool) {
        this(outputStream, arrayPool, (byte) 0);
    }

    private BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool, byte b) {
        this.getAuthRequestContext = outputStream;
        this.BuiltInFictitiousFunctionClassFactory = arrayPool;
        this.MyBillsEntityDataFactory = (byte[]) arrayPool.KClassImpl$Data$declaredNonStaticMembers$2(65536, byte[].class);
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        byte[] bArr = this.MyBillsEntityDataFactory;
        int i2 = this.PlaceComponentResult;
        this.PlaceComponentResult = i2 + 1;
        bArr[i2] = (byte) i;
        getAuthRequestContext();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.PlaceComponentResult;
            if (i6 == 0 && i4 >= this.MyBillsEntityDataFactory.length) {
                this.getAuthRequestContext.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.MyBillsEntityDataFactory.length - i6);
            System.arraycopy(bArr, i5, this.MyBillsEntityDataFactory, this.PlaceComponentResult, min);
            this.PlaceComponentResult += min;
            i3 += min;
            getAuthRequestContext();
        } while (i3 < i2);
    }

    private void getAuthRequestContext() throws IOException {
        int i = this.PlaceComponentResult;
        byte[] bArr = this.MyBillsEntityDataFactory;
        if (i != bArr.length || i <= 0) {
            return;
        }
        this.getAuthRequestContext.write(bArr, 0, i);
        this.PlaceComponentResult = 0;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            flush();
            this.getAuthRequestContext.close();
            byte[] bArr = this.MyBillsEntityDataFactory;
            if (bArr != null) {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ArrayPool) bArr);
                this.MyBillsEntityDataFactory = null;
            }
        } catch (Throwable th) {
            this.getAuthRequestContext.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.PlaceComponentResult;
        if (i > 0) {
            this.getAuthRequestContext.write(this.MyBillsEntityDataFactory, 0, i);
            this.PlaceComponentResult = 0;
        }
        this.getAuthRequestContext.flush();
    }
}
