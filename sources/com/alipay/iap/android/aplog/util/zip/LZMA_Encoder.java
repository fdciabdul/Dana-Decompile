package com.alipay.iap.android.aplog.util.zip;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class LZMA_Encoder {
    public static final int EMatchFinderTypeBT2 = 0;
    public static final int EMatchFinderTypeBT4 = 1;
    static byte[] g_FastPos = null;
    static final int kDefaultDictionaryLogSize = 22;
    static final int kIfinityPrice = 268435455;
    static final int kNumFastBytesDefault = 32;
    public static final int kNumLenSpecSymbols = 16;
    static final int kNumOpts = 4096;
    public static final int kPropSize = 5;
    int _additionalOffset;
    int _alignPriceCount;
    boolean _finished;
    InputStream _inStream;
    int _longestMatchLength;
    boolean _longestMatchWasFound;
    int _matchPriceCount;
    int _numDistancePairs;
    int _optimumCurrentIndex;
    int _optimumEndIndex;
    byte _previousByte;
    int backRes;
    long nowPos64;
    int _state = LZMA_Base.StateInit();
    int[] _repDistances = new int[4];
    Optimal[] _optimum = new Optimal[4096];
    LZ_BinTree _matchFinder = null;
    RangeCoder_Encoder _rangeEncoder = new RangeCoder_Encoder();
    short[] _isMatch = new short[192];
    short[] _isRep = new short[12];
    short[] _isRepG0 = new short[12];
    short[] _isRepG1 = new short[12];
    short[] _isRepG2 = new short[12];
    short[] _isRep0Long = new short[192];
    RangeCoder_BitTreeEncoder[] _posSlotEncoder = new RangeCoder_BitTreeEncoder[4];
    short[] _posEncoders = new short[114];
    RangeCoder_BitTreeEncoder _posAlignEncoder = new RangeCoder_BitTreeEncoder(4);
    LenPriceTableEncoder _lenEncoder = new LenPriceTableEncoder();
    LenPriceTableEncoder _repMatchLenEncoder = new LenPriceTableEncoder();
    LiteralEncoder _literalEncoder = new LiteralEncoder();
    int[] _matchDistances = new int[548];
    int _numFastBytes = 32;
    int[] _posSlotPrices = new int[256];
    int[] _distancesPrices = new int[512];
    int[] _alignPrices = new int[16];
    int _distTableSize = 44;
    int _posStateBits = 2;
    int _posStateMask = 3;
    int _numLiteralPosStateBits = 0;
    int _numLiteralContextBits = 3;
    int _dictionarySize = 4194304;
    int _dictionarySizePrev = -1;
    int _numFastBytesPrev = -1;
    int _matchFinderType = 1;
    boolean _writeEndMark = false;
    boolean _needReleaseMFStream = false;
    int[] reps = new int[4];
    int[] repLens = new int[4];
    long[] processedInSize = new long[1];
    long[] processedOutSize = new long[1];
    boolean[] finished = new boolean[1];
    byte[] properties = new byte[5];
    int[] tempPrices = new int[128];

    boolean ChangePair(int i, int i2) {
        return i < 33554432 && i2 >= (i << 7);
    }

    public boolean SetAlgorithm(int i) {
        return true;
    }

    static {
        byte[] bArr = new byte[2048];
        g_FastPos = bArr;
        bArr[0] = 0;
        bArr[1] = 1;
        int i = 2;
        for (int i2 = 2; i2 < 22; i2++) {
            int i3 = 0;
            while (i3 < (1 << ((i2 >> 1) - 1))) {
                g_FastPos[i] = (byte) i2;
                i3++;
                i++;
            }
        }
    }

    static int GetPosSlot(int i) {
        if (i < 2048) {
            return g_FastPos[i];
        }
        if (i < 2097152) {
            return g_FastPos[i >> 10] + Ascii.DC4;
        }
        return g_FastPos[i >> 20] + 40;
    }

    static int GetPosSlot2(int i) {
        if (i < 131072) {
            return g_FastPos[i >> 6] + 12;
        }
        if (i < 134217728) {
            return g_FastPos[i >> 16] + 32;
        }
        return g_FastPos[i >> 26] + TarHeader.LF_BLK;
    }

    void BaseInit() {
        this._state = LZMA_Base.StateInit();
        this._previousByte = (byte) 0;
        for (int i = 0; i < 4; i++) {
            this._repDistances[i] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class LiteralEncoder {
        Encoder2[] m_Coders;
        int m_NumPosBits;
        int m_NumPrevBits;
        int m_PosMask;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class Encoder2 {
            short[] m_Encoders = new short[768];

            Encoder2() {
            }

            public void Init() {
                RangeCoder_Encoder.InitBitModels(this.m_Encoders);
            }

            public void Encode(RangeCoder_Encoder rangeCoder_Encoder, byte b) throws IOException {
                int i = 1;
                for (int i2 = 7; i2 >= 0; i2--) {
                    int i3 = (b >> i2) & 1;
                    rangeCoder_Encoder.Encode(this.m_Encoders, i, i3);
                    i = (i << 1) | i3;
                }
            }

            public void EncodeMatched(RangeCoder_Encoder rangeCoder_Encoder, byte b, byte b2) throws IOException {
                int i;
                boolean z = true;
                int i2 = 1;
                for (int i3 = 7; i3 >= 0; i3--) {
                    int i4 = (b2 >> i3) & 1;
                    if (z) {
                        int i5 = (b >> i3) & 1;
                        i = ((i5 + 1) << 8) + i2;
                        z = i5 == i4;
                    } else {
                        i = i2;
                    }
                    rangeCoder_Encoder.Encode(this.m_Encoders, i, i4);
                    i2 = (i2 << 1) | i4;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002a -> B:14:0x0038). Please submit an issue!!! */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public int GetPrice(boolean r8, byte r9, byte r10) {
                /*
                    r7 = this;
                    r0 = 7
                    r1 = 0
                    r2 = 1
                    if (r8 == 0) goto L26
                    r8 = 1
                L6:
                    if (r0 < 0) goto L27
                    int r3 = r9 >> r0
                    r3 = r3 & r2
                    int r4 = r10 >> r0
                    r4 = r4 & r2
                    short[] r5 = r7.m_Encoders
                    int r6 = r3 + 1
                    int r6 = r6 << 8
                    int r6 = r6 + r8
                    short r5 = r5[r6]
                    int r5 = com.alipay.iap.android.aplog.util.zip.RangeCoder_Encoder.GetPrice(r5, r4)
                    int r1 = r1 + r5
                    int r8 = r8 << 1
                    r8 = r8 | r4
                    if (r3 == r4) goto L23
                    r9 = r7
                    goto L38
                L23:
                    int r0 = r0 + (-1)
                    goto L6
                L26:
                    r8 = 1
                L27:
                    r9 = r7
                L28:
                    if (r0 < 0) goto L3a
                    int r3 = r10 >> r0
                    r3 = r3 & r2
                    short[] r4 = r9.m_Encoders
                    short r4 = r4[r8]
                    int r4 = com.alipay.iap.android.aplog.util.zip.RangeCoder_Encoder.GetPrice(r4, r3)
                    int r1 = r1 + r4
                    int r8 = r8 << r2
                    r8 = r8 | r3
                L38:
                    int r0 = r0 - r2
                    goto L28
                L3a:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.zip.LZMA_Encoder.LiteralEncoder.Encoder2.GetPrice(boolean, byte, byte):int");
            }
        }

        LiteralEncoder() {
        }

        public void Create(int i, int i2) {
            if (this.m_Coders != null && this.m_NumPrevBits == i2 && this.m_NumPosBits == i) {
                return;
            }
            this.m_NumPosBits = i;
            this.m_PosMask = (1 << i) - 1;
            this.m_NumPrevBits = i2;
            int i3 = 1 << (i2 + i);
            this.m_Coders = new Encoder2[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                this.m_Coders[i4] = new Encoder2();
            }
        }

        public void Init() {
            int i = this.m_NumPrevBits;
            int i2 = this.m_NumPosBits;
            for (int i3 = 0; i3 < (1 << (i + i2)); i3++) {
                this.m_Coders[i3].Init();
            }
        }

        public Encoder2 GetSubCoder(int i, byte b) {
            Encoder2[] encoder2Arr = this.m_Coders;
            int i2 = this.m_PosMask;
            int i3 = this.m_NumPrevBits;
            return encoder2Arr[((i & i2) << i3) + ((b & 255) >>> (8 - i3))];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class LenEncoder {
        short[] _choice = new short[2];
        RangeCoder_BitTreeEncoder[] _lowCoder = new RangeCoder_BitTreeEncoder[16];
        RangeCoder_BitTreeEncoder[] _midCoder = new RangeCoder_BitTreeEncoder[16];
        RangeCoder_BitTreeEncoder _highCoder = new RangeCoder_BitTreeEncoder(8);

        public LenEncoder() {
            for (int i = 0; i < 16; i++) {
                this._lowCoder[i] = new RangeCoder_BitTreeEncoder(3);
                this._midCoder[i] = new RangeCoder_BitTreeEncoder(3);
            }
        }

        public void Init(int i) {
            RangeCoder_Encoder.InitBitModels(this._choice);
            for (int i2 = 0; i2 < i; i2++) {
                this._lowCoder[i2].Init();
                this._midCoder[i2].Init();
            }
            this._highCoder.Init();
        }

        public void Encode(RangeCoder_Encoder rangeCoder_Encoder, int i, int i2) throws IOException {
            if (i < 8) {
                rangeCoder_Encoder.Encode(this._choice, 0, 0);
                this._lowCoder[i2].Encode(rangeCoder_Encoder, i);
                return;
            }
            int i3 = i - 8;
            rangeCoder_Encoder.Encode(this._choice, 0, 1);
            if (i3 < 8) {
                rangeCoder_Encoder.Encode(this._choice, 1, 0);
                this._midCoder[i2].Encode(rangeCoder_Encoder, i3);
                return;
            }
            rangeCoder_Encoder.Encode(this._choice, 1, 1);
            this._highCoder.Encode(rangeCoder_Encoder, i3 - 8);
        }

        public void SetPrices(int i, int i2, int[] iArr, int i3) {
            int i4 = 0;
            int GetPrice0 = RangeCoder_Encoder.GetPrice0(this._choice[0]);
            int GetPrice1 = RangeCoder_Encoder.GetPrice1(this._choice[0]);
            int GetPrice02 = RangeCoder_Encoder.GetPrice0(this._choice[1]);
            int GetPrice12 = RangeCoder_Encoder.GetPrice1(this._choice[1]);
            while (i4 < 8) {
                if (i4 >= i2) {
                    return;
                }
                iArr[i3 + i4] = this._lowCoder[i].GetPrice(i4) + GetPrice0;
                i4++;
            }
            while (i4 < 16) {
                if (i4 >= i2) {
                    return;
                }
                iArr[i3 + i4] = this._midCoder[i].GetPrice(i4 - 8) + GetPrice02 + GetPrice1;
                i4++;
            }
            while (i4 < i2) {
                iArr[i3 + i4] = this._highCoder.GetPrice((i4 - 8) - 8) + GetPrice1 + GetPrice12;
                i4++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class LenPriceTableEncoder extends LenEncoder {
        int[] _counters;
        int[] _prices;
        int _tableSize;

        LenPriceTableEncoder() {
            super();
            this._prices = new int[4352];
            this._counters = new int[16];
        }

        public void SetTableSize(int i) {
            this._tableSize = i;
        }

        public int GetPrice(int i, int i2) {
            return this._prices[(i2 * LZMA_Base.kNumLenSymbols) + i];
        }

        void UpdateTable(int i) {
            SetPrices(i, this._tableSize, this._prices, i * LZMA_Base.kNumLenSymbols);
            this._counters[i] = this._tableSize;
        }

        public void UpdateTables(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                UpdateTable(i2);
            }
        }

        @Override // com.alipay.iap.android.aplog.util.zip.LZMA_Encoder.LenEncoder
        public void Encode(RangeCoder_Encoder rangeCoder_Encoder, int i, int i2) throws IOException {
            super.Encode(rangeCoder_Encoder, i, i2);
            int[] iArr = this._counters;
            int i3 = iArr[i2] - 1;
            iArr[i2] = i3;
            if (i3 == 0) {
                UpdateTable(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class Optimal {
        public int BackPrev;
        public int BackPrev2;
        public int Backs0;
        public int Backs1;
        public int Backs2;
        public int Backs3;
        public int PosPrev;
        public int PosPrev2;
        public boolean Prev1IsChar;
        public boolean Prev2;
        public int Price;
        public int State;

        Optimal() {
        }

        public void MakeAsChar() {
            this.BackPrev = -1;
            this.Prev1IsChar = false;
        }

        public void MakeAsShortRep() {
            this.BackPrev = 0;
            this.Prev1IsChar = false;
        }

        public boolean IsShortRep() {
            return this.BackPrev == 0;
        }
    }

    void Create() {
        if (this._matchFinder == null) {
            LZ_BinTree lZ_BinTree = new LZ_BinTree();
            lZ_BinTree.SetType(this._matchFinderType == 0 ? 2 : 4);
            this._matchFinder = lZ_BinTree;
        }
        this._literalEncoder.Create(this._numLiteralPosStateBits, this._numLiteralContextBits);
        int i = this._dictionarySize;
        if (i == this._dictionarySizePrev && this._numFastBytesPrev == this._numFastBytes) {
            return;
        }
        this._matchFinder.Create(i, 4096, this._numFastBytes, 274);
        this._dictionarySizePrev = this._dictionarySize;
        this._numFastBytesPrev = this._numFastBytes;
    }

    public LZMA_Encoder() {
        for (int i = 0; i < 4096; i++) {
            this._optimum[i] = new Optimal();
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this._posSlotEncoder[i2] = new RangeCoder_BitTreeEncoder(6);
        }
    }

    void SetWriteEndMarkerMode(boolean z) {
        this._writeEndMark = z;
    }

    void Init() {
        BaseInit();
        this._rangeEncoder.Init();
        RangeCoder_Encoder.InitBitModels(this._isMatch);
        RangeCoder_Encoder.InitBitModels(this._isRep0Long);
        RangeCoder_Encoder.InitBitModels(this._isRep);
        RangeCoder_Encoder.InitBitModels(this._isRepG0);
        RangeCoder_Encoder.InitBitModels(this._isRepG1);
        RangeCoder_Encoder.InitBitModels(this._isRepG2);
        RangeCoder_Encoder.InitBitModels(this._posEncoders);
        this._literalEncoder.Init();
        for (int i = 0; i < 4; i++) {
            this._posSlotEncoder[i].Init();
        }
        this._lenEncoder.Init(1 << this._posStateBits);
        this._repMatchLenEncoder.Init(1 << this._posStateBits);
        this._posAlignEncoder.Init();
        this._longestMatchWasFound = false;
        this._optimumEndIndex = 0;
        this._optimumCurrentIndex = 0;
        this._additionalOffset = 0;
    }

    int ReadMatchDistances() throws IOException {
        int i;
        int GetMatches = this._matchFinder.GetMatches(this._matchDistances);
        this._numDistancePairs = GetMatches;
        if (GetMatches > 0) {
            int[] iArr = this._matchDistances;
            i = iArr[GetMatches - 2];
            if (i == this._numFastBytes) {
                i += this._matchFinder.GetMatchLen(i - 1, iArr[GetMatches - 1], 273 - i);
            }
        } else {
            i = 0;
        }
        this._additionalOffset++;
        return i;
    }

    void MovePos(int i) throws IOException {
        if (i > 0) {
            this._matchFinder.Skip(i);
            this._additionalOffset += i;
        }
    }

    int GetRepLen1Price(int i, int i2) {
        return RangeCoder_Encoder.GetPrice0(this._isRepG0[i]) + RangeCoder_Encoder.GetPrice0(this._isRep0Long[(i << 4) + i2]);
    }

    int GetPureRepPrice(int i, int i2, int i3) {
        int GetPrice;
        if (i == 0) {
            return RangeCoder_Encoder.GetPrice0(this._isRepG0[i2]) + RangeCoder_Encoder.GetPrice1(this._isRep0Long[(i2 << 4) + i3]);
        }
        int GetPrice1 = RangeCoder_Encoder.GetPrice1(this._isRepG0[i2]);
        if (i == 1) {
            GetPrice = RangeCoder_Encoder.GetPrice0(this._isRepG1[i2]);
        } else {
            GetPrice1 += RangeCoder_Encoder.GetPrice1(this._isRepG1[i2]);
            GetPrice = RangeCoder_Encoder.GetPrice(this._isRepG2[i2], i - 2);
        }
        return GetPrice + GetPrice1;
    }

    int GetRepPrice(int i, int i2, int i3, int i4) {
        return this._repMatchLenEncoder.GetPrice(i2 - 2, i4) + GetPureRepPrice(i, i3, i4);
    }

    int GetPosLenPrice(int i, int i2, int i3) {
        int i4;
        int GetLenToPosState = LZMA_Base.GetLenToPosState(i2);
        if (i < 128) {
            i4 = this._distancesPrices[(GetLenToPosState * 128) + i];
        } else {
            i4 = this._alignPrices[i & 15] + this._posSlotPrices[(GetLenToPosState << 6) + GetPosSlot2(i)];
        }
        return i4 + this._lenEncoder.GetPrice(i2 - 2, i3);
    }

    int Backward(int i) {
        this._optimumEndIndex = i;
        int i2 = this._optimum[i].PosPrev;
        int i3 = this._optimum[i].BackPrev;
        while (true) {
            if (this._optimum[i].Prev1IsChar) {
                this._optimum[i2].MakeAsChar();
                int i4 = i2 - 1;
                this._optimum[i2].PosPrev = i4;
                if (this._optimum[i].Prev2) {
                    this._optimum[i4].Prev1IsChar = false;
                    Optimal[] optimalArr = this._optimum;
                    optimalArr[i4].PosPrev = optimalArr[i].PosPrev2;
                    Optimal[] optimalArr2 = this._optimum;
                    optimalArr2[i4].BackPrev = optimalArr2[i].BackPrev2;
                }
            }
            int i5 = this._optimum[i2].BackPrev;
            int i6 = this._optimum[i2].PosPrev;
            this._optimum[i2].BackPrev = i3;
            this._optimum[i2].PosPrev = i;
            if (i2 <= 0) {
                this.backRes = this._optimum[0].BackPrev;
                int i7 = this._optimum[0].PosPrev;
                this._optimumCurrentIndex = i7;
                return i7;
            }
            i = i2;
            i3 = i5;
            i2 = i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x070f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0714 A[EDGE_INSN: B:264:0x0714->B:231:0x0714 BREAK  A[LOOP:14: B:206:0x05f8->B:229:0x0706], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0706 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int GetOptimum(int r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1825
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.zip.LZMA_Encoder.GetOptimum(int):int");
    }

    void WriteEndMarker(int i) throws IOException {
        if (this._writeEndMark) {
            this._rangeEncoder.Encode(this._isMatch, (this._state << 4) + i, 1);
            this._rangeEncoder.Encode(this._isRep, this._state, 0);
            this._state = LZMA_Base.StateUpdateMatch(this._state);
            this._lenEncoder.Encode(this._rangeEncoder, 0, i);
            this._posSlotEncoder[LZMA_Base.GetLenToPosState(2)].Encode(this._rangeEncoder, 63);
            this._rangeEncoder.EncodeDirectBits(67108863, 26);
            this._posAlignEncoder.ReverseEncode(this._rangeEncoder, 15);
        }
    }

    void Flush(int i) throws IOException {
        ReleaseMFStream();
        WriteEndMarker(i & this._posStateMask);
        this._rangeEncoder.FlushData();
        this._rangeEncoder.FlushStream();
    }

    public void CodeOneBlock(long[] jArr, long[] jArr2, boolean[] zArr) throws IOException {
        jArr[0] = 0;
        jArr2[0] = 0;
        zArr[0] = true;
        InputStream inputStream = this._inStream;
        if (inputStream != null) {
            this._matchFinder.SetStream(inputStream);
            this._matchFinder.Init();
            this._needReleaseMFStream = true;
            this._inStream = null;
        }
        if (this._finished) {
            return;
        }
        this._finished = true;
        long j = this.nowPos64;
        if (j == 0) {
            if (this._matchFinder.GetNumAvailableBytes() == 0) {
                Flush((int) this.nowPos64);
                return;
            }
            ReadMatchDistances();
            this._rangeEncoder.Encode(this._isMatch, (this._state << 4) + (this._posStateMask & ((int) this.nowPos64)), 0);
            this._state = LZMA_Base.StateUpdateChar(this._state);
            byte GetIndexByte = this._matchFinder.GetIndexByte(0 - this._additionalOffset);
            this._literalEncoder.GetSubCoder((int) this.nowPos64, this._previousByte).Encode(this._rangeEncoder, GetIndexByte);
            this._previousByte = GetIndexByte;
            this._additionalOffset--;
            this.nowPos64++;
        }
        if (this._matchFinder.GetNumAvailableBytes() == 0) {
            Flush((int) this.nowPos64);
            return;
        }
        while (true) {
            int GetOptimum = GetOptimum((int) this.nowPos64);
            int i = this.backRes;
            int i2 = this._posStateMask & ((int) this.nowPos64);
            int i3 = (this._state << 4) + i2;
            if (GetOptimum == 1 && i == -1) {
                this._rangeEncoder.Encode(this._isMatch, i3, 0);
                byte GetIndexByte2 = this._matchFinder.GetIndexByte(0 - this._additionalOffset);
                LiteralEncoder.Encoder2 GetSubCoder = this._literalEncoder.GetSubCoder((int) this.nowPos64, this._previousByte);
                if (!LZMA_Base.StateIsCharState(this._state)) {
                    GetSubCoder.EncodeMatched(this._rangeEncoder, this._matchFinder.GetIndexByte(((0 - this._repDistances[0]) - 1) - this._additionalOffset), GetIndexByte2);
                } else {
                    GetSubCoder.Encode(this._rangeEncoder, GetIndexByte2);
                }
                this._previousByte = GetIndexByte2;
                this._state = LZMA_Base.StateUpdateChar(this._state);
            } else {
                this._rangeEncoder.Encode(this._isMatch, i3, 1);
                if (i < 4) {
                    this._rangeEncoder.Encode(this._isRep, this._state, 1);
                    if (i == 0) {
                        this._rangeEncoder.Encode(this._isRepG0, this._state, 0);
                        if (GetOptimum == 1) {
                            this._rangeEncoder.Encode(this._isRep0Long, i3, 0);
                        } else {
                            this._rangeEncoder.Encode(this._isRep0Long, i3, 1);
                        }
                    } else {
                        this._rangeEncoder.Encode(this._isRepG0, this._state, 1);
                        if (i == 1) {
                            this._rangeEncoder.Encode(this._isRepG1, this._state, 0);
                        } else {
                            this._rangeEncoder.Encode(this._isRepG1, this._state, 1);
                            this._rangeEncoder.Encode(this._isRepG2, this._state, i - 2);
                        }
                    }
                    if (GetOptimum == 1) {
                        this._state = LZMA_Base.StateUpdateShortRep(this._state);
                    } else {
                        this._repMatchLenEncoder.Encode(this._rangeEncoder, GetOptimum - 2, i2);
                        this._state = LZMA_Base.StateUpdateRep(this._state);
                    }
                    int i4 = this._repDistances[i];
                    if (i != 0) {
                        while (i > 0) {
                            int[] iArr = this._repDistances;
                            iArr[i] = iArr[i - 1];
                            i--;
                        }
                        this._repDistances[0] = i4;
                    }
                } else {
                    this._rangeEncoder.Encode(this._isRep, this._state, 0);
                    this._state = LZMA_Base.StateUpdateMatch(this._state);
                    this._lenEncoder.Encode(this._rangeEncoder, GetOptimum - 2, i2);
                    int i5 = i - 4;
                    int GetPosSlot = GetPosSlot(i5);
                    this._posSlotEncoder[LZMA_Base.GetLenToPosState(GetOptimum)].Encode(this._rangeEncoder, GetPosSlot);
                    if (GetPosSlot >= 4) {
                        int i6 = (GetPosSlot >> 1) - 1;
                        int i7 = ((GetPosSlot & 1) | 2) << i6;
                        int i8 = i5 - i7;
                        if (GetPosSlot < 14) {
                            RangeCoder_BitTreeEncoder.ReverseEncode(this._posEncoders, (i7 - GetPosSlot) - 1, this._rangeEncoder, i6, i8);
                        } else {
                            this._rangeEncoder.EncodeDirectBits(i8 >> 4, i6 - 4);
                            this._posAlignEncoder.ReverseEncode(this._rangeEncoder, i8 & 15);
                            this._alignPriceCount++;
                        }
                    }
                    for (int i9 = 3; i9 > 0; i9--) {
                        int[] iArr2 = this._repDistances;
                        iArr2[i9] = iArr2[i9 - 1];
                    }
                    this._repDistances[0] = i5;
                    this._matchPriceCount++;
                }
                this._previousByte = this._matchFinder.GetIndexByte((GetOptimum - 1) - this._additionalOffset);
            }
            int i10 = this._additionalOffset - GetOptimum;
            this._additionalOffset = i10;
            this.nowPos64 += GetOptimum;
            if (i10 == 0) {
                if (this._matchPriceCount >= 128) {
                    FillDistancesPrices();
                }
                if (this._alignPriceCount >= 16) {
                    FillAlignPrices();
                }
                jArr[0] = this.nowPos64;
                jArr2[0] = this._rangeEncoder.GetProcessedSizeAdd();
                if (this._matchFinder.GetNumAvailableBytes() == 0) {
                    Flush((int) this.nowPos64);
                    return;
                } else if (this.nowPos64 - j >= 4096) {
                    this._finished = false;
                    zArr[0] = false;
                    return;
                }
            }
        }
    }

    void ReleaseMFStream() {
        LZ_BinTree lZ_BinTree = this._matchFinder;
        if (lZ_BinTree == null || !this._needReleaseMFStream) {
            return;
        }
        lZ_BinTree.ReleaseStream();
        this._needReleaseMFStream = false;
    }

    void SetOutStream(OutputStream outputStream) {
        this._rangeEncoder.SetStream(outputStream);
    }

    void ReleaseOutStream() {
        this._rangeEncoder.ReleaseStream();
    }

    void ReleaseStreams() {
        ReleaseMFStream();
        ReleaseOutStream();
    }

    void SetStreams(InputStream inputStream, OutputStream outputStream, long j, long j2) {
        this._inStream = inputStream;
        this._finished = false;
        Create();
        SetOutStream(outputStream);
        Init();
        FillDistancesPrices();
        FillAlignPrices();
        this._lenEncoder.SetTableSize((this._numFastBytes + 1) - 2);
        this._lenEncoder.UpdateTables(1 << this._posStateBits);
        this._repMatchLenEncoder.SetTableSize((this._numFastBytes + 1) - 2);
        this._repMatchLenEncoder.UpdateTables(1 << this._posStateBits);
        this.nowPos64 = 0L;
    }

    public void Code(InputStream inputStream, OutputStream outputStream, long j, long j2, ICodeProgress iCodeProgress) throws IOException {
        this._needReleaseMFStream = false;
        try {
            SetStreams(inputStream, outputStream, j, j2);
            while (true) {
                CodeOneBlock(this.processedInSize, this.processedOutSize, this.finished);
                if (this.finished[0]) {
                    return;
                }
                if (iCodeProgress != null) {
                    iCodeProgress.SetProgress(this.processedInSize[0], this.processedOutSize[0]);
                }
            }
        } finally {
            ReleaseStreams();
        }
    }

    public void WriteCoderProperties(OutputStream outputStream) throws IOException {
        this.properties[0] = (byte) ((((this._posStateBits * 5) + this._numLiteralPosStateBits) * 9) + this._numLiteralContextBits);
        int i = 0;
        while (i < 4) {
            int i2 = i + 1;
            this.properties[i2] = (byte) (this._dictionarySize >> (i * 8));
            i = i2;
        }
        outputStream.write(this.properties, 0, 5);
    }

    void FillDistancesPrices() {
        for (int i = 4; i < 128; i++) {
            int GetPosSlot = GetPosSlot(i);
            int i2 = (GetPosSlot >> 1) - 1;
            this.tempPrices[i] = RangeCoder_BitTreeEncoder.ReverseGetPrice(this._posEncoders, (r4 - GetPosSlot) - 1, i2, i - (((GetPosSlot & 1) | 2) << i2));
        }
        for (int i3 = 0; i3 < 4; i3++) {
            RangeCoder_BitTreeEncoder rangeCoder_BitTreeEncoder = this._posSlotEncoder[i3];
            int i4 = i3 << 6;
            for (int i5 = 0; i5 < this._distTableSize; i5++) {
                this._posSlotPrices[i4 + i5] = rangeCoder_BitTreeEncoder.GetPrice(i5);
            }
            for (int i6 = 14; i6 < this._distTableSize; i6++) {
                int[] iArr = this._posSlotPrices;
                int i7 = i4 + i6;
                iArr[i7] = iArr[i7] + ((((i6 >> 1) - 1) - 4) << 6);
            }
            int i8 = i3 * 128;
            int i9 = 0;
            while (i9 < 4) {
                this._distancesPrices[i8 + i9] = this._posSlotPrices[i4 + i9];
                i9++;
            }
            while (i9 < 128) {
                this._distancesPrices[i8 + i9] = this._posSlotPrices[GetPosSlot(i9) + i4] + this.tempPrices[i9];
                i9++;
            }
        }
        this._matchPriceCount = 0;
    }

    void FillAlignPrices() {
        for (int i = 0; i < 16; i++) {
            this._alignPrices[i] = this._posAlignEncoder.ReverseGetPrice(i);
        }
        this._alignPriceCount = 0;
    }

    public boolean SetDictionarySize(int i) {
        int i2 = 0;
        if (i <= 0 || i > 536870912) {
            return false;
        }
        this._dictionarySize = i;
        while (i > (1 << i2)) {
            i2++;
        }
        this._distTableSize = i2 * 2;
        return true;
    }

    public boolean SetNumFastBytes(int i) {
        if (i < 5 || i > 273) {
            return false;
        }
        this._numFastBytes = i;
        return true;
    }

    public boolean SetMatchFinder(int i) {
        if (i < 0 || i > 2) {
            return false;
        }
        int i2 = this._matchFinderType;
        this._matchFinderType = i;
        if (this._matchFinder == null || i2 == i) {
            return true;
        }
        this._dictionarySizePrev = -1;
        this._matchFinder = null;
        return true;
    }

    public boolean SetLcLpPb(int i, int i2, int i3) {
        if (i2 < 0 || i2 > 4 || i < 0 || i > 8 || i3 < 0 || i3 > 4) {
            return false;
        }
        this._numLiteralPosStateBits = i2;
        this._numLiteralContextBits = i;
        this._posStateBits = i3;
        this._posStateMask = (1 << i3) - 1;
        return true;
    }

    public void SetEndMarkerMode(boolean z) {
        this._writeEndMark = z;
    }
}
