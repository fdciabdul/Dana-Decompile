package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer MyBillsEntityDataFactory;

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final byte BuiltInFictitiousFunctionClassFactory(int i) {
        return this.MyBillsEntityDataFactory.get(i);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final short NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        return this.MyBillsEntityDataFactory.getShort(i);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return this.MyBillsEntityDataFactory.getInt(i);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final long MyBillsEntityDataFactory(int i) {
        return this.MyBillsEntityDataFactory.getLong(i);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final float getAuthRequestContext(int i) {
        return this.MyBillsEntityDataFactory.getFloat(i);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final double PlaceComponentResult(int i) {
        return this.MyBillsEntityDataFactory.getDouble(i);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public final String BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        return Utf8Safe.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, i, i2);
    }
}
