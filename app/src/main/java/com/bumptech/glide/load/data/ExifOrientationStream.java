package com.bumptech.glide.load.data;

import com.google.common.base.Ascii;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {-1, -31, 0, Ascii.FS, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    private static final int MyBillsEntityDataFactory = 29;
    private static final int getAuthRequestContext = 31;
    private final byte BuiltInFictitiousFunctionClassFactory;
    private int PlaceComponentResult;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot add invalid orientation: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        this.BuiltInFictitiousFunctionClassFactory = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read;
        int i;
        int i2 = this.PlaceComponentResult;
        if (i2 < 2 || i2 > (i = getAuthRequestContext)) {
            read = super.read();
        } else if (i2 == i) {
            read = this.BuiltInFictitiousFunctionClassFactory;
        } else {
            read = KClassImpl$Data$declaredNonStaticMembers$2[i2 - 2] & 255;
        }
        if (read != -1) {
            this.PlaceComponentResult++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.PlaceComponentResult;
        int i5 = getAuthRequestContext;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.BuiltInFictitiousFunctionClassFactory;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.PlaceComponentResult += i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.PlaceComponentResult = (int) (this.PlaceComponentResult + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
