package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    private final ArrayPool BuiltInFictitiousFunctionClassFactory;
    public volatile byte[] KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    public int getAuthRequestContext;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool) {
        this(inputStream, arrayPool, (byte) 0);
    }

    private RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool, byte b) {
        super(inputStream);
        this.MyBillsEntityDataFactory = -1;
        this.BuiltInFictitiousFunctionClassFactory = arrayPool;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (byte[]) arrayPool.KClassImpl$Data$declaredNonStaticMembers$2(65536, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i;
        int i2;
        int available;
        synchronized (this) {
            InputStream inputStream = this.in;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null && inputStream != null) {
                i = this.PlaceComponentResult;
                i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                available = inputStream.available();
            } else {
                throw new IOException("BufferedInputStream is closed");
            }
        }
        return (i - i2) + available;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ArrayPool) this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ArrayPool) this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int PlaceComponentResult(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.MyBillsEntityDataFactory;
        if (i != -1) {
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = this.getAuthRequestContext;
            if (i2 - i < i3) {
                if (i == 0 && i3 > bArr.length && this.PlaceComponentResult == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = bArr2;
                    this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ArrayPool) bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - this.MyBillsEntityDataFactory;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i4;
                this.MyBillsEntityDataFactory = 0;
                this.PlaceComponentResult = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (read > 0) {
                    i5 += read;
                }
                this.PlaceComponentResult = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.MyBillsEntityDataFactory = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
            this.PlaceComponentResult = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            this.getAuthRequestContext = Math.max(this.getAuthRequestContext, i);
            this.MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        synchronized (this) {
            byte[] bArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            InputStream inputStream = this.in;
            if (bArr != null && inputStream != null) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 < this.PlaceComponentResult || PlaceComponentResult(inputStream, bArr) != -1) {
                    if (bArr != this.KClassImpl$Data$declaredNonStaticMembers$2 && (bArr = this.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                        throw new IOException("BufferedInputStream is closed");
                    }
                    int i = this.PlaceComponentResult;
                    int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (i - i2 > 0) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 + 1;
                        return bArr[i2] & 255;
                    }
                    return -1;
                }
                return -1;
            }
            throw new IOException("BufferedInputStream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        synchronized (this) {
            byte[] bArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (bArr2 == null) {
                throw new IOException("BufferedInputStream is closed");
            }
            if (i2 == 0) {
                return 0;
            }
            InputStream inputStream = this.in;
            if (inputStream != null) {
                int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int i6 = this.PlaceComponentResult;
                if (i5 < i6) {
                    int i7 = i6 - i5;
                    if (i7 >= i2) {
                        i7 = i2;
                    }
                    System.arraycopy(bArr2, i5, bArr, i, i7);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 += i7;
                    if (i7 == i2 || inputStream.available() == 0) {
                        return i7;
                    }
                    i += i7;
                    i3 = i2 - i7;
                } else {
                    i3 = i2;
                }
                while (true) {
                    if (this.MyBillsEntityDataFactory == -1 && i3 >= bArr2.length) {
                        i4 = inputStream.read(bArr, i, i3);
                        if (i4 == -1) {
                            return i3 != i2 ? i2 - i3 : -1;
                        }
                    } else if (PlaceComponentResult(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    } else {
                        if (bArr2 != this.KClassImpl$Data$declaredNonStaticMembers$2 && (bArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                            throw new IOException("BufferedInputStream is closed");
                        }
                        int i8 = this.PlaceComponentResult;
                        int i9 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        i4 = i8 - i9;
                        if (i4 >= i3) {
                            i4 = i3;
                        }
                        System.arraycopy(bArr2, i9, bArr, i, i4);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 += i4;
                    }
                    i3 -= i4;
                    if (i3 == 0) {
                        return i2;
                    }
                    if (inputStream.available() == 0) {
                        return i2 - i3;
                    }
                    i += i4;
                }
            } else {
                throw new IOException("BufferedInputStream is closed");
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                throw new IOException("Stream is closed");
            }
            int i = this.MyBillsEntityDataFactory;
            if (-1 == i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Mark has been invalidated, pos: ");
                sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                sb.append(" markLimit: ");
                sb.append(this.getAuthRequestContext);
                throw new InvalidMarkException(sb.toString());
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        synchronized (this) {
            if (j < 1) {
                return 0L;
            }
            byte[] bArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (bArr != null) {
                InputStream inputStream = this.in;
                if (inputStream != null) {
                    int i = this.PlaceComponentResult;
                    int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (i - i2 >= j) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (int) (i2 + j);
                        return j;
                    }
                    long j2 = i - i2;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
                    if (this.MyBillsEntityDataFactory != -1 && j <= this.getAuthRequestContext) {
                        if (PlaceComponentResult(inputStream, bArr) == -1) {
                            return j2;
                        }
                        int i3 = this.PlaceComponentResult;
                        int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (i3 - i4 >= j - j2) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (int) ((i4 + j) - j2);
                            return j;
                        }
                        long j3 = i3;
                        long j4 = i4;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
                        return (j2 + j3) - j4;
                    }
                    long skip = inputStream.skip(j - j2);
                    if (skip > 0) {
                        this.MyBillsEntityDataFactory = -1;
                    }
                    return j2 + skip;
                }
                throw new IOException("BufferedInputStream is closed");
            }
            throw new IOException("BufferedInputStream is closed");
        }
    }

    /* loaded from: classes3.dex */
    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }
}
