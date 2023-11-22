package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;

/* loaded from: classes6.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private int BuiltInFictitiousFunctionClassFactory;
    private byte[] MyBillsEntityDataFactory;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public ArrayReadWriteBuf(int i) {
        this(new byte[i]);
    }

    private ArrayReadWriteBuf(byte[] bArr) {
        this.MyBillsEntityDataFactory = bArr;
        this.BuiltInFictitiousFunctionClassFactory = 0;
    }

    public ArrayReadWriteBuf(byte[] bArr, byte b) {
        this.MyBillsEntityDataFactory = bArr;
        this.BuiltInFictitiousFunctionClassFactory = 1;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final byte BuiltInFictitiousFunctionClassFactory(int i) {
        return this.MyBillsEntityDataFactory[i];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final short NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        byte[] bArr = this.MyBillsEntityDataFactory;
        return (short) ((bArr[i] & 255) | (bArr[i + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        byte[] bArr = this.MyBillsEntityDataFactory;
        return (bArr[i] & 255) | (bArr[i + 3] << Ascii.CAN) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final long MyBillsEntityDataFactory(int i) {
        byte[] bArr = this.MyBillsEntityDataFactory;
        int i2 = i + 1;
        long j = bArr[i];
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        long j3 = bArr[i3];
        int i5 = i4 + 1;
        long j4 = bArr[i4];
        long j5 = bArr[i5];
        int i6 = i5 + 1 + 1;
        return (bArr[i6 + 1] << 56) | (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((j5 & 255) << 32) | ((bArr[r2] & 255) << 40) | ((bArr[i6] & 255) << 48);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final float getAuthRequestContext(int i) {
        return Float.intBitsToFloat(KClassImpl$Data$declaredNonStaticMembers$2(i));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final double PlaceComponentResult(int i) {
        return Double.longBitsToDouble(MyBillsEntityDataFactory(i));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final String BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        return Utf8Safe.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, i, i2);
    }
}
