package o;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class PrepareContext extends FilterInputStream {
    private byte[] BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private byte[] MyBillsEntityDataFactory;
    private int[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private NetworkUserEntityData$$ExternalSyntheticLambda5 PlaceComponentResult;
    private byte[] getAuthRequestContext;
    private int getErrorConfigVersion;
    private int lookAheadTest;
    private int moveToNextValue;
    private int scheduleImpl;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public PrepareContext(InputStream inputStream, int[] iArr, byte[] bArr, int i, boolean z, int i2) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.moveToNextValue = Integer.MAX_VALUE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Math.min(Math.max(i, 3), 16);
        this.BuiltInFictitiousFunctionClassFactory = new byte[8];
        byte[] bArr2 = new byte[8];
        this.MyBillsEntityDataFactory = bArr2;
        this.getAuthRequestContext = new byte[8];
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new int[2];
        this.scheduleImpl = 8;
        this.getErrorConfigVersion = 8;
        this.lookAheadTest = i2;
        if (i2 == 2) {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        this.PlaceComponentResult = new NetworkUserEntityData$$ExternalSyntheticLambda5(iArr, this.KClassImpl$Data$declaredNonStaticMembers$2, true, z);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        KClassImpl$Data$declaredNonStaticMembers$2();
        int i = this.scheduleImpl;
        if (i >= this.getErrorConfigVersion) {
            return -1;
        }
        byte[] bArr = this.BuiltInFictitiousFunctionClassFactory;
        this.scheduleImpl = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            int i5 = this.scheduleImpl;
            if (i5 >= this.getErrorConfigVersion) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.BuiltInFictitiousFunctionClassFactory;
            this.scheduleImpl = i5 + 1;
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
        KClassImpl$Data$declaredNonStaticMembers$2();
        return this.getErrorConfigVersion - this.scheduleImpl;
    }

    private void PlaceComponentResult() {
        if (this.lookAheadTest == 2) {
            byte[] bArr = this.BuiltInFictitiousFunctionClassFactory;
            System.arraycopy(bArr, 0, this.getAuthRequestContext, 0, bArr.length);
        }
        byte[] bArr2 = this.BuiltInFictitiousFunctionClassFactory;
        NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext(((bArr2[0] << Ascii.CAN) & (-16777216)) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255), ((-16777216) & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255), false, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i = iArr[0];
        int i2 = iArr[1];
        byte[] bArr3 = this.BuiltInFictitiousFunctionClassFactory;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.lookAheadTest == 2) {
            for (int i3 = 0; i3 < 8; i3++) {
                byte[] bArr4 = this.BuiltInFictitiousFunctionClassFactory;
                bArr4[i3] = (byte) (bArr4[i3] ^ this.MyBillsEntityDataFactory[i3]);
            }
            byte[] bArr5 = this.getAuthRequestContext;
            System.arraycopy(bArr5, 0, this.MyBillsEntityDataFactory, 0, bArr5.length);
        }
    }

    private int KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        if (this.moveToNextValue == Integer.MAX_VALUE) {
            this.moveToNextValue = this.in.read();
        }
        if (this.scheduleImpl == 8) {
            byte[] bArr = this.BuiltInFictitiousFunctionClassFactory;
            int i = this.moveToNextValue;
            bArr[0] = (byte) i;
            if (i < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i2 = 1;
            do {
                int read = this.in.read(this.BuiltInFictitiousFunctionClassFactory, i2, 8 - i2);
                if (read <= 0) {
                    break;
                }
                i2 += read;
            } while (i2 < 8);
            if (i2 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            PlaceComponentResult();
            int read2 = this.in.read();
            this.moveToNextValue = read2;
            this.scheduleImpl = 0;
            this.getErrorConfigVersion = read2 < 0 ? 8 - (this.BuiltInFictitiousFunctionClassFactory[7] & 255) : 8;
        }
        return this.getErrorConfigVersion;
    }
}
