package o;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class isLayoutRequested extends FilterInputStream {
    private byte[] BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private long[] MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private long[] PlaceComponentResult;
    private short getAuthRequestContext;
    private int getErrorConfigVersion;
    private int lookAheadTest;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public isLayoutRequested(InputStream inputStream, int i, int i2, short s, int i3, int i4) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.getErrorConfigVersion = Integer.MAX_VALUE;
        int min = Math.min(Math.max((int) s, 4), 8);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = min;
        this.BuiltInFictitiousFunctionClassFactory = new byte[min];
        this.PlaceComponentResult = new long[4];
        this.MyBillsEntityDataFactory = new long[4];
        this.lookAheadTest = min;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = min;
        this.PlaceComponentResult = NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult(i ^ i4, min ^ i4);
        this.MyBillsEntityDataFactory = NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult(i2 ^ i4, i3 ^ i4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        MyBillsEntityDataFactory();
        int i = this.lookAheadTest;
        if (i >= this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return -1;
        }
        byte[] bArr = this.BuiltInFictitiousFunctionClassFactory;
        this.lookAheadTest = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            MyBillsEntityDataFactory();
            int i5 = this.lookAheadTest;
            if (i5 >= this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.BuiltInFictitiousFunctionClassFactory;
            this.lookAheadTest = i5 + 1;
            bArr[i4] = bArr2[i5];
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        MyBillsEntityDataFactory();
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 - this.lookAheadTest;
    }

    private void getAuthRequestContext() {
        NetworkUserEntityData$$ExternalSyntheticLambda4.MyBillsEntityDataFactory(this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.getAuthRequestContext);
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
            this.BuiltInFictitiousFunctionClassFactory[i] = (byte) (r1[i] ^ ((this.PlaceComponentResult[this.getAuthRequestContext] >> (i * 8)) & 255));
        }
        this.getAuthRequestContext = (short) ((this.getAuthRequestContext + 1) % 4);
    }

    private int MyBillsEntityDataFactory() throws IOException {
        int i;
        if (this.getErrorConfigVersion == Integer.MAX_VALUE) {
            this.getErrorConfigVersion = this.in.read();
        }
        if (this.lookAheadTest == this.KClassImpl$Data$declaredNonStaticMembers$2) {
            byte[] bArr = this.BuiltInFictitiousFunctionClassFactory;
            int i2 = this.getErrorConfigVersion;
            bArr[0] = (byte) i2;
            if (i2 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i3 = 1;
            do {
                int read = this.in.read(this.BuiltInFictitiousFunctionClassFactory, i3, this.KClassImpl$Data$declaredNonStaticMembers$2 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } while (i3 < this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (i3 < this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new IllegalStateException("unexpected block size");
            }
            getAuthRequestContext();
            int read2 = this.in.read();
            this.getErrorConfigVersion = read2;
            this.lookAheadTest = 0;
            if (read2 < 0) {
                int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                i = i4 - (this.BuiltInFictitiousFunctionClassFactory[i4 - 1] & 255);
            } else {
                i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
