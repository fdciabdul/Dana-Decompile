package zipkin2.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class Proto3Fields {

    /* loaded from: classes9.dex */
    static final class Fixed32Field extends Field {
    }

    Proto3Fields() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Field {
        final int BuiltInFictitiousFunctionClassFactory;
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        final int MyBillsEntityDataFactory;

        Field(int i) {
            this(i >>> 3, i & 7, i);
        }

        private Field(int i, int i2, int i3) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.MyBillsEntityDataFactory = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            int i3 = i >>> 3;
            if (i3 != 0) {
                return i3;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed: fieldNumber was zero at byte ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getAuthRequestContext(int i, int i2) {
            int i3 = i & 7;
            if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 5) {
                return i3;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed: invalid wireType ");
            sb.append(i3);
            sb.append(" at byte ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean getAuthRequestContext(ReadBuffer readBuffer, int i) {
            int available = readBuffer.available();
            if (i == 0) {
                for (int i2 = 0; i2 < available; i2++) {
                    if (readBuffer.MyBillsEntityDataFactory() >= 0) {
                        return true;
                    }
                }
                return false;
            } else if (i == 1) {
                return readBuffer.skip(8L) == 8;
            } else if (i == 2) {
                long scheduleImpl = readBuffer.scheduleImpl();
                return readBuffer.skip(scheduleImpl) == scheduleImpl;
            } else if (i == 5) {
                return readBuffer.skip(4L) == 4;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed: invalid wireType ");
                sb.append(i);
                sb.append(" at byte ");
                sb.append(readBuffer.BuiltInFictitiousFunctionClassFactory());
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class LengthDelimitedField<T> extends Field {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract int BuiltInFictitiousFunctionClassFactory(T t);

        abstract void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, T t);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract T MyBillsEntityDataFactory(ReadBuffer readBuffer, int i);

        /* JADX INFO: Access modifiers changed from: package-private */
        public LengthDelimitedField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void PlaceComponentResult(WriteBuffer writeBuffer, T t) {
            if (t == null) {
                return;
            }
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(t);
            int i = this.MyBillsEntityDataFactory;
            byte[] bArr = writeBuffer.PlaceComponentResult;
            int i2 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i2 + 1;
            bArr[i2] = (byte) (i & 255);
            writeBuffer.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            BuiltInFictitiousFunctionClassFactory(writeBuffer, (WriteBuffer) t);
        }
    }

    /* loaded from: classes6.dex */
    static class BytesField extends LengthDelimitedField<byte[]> {
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* bridge */ /* synthetic */ int BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
            return bArr.length;
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, byte[] bArr) {
            byte[] bArr2 = bArr;
            System.arraycopy(bArr2, 0, writeBuffer.PlaceComponentResult, writeBuffer.MyBillsEntityDataFactory, bArr2.length);
            writeBuffer.MyBillsEntityDataFactory += bArr2.length;
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ byte[] MyBillsEntityDataFactory(ReadBuffer readBuffer, int i) {
            return BuiltInFictitiousFunctionClassFactory(readBuffer, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public BytesField(int i) {
            super(i);
        }

        private static byte[] BuiltInFictitiousFunctionClassFactory(ReadBuffer readBuffer, int i) {
            return readBuffer.getAuthRequestContext(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class HexField extends LengthDelimitedField<String> {
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(String str) {
            String str2 = str;
            if (str2 == null) {
                return 0;
            }
            return str2.length() / 2;
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, String str) {
            String str2 = str;
            int length = str2.length();
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                byte PlaceComponentResult = (byte) ((PlaceComponentResult(str2.charAt(i)) << 4) + PlaceComponentResult(str2.charAt(i2)));
                byte[] bArr = writeBuffer.PlaceComponentResult;
                int i3 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i3 + 1;
                bArr[i3] = (byte) (PlaceComponentResult & 255);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public HexField(int i) {
            super(i);
        }

        private static int PlaceComponentResult(char c) {
            if (c < '0' || c > '9') {
                if (c < 'a' || c > 'f') {
                    StringBuilder sb = new StringBuilder();
                    sb.append("not lowerHex ");
                    sb.append(c);
                    throw new AssertionError(sb.toString());
                }
                return (c - 'a') + 10;
            }
            return c - '0';
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ String MyBillsEntityDataFactory(ReadBuffer readBuffer, int i) {
            if (i > 32) {
                StringBuilder sb = new StringBuilder();
                sb.append("hex field greater than 32 chars long: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            readBuffer.KClassImpl$Data$declaredNonStaticMembers$2(i);
            char[] BuiltInFictitiousFunctionClassFactory = RecyclableBuffers.BuiltInFictitiousFunctionClassFactory();
            int i2 = i * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                byte PlaceComponentResult = readBuffer.PlaceComponentResult();
                BuiltInFictitiousFunctionClassFactory[i3 + 0] = HexCodec.BuiltInFictitiousFunctionClassFactory[(PlaceComponentResult >> 4) & 15];
                BuiltInFictitiousFunctionClassFactory[i3 + 1] = HexCodec.BuiltInFictitiousFunctionClassFactory[PlaceComponentResult & 15];
            }
            return new String(BuiltInFictitiousFunctionClassFactory, 0, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Utf8Field extends LengthDelimitedField<String> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final /* bridge */ /* synthetic */ int BuiltInFictitiousFunctionClassFactory(String str) {
            String str2 = str;
            if (str2 != null) {
                return WriteBuffer.BuiltInFictitiousFunctionClassFactory(str2);
            }
            return 0;
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, String str) {
            writeBuffer.getAuthRequestContext(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Utf8Field(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final /* bridge */ /* synthetic */ String MyBillsEntityDataFactory(ReadBuffer readBuffer, int i) {
            return readBuffer.MyBillsEntityDataFactory(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Fixed64Field extends Field {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static int BuiltInFictitiousFunctionClassFactory(long j) {
            return j == 0 ? 0 : 9;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Fixed64Field(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void getAuthRequestContext(WriteBuffer writeBuffer, long j) {
            if (j == 0) {
                return;
            }
            int i = this.MyBillsEntityDataFactory;
            byte[] bArr = writeBuffer.PlaceComponentResult;
            int i2 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i2 + 1;
            bArr[i2] = (byte) (i & 255);
            byte[] bArr2 = writeBuffer.PlaceComponentResult;
            int i3 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i3 + 1;
            bArr2[i3] = (byte) (((byte) (j & 255)) & 255);
            byte[] bArr3 = writeBuffer.PlaceComponentResult;
            int i4 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i4 + 1;
            bArr3[i4] = (byte) (((byte) ((j >> 8) & 255)) & 255);
            byte[] bArr4 = writeBuffer.PlaceComponentResult;
            int i5 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i5 + 1;
            bArr4[i5] = (byte) (((byte) ((j >> 16) & 255)) & 255);
            byte[] bArr5 = writeBuffer.PlaceComponentResult;
            int i6 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i6 + 1;
            bArr5[i6] = (byte) (((byte) ((j >> 24) & 255)) & 255);
            byte[] bArr6 = writeBuffer.PlaceComponentResult;
            int i7 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i7 + 1;
            bArr6[i7] = (byte) (((byte) ((j >> 32) & 255)) & 255);
            byte[] bArr7 = writeBuffer.PlaceComponentResult;
            int i8 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i8 + 1;
            bArr7[i8] = (byte) (((byte) ((j >> 40) & 255)) & 255);
            byte[] bArr8 = writeBuffer.PlaceComponentResult;
            int i9 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i9 + 1;
            bArr8[i9] = (byte) (((byte) ((j >> 48) & 255)) & 255);
            byte[] bArr9 = writeBuffer.PlaceComponentResult;
            int i10 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i10 + 1;
            bArr9[i10] = (byte) (((byte) ((j >> 56) & 255)) & 255);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static long PlaceComponentResult(ReadBuffer readBuffer) {
            return readBuffer.getErrorConfigVersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class VarintField extends Field {
        /* JADX INFO: Access modifiers changed from: package-private */
        public VarintField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int BuiltInFictitiousFunctionClassFactory(int i) {
            if (i != 0) {
                return WriteBuffer.getAuthRequestContext(i) + 1;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void PlaceComponentResult(WriteBuffer writeBuffer, int i) {
            if (i == 0) {
                return;
            }
            int i2 = this.MyBillsEntityDataFactory;
            byte[] bArr = writeBuffer.PlaceComponentResult;
            int i3 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i3 + 1;
            bArr[i3] = (byte) (i2 & 255);
            writeBuffer.MyBillsEntityDataFactory(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getAuthRequestContext(long j) {
            if (j != 0) {
                return WriteBuffer.PlaceComponentResult(j) + 1;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void getAuthRequestContext(WriteBuffer writeBuffer, long j) {
            if (j == 0) {
                return;
            }
            int i = this.MyBillsEntityDataFactory;
            byte[] bArr = writeBuffer.PlaceComponentResult;
            int i2 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i2 + 1;
            bArr[i2] = (byte) (i & 255);
            while (((-128) & j) != 0) {
                byte[] bArr2 = writeBuffer.PlaceComponentResult;
                int i3 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i3 + 1;
                bArr2[i3] = (byte) (((byte) ((127 & j) | 128)) & 255);
                j >>>= 7;
            }
            byte[] bArr3 = writeBuffer.PlaceComponentResult;
            int i4 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i4 + 1;
            bArr3[i4] = (byte) (((byte) j) & 255);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class BooleanField extends Field {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static int KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            return z ? 2 : 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public BooleanField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, boolean z) {
            if (z) {
                int i = this.MyBillsEntityDataFactory;
                byte[] bArr = writeBuffer.PlaceComponentResult;
                int i2 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i2 + 1;
                bArr[i2] = (byte) (i & 255);
                byte[] bArr2 = writeBuffer.PlaceComponentResult;
                int i3 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i3 + 1;
                bArr2[i3] = 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean getAuthRequestContext(ReadBuffer readBuffer) {
            byte MyBillsEntityDataFactory = readBuffer.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory >= 0 && MyBillsEntityDataFactory <= 1) {
                return MyBillsEntityDataFactory == 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed: invalid boolean value at byte ");
            sb.append(readBuffer.BuiltInFictitiousFunctionClassFactory());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int MyBillsEntityDataFactory(int i) {
        return WriteBuffer.getAuthRequestContext(i) + 1 + i;
    }
}
