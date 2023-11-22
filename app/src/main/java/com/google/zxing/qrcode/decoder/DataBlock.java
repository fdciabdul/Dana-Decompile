package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;

/* loaded from: classes3.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int i = 0;
        for (Version.ECB ecb : eCBlocks) {
            i += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i];
        int i2 = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i3 = 0;
            while (i3 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i2] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i3++;
                i2++;
            }
        }
        int length = dataBlockArr[0].codewords.length;
        do {
            i--;
            if (i < 0) {
                break;
            }
        } while (dataBlockArr[i].codewords.length != length);
        int i4 = i + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i5 = 0;
        for (int i6 = 0; i6 < eCCodewordsPerBlock; i6++) {
            int i7 = 0;
            while (i7 < i2) {
                dataBlockArr[i7].codewords[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i2) {
            dataBlockArr[i8].codewords[eCCodewordsPerBlock] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (eCCodewordsPerBlock < length2) {
            int i9 = 0;
            while (i9 < i2) {
                dataBlockArr[i9].codewords[i9 < i4 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i5];
                i9++;
                i5++;
            }
            eCCodewordsPerBlock++;
        }
        return dataBlockArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] getCodewords() {
        return this.codewords;
    }
}
