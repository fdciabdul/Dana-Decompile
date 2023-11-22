package com.alipay.iap.android.aplog.util.zip;

import java.io.IOException;

/* loaded from: classes3.dex */
public class LZ_BinTree extends LZ_InWindow {
    private static final int[] CrcTable = new int[256];
    static final int kBT2HashSize = 65536;
    static final int kEmptyHashValue = 0;
    static final int kHash2Size = 1024;
    static final int kHash3Offset = 1024;
    static final int kHash3Size = 65536;
    static final int kMaxValForNormalize = 1073741823;
    static final int kStartMaxLen = 1;
    int _cyclicBufferPos;
    int[] _hash;
    int _hashMask;
    int _matchMaxLen;
    int[] _son;
    int _cyclicBufferSize = 0;
    int _cutValue = 255;
    int _hashSizeSum = 0;
    boolean HASH_ARRAY = true;
    int kNumHashDirectBytes = 0;
    int kMinMatchCheck = 4;
    int kFixHashSize = 66560;

    public void SetType(int i) {
        boolean z = i > 2;
        this.HASH_ARRAY = z;
        if (z) {
            this.kNumHashDirectBytes = 0;
            this.kMinMatchCheck = 4;
            this.kFixHashSize = 66560;
            return;
        }
        this.kNumHashDirectBytes = 2;
        this.kMinMatchCheck = 3;
        this.kFixHashSize = 0;
    }

    @Override // com.alipay.iap.android.aplog.util.zip.LZ_InWindow
    public void Init() throws IOException {
        super.Init();
        for (int i = 0; i < this._hashSizeSum; i++) {
            this._hash[i] = 0;
        }
        this._cyclicBufferPos = 0;
        ReduceOffsets(-1);
    }

    @Override // com.alipay.iap.android.aplog.util.zip.LZ_InWindow
    public void MovePos() throws IOException {
        int i = this._cyclicBufferPos + 1;
        this._cyclicBufferPos = i;
        if (i >= this._cyclicBufferSize) {
            this._cyclicBufferPos = 0;
        }
        super.MovePos();
        if (this._pos == kMaxValForNormalize) {
            Normalize();
        }
    }

    public boolean Create(int i, int i2, int i3, int i4) {
        if (i > 1073741567) {
            return false;
        }
        this._cutValue = (i3 >> 1) + 16;
        int i5 = i2 + i;
        super.Create(i5, i4 + i3, (((i5 + i3) + i4) / 2) + 256);
        this._matchMaxLen = i3;
        int i6 = i + 1;
        if (this._cyclicBufferSize != i6) {
            this._cyclicBufferSize = i6;
            this._son = new int[i6 * 2];
        }
        int i7 = 65536;
        if (this.HASH_ARRAY) {
            int i8 = i - 1;
            int i9 = i8 | (i8 >> 1);
            int i10 = i9 | (i9 >> 2);
            int i11 = i10 | (i10 >> 4);
            int i12 = ((i11 | (i11 >> 8)) >> 1) | 65535;
            if (i12 > 16777216) {
                i12 >>= 1;
            }
            this._hashMask = i12;
            i7 = this.kFixHashSize + i12 + 1;
        }
        if (i7 != this._hashSizeSum) {
            this._hashSizeSum = i7;
            this._hash = new int[i7];
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140 A[LOOP:1: B:52:0x0140->B:56:0x0155, LOOP_START, PHI: r10 r16
      0x0140: PHI (r10v13 int) = (r10v4 int), (r10v16 int) binds: [B:51:0x013e, B:56:0x0155] A[DONT_GENERATE, DONT_INLINE]
      0x0140: PHI (r16v2 int) = (r16v0 int), (r16v7 int) binds: [B:51:0x013e, B:56:0x0155] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int GetMatches(int[] r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.zip.LZ_BinTree.GetMatches(int[]):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c0, code lost:
    
        if (r17._bufferBase[r13 + r14] == r17._bufferBase[r4 + r14]) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c2, code lost:
    
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c4, code lost:
    
        if (r14 == r2) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d2, code lost:
    
        if (r17._bufferBase[r13 + r14] == r17._bufferBase[r4 + r14]) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d4, code lost:
    
        if (r14 != r2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d6, code lost:
    
        r2 = r17._son;
        r2[r7] = r2[r12];
        r2[r8] = r2[r12 + 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f2, code lost:
    
        if ((r17._bufferBase[r13 + r14] & 255) >= (r17._bufferBase[r4 + r14] & 255)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f4, code lost:
    
        r5 = r17._son;
        r5[r7] = r6;
        r12 = r12 + 1;
        r6 = r5[r12];
        r7 = r12;
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0100, code lost:
    
        r5 = r17._son;
        r5[r8] = r6;
        r6 = r5[r12];
        r8 = r12;
        r9 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0109, code lost:
    
        r11 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r2 >= r17.kMinMatchCheck) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Skip(int r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.zip.LZ_BinTree.Skip(int):void");
    }

    void NormalizeLinks(int[] iArr, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            iArr[i3] = i4 <= i2 ? 0 : i4 - i2;
        }
    }

    void Normalize() {
        int i = this._pos;
        int i2 = this._cyclicBufferSize;
        int i3 = i - i2;
        NormalizeLinks(this._son, i2 * 2, i3);
        NormalizeLinks(this._hash, this._hashSizeSum, i3);
        ReduceOffsets(i3);
    }

    public void SetCutValue(int i) {
        this._cutValue = i;
    }

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i2 & 1;
                i2 >>>= 1;
                if (i4 != 0) {
                    i2 ^= -306674912;
                }
            }
            CrcTable[i] = i2;
        }
    }
}
