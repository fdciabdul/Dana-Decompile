package zipkin2.internal;

import com.alibaba.ariver.resource.parser.tar.TarHeader;

/* loaded from: classes6.dex */
public final class WriteBuffer {
    public int MyBillsEntityDataFactory;
    public final byte[] PlaceComponentResult;

    /* loaded from: classes6.dex */
    public interface Writer<T> {
        void KClassImpl$Data$declaredNonStaticMembers$2(T t, WriteBuffer writeBuffer);

        int PlaceComponentResult(T t);
    }

    public static int BuiltInFictitiousFunctionClassFactory(long j) {
        int i = 1;
        if (j == 0) {
            return 1;
        }
        if (j == Long.MIN_VALUE) {
            return 20;
        }
        boolean z = false;
        if (j < 0) {
            j = -j;
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        return z ? i + 1 : i;
    }

    public static int PlaceComponentResult(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int getAuthRequestContext(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static WriteBuffer BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) {
        return new WriteBuffer(bArr, i);
    }

    private WriteBuffer(byte[] bArr, int i) {
        this.PlaceComponentResult = bArr;
        this.MyBillsEntityDataFactory = i;
    }

    private void MyBillsEntityDataFactory(long j) {
        int BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory + BuiltInFictitiousFunctionClassFactory(j);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        while (j != 0) {
            BuiltInFictitiousFunctionClassFactory--;
            this.PlaceComponentResult[BuiltInFictitiousFunctionClassFactory] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(int) (j % 10)];
            j /= 10;
        }
    }

    public final void getAuthRequestContext(long j) {
        int i = this.MyBillsEntityDataFactory;
        byte[] bArr = this.PlaceComponentResult;
        int i2 = i + 0;
        byte b = (byte) ((j >>> 56) & 255);
        bArr[i2 + 0] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(b >> 4) & 15];
        bArr[i2 + 1] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[b & 15];
        byte[] bArr2 = this.PlaceComponentResult;
        int i3 = i + 2;
        byte b2 = (byte) ((j >>> 48) & 255);
        bArr2[i3 + 0] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(b2 >> 4) & 15];
        bArr2[i3 + 1] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[b2 & 15];
        byte[] bArr3 = this.PlaceComponentResult;
        int i4 = i + 4;
        byte b3 = (byte) ((j >>> 40) & 255);
        bArr3[i4 + 0] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(b3 >> 4) & 15];
        bArr3[i4 + 1] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[b3 & 15];
        byte[] bArr4 = this.PlaceComponentResult;
        int i5 = i + 6;
        byte b4 = (byte) ((j >>> 32) & 255);
        bArr4[i5 + 0] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(b4 >> 4) & 15];
        bArr4[i5 + 1] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[b4 & 15];
        byte[] bArr5 = this.PlaceComponentResult;
        int i6 = i + 8;
        byte b5 = (byte) ((j >>> 24) & 255);
        bArr5[i6 + 0] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(b5 >> 4) & 15];
        bArr5[i6 + 1] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[b5 & 15];
        byte[] bArr6 = this.PlaceComponentResult;
        int i7 = i + 10;
        byte b6 = (byte) ((j >>> 16) & 255);
        bArr6[i7 + 0] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(b6 >> 4) & 15];
        bArr6[i7 + 1] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[b6 & 15];
        byte[] bArr7 = this.PlaceComponentResult;
        int i8 = i + 12;
        byte b7 = (byte) ((j >>> 8) & 255);
        bArr7[i8 + 0] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(b7 >> 4) & 15];
        bArr7[i8 + 1] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[b7 & 15];
        byte[] bArr8 = this.PlaceComponentResult;
        int i9 = i + 14;
        byte b8 = (byte) (j & 255);
        bArr8[i9 + 0] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[(b8 >> 4) & 15];
        bArr8[i9 + 1] = (byte) HexCodec.BuiltInFictitiousFunctionClassFactory[b8 & 15];
        this.MyBillsEntityDataFactory = i + 16;
    }

    public final void getAuthRequestContext(CharSequence charSequence) {
        int i;
        char charAt;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 < 128) {
                byte[] bArr = this.PlaceComponentResult;
                int i3 = this.MyBillsEntityDataFactory;
                this.MyBillsEntityDataFactory = i3 + 1;
                bArr[i3] = (byte) (charAt2 & 255);
                while (i2 < length - 1 && (charAt = charSequence.charAt((i = i2 + 1))) < 128) {
                    byte[] bArr2 = this.PlaceComponentResult;
                    int i4 = this.MyBillsEntityDataFactory;
                    this.MyBillsEntityDataFactory = i4 + 1;
                    bArr2[i4] = (byte) (charAt & 255);
                    i2 = i;
                }
            } else if (charAt2 < 2048) {
                byte[] bArr3 = this.PlaceComponentResult;
                int i5 = this.MyBillsEntityDataFactory;
                int i6 = i5 + 1;
                this.MyBillsEntityDataFactory = i6;
                bArr3[i5] = (byte) (((charAt2 >> 6) | 192) & 255);
                this.MyBillsEntityDataFactory = i6 + 1;
                bArr3[i6] = (byte) (((charAt2 & '?') | 128) & 255);
            } else {
                if (charAt2 >= 55296 && charAt2 <= 57343) {
                    if (!Character.isHighSurrogate(charAt2)) {
                        byte[] bArr4 = this.PlaceComponentResult;
                        int i7 = this.MyBillsEntityDataFactory;
                        this.MyBillsEntityDataFactory = i7 + 1;
                        bArr4[i7] = 63;
                    } else if (i2 != length - 1) {
                        i2++;
                        char charAt3 = charSequence.charAt(i2);
                        if (Character.isLowSurrogate(charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            byte[] bArr5 = this.PlaceComponentResult;
                            int i8 = this.MyBillsEntityDataFactory;
                            int i9 = i8 + 1;
                            this.MyBillsEntityDataFactory = i9;
                            bArr5[i8] = (byte) (((codePoint >> 18) | 240) & 255);
                            int i10 = i9 + 1;
                            this.MyBillsEntityDataFactory = i10;
                            bArr5[i9] = (byte) ((((codePoint >> 12) & 63) | 128) & 255);
                            int i11 = i10 + 1;
                            this.MyBillsEntityDataFactory = i11;
                            bArr5[i10] = (byte) ((((codePoint >> 6) & 63) | 128) & 255);
                            this.MyBillsEntityDataFactory = i11 + 1;
                            bArr5[i11] = (byte) (((codePoint & 63) | 128) & 255);
                        } else {
                            byte[] bArr6 = this.PlaceComponentResult;
                            int i12 = this.MyBillsEntityDataFactory;
                            this.MyBillsEntityDataFactory = i12 + 1;
                            bArr6[i12] = 63;
                            char c = Character.isHighSurrogate(charAt3) ? '?' : charAt3;
                            byte[] bArr7 = this.PlaceComponentResult;
                            int i13 = this.MyBillsEntityDataFactory;
                            this.MyBillsEntityDataFactory = i13 + 1;
                            bArr7[i13] = (byte) (c & 255);
                        }
                    } else {
                        byte[] bArr8 = this.PlaceComponentResult;
                        int i14 = this.MyBillsEntityDataFactory;
                        this.MyBillsEntityDataFactory = i14 + 1;
                        bArr8[i14] = 63;
                        return;
                    }
                } else {
                    byte[] bArr9 = this.PlaceComponentResult;
                    int i15 = this.MyBillsEntityDataFactory;
                    int i16 = i15 + 1;
                    this.MyBillsEntityDataFactory = i16;
                    bArr9[i15] = (byte) (((charAt2 >> '\f') | 224) & 255);
                    int i17 = i16 + 1;
                    this.MyBillsEntityDataFactory = i17;
                    bArr9[i16] = (byte) ((((charAt2 >> 6) & 63) | 128) & 255);
                    this.MyBillsEntityDataFactory = i17 + 1;
                    bArr9[i17] = (byte) (((charAt2 & '?') | 128) & 255);
                }
            }
            i2++;
        }
    }

    public static int BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                i2++;
                while (i < length - 1) {
                    int i3 = i + 1;
                    if (charSequence.charAt(i3) >= 128) {
                        break;
                    }
                    i2++;
                    i = i3;
                }
            } else if (charAt < 2048) {
                i2 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i2 += 3;
            } else {
                int i4 = i + 1;
                char charAt2 = i4 < length ? charSequence.charAt(i4) : (char) 0;
                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                    i2++;
                } else {
                    i2 += 4;
                    i = i4;
                }
            }
            i++;
        }
        return i2;
    }

    public static WriteBuffer getAuthRequestContext(byte[] bArr) {
        return new WriteBuffer(bArr, 0);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        if (j == 0) {
            byte[] bArr = this.PlaceComponentResult;
            int i = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i + 1;
            bArr[i] = TarHeader.LF_NORMAL;
        } else if (j != Long.MIN_VALUE) {
            if (j < 0) {
                byte[] bArr2 = this.PlaceComponentResult;
                int i2 = this.MyBillsEntityDataFactory;
                this.MyBillsEntityDataFactory = i2 + 1;
                bArr2[i2] = 45;
                j = -j;
            }
            MyBillsEntityDataFactory(j);
        } else {
            for (int i3 = 0; i3 < 20; i3++) {
                int charAt = "-9223372036854775808".charAt(i3) & 255;
                byte[] bArr3 = this.PlaceComponentResult;
                int i4 = this.MyBillsEntityDataFactory;
                this.MyBillsEntityDataFactory = i4 + 1;
                bArr3[i4] = (byte) (charAt & 255);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(int i) {
        while ((i & (-128)) != 0) {
            byte[] bArr = this.PlaceComponentResult;
            int i2 = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = i2 + 1;
            bArr[i2] = (byte) (((byte) ((i & 127) | 128)) & 255);
            i >>>= 7;
        }
        byte[] bArr2 = this.PlaceComponentResult;
        int i3 = this.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = i3 + 1;
        bArr2[i3] = (byte) (((byte) i) & 255);
    }
}
