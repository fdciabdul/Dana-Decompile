package o;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class NetworkUserEntityData$$ExternalSyntheticLambda6 extends FilterInputStream {
    private int GetContactSyncConfig;
    private final int[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final byte[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final int getErrorConfigVersion;
    private int initRecordTimeStamp;
    private final byte[][] lookAheadTest;
    private final int[] moveToNextValue;
    private final byte[] scheduleImpl;
    private static final byte[] BuiltInFictitiousFunctionClassFactory = FragmentBottomSheetPaymentSettingBinding.MyBillsEntityDataFactory;
    private static final int[] MyBillsEntityDataFactory = FragmentBottomSheetPaymentSettingBinding.KClassImpl$Data$declaredNonStaticMembers$2;
    private static final int[] getAuthRequestContext = FragmentBottomSheetPaymentSettingBinding.getAuthRequestContext;
    private static final int[] PlaceComponentResult = FragmentBottomSheetPaymentSettingBinding.BuiltInFictitiousFunctionClassFactory;
    private static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = FragmentBottomSheetPaymentSettingBinding.lookAheadTest;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public NetworkUserEntityData$$ExternalSyntheticLambda6(InputStream inputStream, int i, byte[] bArr, byte[][] bArr2) {
        super(new BufferedInputStream(inputStream, 4096));
        this.moveToNextValue = new int[4];
        this.scheduleImpl = new byte[16];
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new byte[16];
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Integer.MAX_VALUE;
        this.GetContactSyncConfig = 16;
        this.initRecordTimeStamp = 16;
        this.getErrorConfigVersion = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FragmentBottomSheetPaymentSettingBinding.BuiltInFictitiousFunctionClassFactory(bArr, i);
        this.lookAheadTest = PlaceComponentResult(bArr2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        PlaceComponentResult();
        int i = this.GetContactSyncConfig;
        if (i >= this.initRecordTimeStamp) {
            return -1;
        }
        byte[] bArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.GetContactSyncConfig = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            PlaceComponentResult();
            int i5 = this.GetContactSyncConfig;
            if (i5 >= this.initRecordTimeStamp) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            this.GetContactSyncConfig = i5 + 1;
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
        PlaceComponentResult();
        return this.initRecordTimeStamp - this.GetContactSyncConfig;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
    }

    private static byte[][] PlaceComponentResult(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new byte[bArr[i].length];
            for (int i2 = 0; i2 < bArr[i].length; i2++) {
                bArr2[i][bArr[i][i2]] = (byte) i2;
            }
        }
        return bArr2;
    }

    private int PlaceComponentResult() throws IOException {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == Integer.MAX_VALUE) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.in.read();
        }
        if (this.GetContactSyncConfig == 16) {
            byte[] bArr = this.scheduleImpl;
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            bArr[0] = (byte) i;
            if (i < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i2 = 1;
            do {
                int read = this.in.read(this.scheduleImpl, i2, 16 - i2);
                if (read <= 0) {
                    break;
                }
                i2 += read;
            } while (i2 < 16);
            if (i2 < 16) {
                throw new IllegalStateException("unexpected block size");
            }
            KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            int read2 = this.in.read();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = read2;
            this.GetContactSyncConfig = 0;
            this.initRecordTimeStamp = read2 < 0 ? 16 - (this.NetworkUserEntityData$$ExternalSyntheticLambda1[15] & 255) : 16;
        }
        return this.initRecordTimeStamp;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.moveToNextValue;
        char c = 1;
        int i = (bArr[0] << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        iArr[0] = i ^ iArr2[0];
        iArr[1] = ((((bArr[4] << Ascii.CAN) | ((bArr[5] & 255) << 16)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ iArr2[1];
        iArr[2] = ((((bArr[8] << Ascii.CAN) | ((bArr[9] & 255) << 16)) | ((bArr[10] & 255) << 8)) | (bArr[11] & 255)) ^ iArr2[2];
        iArr[3] = iArr2[3] ^ (((((bArr[13] & 255) << 16) | (bArr[12] << Ascii.CAN)) | ((bArr[14] & 255) << 8)) | (bArr[15] & 255));
        int i2 = 1;
        int i3 = 4;
        while (i2 < this.getErrorConfigVersion) {
            int[] iArr3 = MyBillsEntityDataFactory;
            int[] iArr4 = this.moveToNextValue;
            byte[][] bArr3 = this.lookAheadTest;
            int i4 = iArr3[iArr4[bArr3[0][0]] >>> 24];
            int[] iArr5 = getAuthRequestContext;
            int i5 = i4 ^ iArr5[(iArr4[bArr3[c][0]] >>> 16) & 255];
            int[] iArr6 = PlaceComponentResult;
            int i6 = iArr6[(iArr4[bArr3[2][0]] >>> 8) & 255] ^ i5;
            int[] iArr7 = KClassImpl$Data$declaredNonStaticMembers$2;
            int i7 = iArr7[iArr4[bArr3[3][0]] & 255] ^ i6;
            int[] iArr8 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i8 = i7 ^ iArr8[i3];
            int i9 = ((iArr6[(iArr4[bArr3[2][c]] >>> 8) & 255] ^ (iArr3[iArr4[bArr3[0][c]] >>> 24] ^ iArr5[(iArr4[bArr3[c][c]] >>> 16) & 255])) ^ iArr7[iArr4[bArr3[3][c]] & 255]) ^ iArr8[i3 + 1];
            int i10 = (((iArr5[(iArr4[bArr3[c][2]] >>> 16) & 255] ^ iArr3[iArr4[bArr3[0][2]] >>> 24]) ^ iArr6[(iArr4[bArr3[2][2]] >>> 8) & 255]) ^ iArr7[iArr4[bArr3[3][2]] & 255]) ^ iArr8[i3 + 2];
            int i11 = (((iArr3[iArr4[bArr3[0][3]] >>> 24] ^ iArr5[(iArr4[bArr3[1][3]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr3[2][3]] >>> 8) & 255]) ^ iArr7[iArr4[bArr3[3][3]] & 255]) ^ iArr8[i3 + 3];
            iArr4[0] = i8;
            iArr4[1] = i9;
            iArr4[2] = i10;
            iArr4[3] = i11;
            i2++;
            i3 += 4;
            c = 1;
        }
        int[] iArr9 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i12 = iArr9[i3];
        byte[] bArr4 = BuiltInFictitiousFunctionClassFactory;
        int[] iArr10 = this.moveToNextValue;
        byte[][] bArr5 = this.lookAheadTest;
        bArr2[0] = (byte) (bArr4[iArr10[bArr5[0][0]] >>> 24] ^ (i12 >>> 24));
        bArr2[1] = (byte) (bArr4[(iArr10[bArr5[1][0]] >>> 16) & 255] ^ (i12 >>> 16));
        bArr2[2] = (byte) (bArr4[(iArr10[bArr5[2][0]] >>> 8) & 255] ^ (i12 >>> 8));
        bArr2[3] = (byte) (i12 ^ bArr4[iArr10[bArr5[3][0]] & 255]);
        int i13 = iArr9[i3 + 1];
        bArr2[4] = (byte) (bArr4[iArr10[bArr5[0][1]] >>> 24] ^ (i13 >>> 24));
        bArr2[5] = (byte) (bArr4[(iArr10[bArr5[1][1]] >>> 16) & 255] ^ (i13 >>> 16));
        bArr2[6] = (byte) (bArr4[(iArr10[bArr5[2][1]] >>> 8) & 255] ^ (i13 >>> 8));
        bArr2[7] = (byte) (i13 ^ bArr4[iArr10[bArr5[3][1]] & 255]);
        int i14 = iArr9[i3 + 2];
        bArr2[8] = (byte) (bArr4[iArr10[bArr5[0][2]] >>> 24] ^ (i14 >>> 24));
        bArr2[9] = (byte) (bArr4[(iArr10[bArr5[1][2]] >>> 16) & 255] ^ (i14 >>> 16));
        bArr2[10] = (byte) (bArr4[(iArr10[bArr5[2][2]] >>> 8) & 255] ^ (i14 >>> 8));
        bArr2[11] = (byte) (i14 ^ bArr4[iArr10[bArr5[3][2]] & 255]);
        int i15 = iArr9[i3 + 3];
        bArr2[12] = (byte) (bArr4[iArr10[bArr5[0][3]] >>> 24] ^ (i15 >>> 24));
        bArr2[13] = (byte) (bArr4[(iArr10[bArr5[1][3]] >>> 16) & 255] ^ (i15 >>> 16));
        bArr2[14] = (byte) (bArr4[(iArr10[bArr5[2][3]] >>> 8) & 255] ^ (i15 >>> 8));
        bArr2[15] = (byte) (i15 ^ bArr4[iArr10[bArr5[3][3]] & 255]);
    }
}
