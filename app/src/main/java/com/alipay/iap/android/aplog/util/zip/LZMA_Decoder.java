package com.alipay.iap.android.aplog.util.zip;

import java.io.IOException;

/* loaded from: classes3.dex */
public class LZMA_Decoder {
    int m_PosStateMask;
    LZ_OutWindow m_OutWindow = new LZ_OutWindow();
    RangeCoder_Decoder m_RangeDecoder = new RangeCoder_Decoder();
    short[] m_IsMatchDecoders = new short[192];
    short[] m_IsRepDecoders = new short[12];
    short[] m_IsRepG0Decoders = new short[12];
    short[] m_IsRepG1Decoders = new short[12];
    short[] m_IsRepG2Decoders = new short[12];
    short[] m_IsRep0LongDecoders = new short[192];
    RangeCoder_BitTreeDecoder[] m_PosSlotDecoder = new RangeCoder_BitTreeDecoder[4];
    short[] m_PosDecoders = new short[114];
    RangeCoder_BitTreeDecoder m_PosAlignDecoder = new RangeCoder_BitTreeDecoder(4);
    LenDecoder m_LenDecoder = new LenDecoder();
    LenDecoder m_RepLenDecoder = new LenDecoder();
    LiteralDecoder m_LiteralDecoder = new LiteralDecoder();
    int m_DictionarySize = -1;
    int m_DictionarySizeCheck = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class LenDecoder {
        short[] m_Choice = new short[2];
        RangeCoder_BitTreeDecoder[] m_LowCoder = new RangeCoder_BitTreeDecoder[16];
        RangeCoder_BitTreeDecoder[] m_MidCoder = new RangeCoder_BitTreeDecoder[16];
        RangeCoder_BitTreeDecoder m_HighCoder = new RangeCoder_BitTreeDecoder(8);
        int m_NumPosStates = 0;

        LenDecoder() {
        }

        public void Create(int i) {
            while (true) {
                int i2 = this.m_NumPosStates;
                if (i2 >= i) {
                    return;
                }
                this.m_LowCoder[i2] = new RangeCoder_BitTreeDecoder(3);
                this.m_MidCoder[this.m_NumPosStates] = new RangeCoder_BitTreeDecoder(3);
                this.m_NumPosStates++;
            }
        }

        public void Init() {
            RangeCoder_Decoder.InitBitModels(this.m_Choice);
            for (int i = 0; i < this.m_NumPosStates; i++) {
                this.m_LowCoder[i].Init();
                this.m_MidCoder[i].Init();
            }
            this.m_HighCoder.Init();
        }

        public int Decode(RangeCoder_Decoder rangeCoder_Decoder, int i) throws IOException {
            int Decode;
            if (rangeCoder_Decoder.DecodeBit(this.m_Choice, 0) == 0) {
                return this.m_LowCoder[i].Decode(rangeCoder_Decoder);
            }
            if (rangeCoder_Decoder.DecodeBit(this.m_Choice, 1) == 0) {
                Decode = this.m_MidCoder[i].Decode(rangeCoder_Decoder);
            } else {
                Decode = this.m_HighCoder.Decode(rangeCoder_Decoder) + 8;
            }
            return Decode + 8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class LiteralDecoder {
        Decoder2[] m_Coders;
        int m_NumPosBits;
        int m_NumPrevBits;
        int m_PosMask;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class Decoder2 {
            short[] m_Decoders = new short[768];

            Decoder2() {
            }

            public void Init() {
                RangeCoder_Decoder.InitBitModels(this.m_Decoders);
            }

            public byte DecodeNormal(RangeCoder_Decoder rangeCoder_Decoder) throws IOException {
                int i = 1;
                do {
                    i = (i << 1) | rangeCoder_Decoder.DecodeBit(this.m_Decoders, i);
                } while (i < 256);
                return (byte) i;
            }

            public byte DecodeWithMatchByte(RangeCoder_Decoder rangeCoder_Decoder, byte b) throws IOException {
                int i = 1;
                while (true) {
                    int i2 = (b >> 7) & 1;
                    b = (byte) (b << 1);
                    int DecodeBit = rangeCoder_Decoder.DecodeBit(this.m_Decoders, ((i2 + 1) << 8) + i);
                    i = (i << 1) | DecodeBit;
                    if (i2 != DecodeBit) {
                        while (i < 256) {
                            i = (i << 1) | rangeCoder_Decoder.DecodeBit(this.m_Decoders, i);
                        }
                    } else if (i >= 256) {
                        break;
                    }
                }
                return (byte) i;
            }
        }

        LiteralDecoder() {
        }

        public void Create(int i, int i2) {
            if (this.m_Coders != null && this.m_NumPrevBits == i2 && this.m_NumPosBits == i) {
                return;
            }
            this.m_NumPosBits = i;
            this.m_PosMask = (1 << i) - 1;
            this.m_NumPrevBits = i2;
            int i3 = 1 << (i2 + i);
            this.m_Coders = new Decoder2[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                this.m_Coders[i4] = new Decoder2();
            }
        }

        public void Init() {
            int i = this.m_NumPrevBits;
            int i2 = this.m_NumPosBits;
            for (int i3 = 0; i3 < (1 << (i + i2)); i3++) {
                this.m_Coders[i3].Init();
            }
        }

        Decoder2 GetDecoder(int i, byte b) {
            Decoder2[] decoder2Arr = this.m_Coders;
            int i2 = this.m_PosMask;
            int i3 = this.m_NumPrevBits;
            return decoder2Arr[((i & i2) << i3) + ((b & 255) >>> (8 - i3))];
        }
    }

    public LZMA_Decoder() {
        for (int i = 0; i < 4; i++) {
            this.m_PosSlotDecoder[i] = new RangeCoder_BitTreeDecoder(6);
        }
    }

    boolean SetDictionarySize(int i) {
        if (i < 0) {
            return false;
        }
        if (this.m_DictionarySize != i) {
            this.m_DictionarySize = i;
            int max = Math.max(i, 1);
            this.m_DictionarySizeCheck = max;
            this.m_OutWindow.Create(Math.max(max, 4096));
        }
        return true;
    }

    boolean SetLcLpPb(int i, int i2, int i3) {
        if (i > 8 || i2 > 4 || i3 > 4) {
            return false;
        }
        this.m_LiteralDecoder.Create(i2, i);
        int i4 = 1 << i3;
        this.m_LenDecoder.Create(i4);
        this.m_RepLenDecoder.Create(i4);
        this.m_PosStateMask = i4 - 1;
        return true;
    }

    void Init() throws IOException {
        this.m_OutWindow.Init(false);
        RangeCoder_Decoder.InitBitModels(this.m_IsMatchDecoders);
        RangeCoder_Decoder.InitBitModels(this.m_IsRep0LongDecoders);
        RangeCoder_Decoder.InitBitModels(this.m_IsRepDecoders);
        RangeCoder_Decoder.InitBitModels(this.m_IsRepG0Decoders);
        RangeCoder_Decoder.InitBitModels(this.m_IsRepG1Decoders);
        RangeCoder_Decoder.InitBitModels(this.m_IsRepG2Decoders);
        RangeCoder_Decoder.InitBitModels(this.m_PosDecoders);
        this.m_LiteralDecoder.Init();
        for (int i = 0; i < 4; i++) {
            this.m_PosSlotDecoder[i].Init();
        }
        this.m_LenDecoder.Init();
        this.m_RepLenDecoder.Init();
        this.m_PosAlignDecoder.Init();
        this.m_RangeDecoder.Init();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0116, code lost:
    
        r17.m_OutWindow.Flush();
        r17.m_OutWindow.ReleaseStream();
        r17.m_RangeDecoder.ReleaseStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0125, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean Code(java.io.InputStream r18, java.io.OutputStream r19, long r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.util.zip.LZMA_Decoder.Code(java.io.InputStream, java.io.OutputStream, long):boolean");
    }

    public boolean SetDecoderProperties(byte[] bArr) {
        if (bArr.length < 5) {
            return false;
        }
        int i = bArr[0] & 255;
        int i2 = i / 9;
        int i3 = i2 / 5;
        int i4 = 0;
        int i5 = 0;
        while (i4 < 4) {
            int i6 = i4 + 1;
            i5 += (bArr[i6] & 255) << (i4 * 8);
            i4 = i6;
        }
        if (SetLcLpPb(i % 9, i2 % 5, i3)) {
            return SetDictionarySize(i5);
        }
        return false;
    }
}
