package zipkin2.internal;

/* loaded from: classes6.dex */
final class ThriftField {
    final int MyBillsEntityDataFactory;
    final byte PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThriftField(byte b, int i) {
        this.PlaceComponentResult = b;
        this.MyBillsEntityDataFactory = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(WriteBuffer writeBuffer) {
        byte b = this.PlaceComponentResult;
        byte[] bArr = writeBuffer.PlaceComponentResult;
        int i = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i + 1;
        bArr[i] = (byte) (b & 255);
        int i2 = (this.MyBillsEntityDataFactory >>> 8) & 255;
        byte[] bArr2 = writeBuffer.PlaceComponentResult;
        int i3 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i3 + 1;
        bArr2[i3] = (byte) (i2 & 255);
        int i4 = this.MyBillsEntityDataFactory & 255;
        byte[] bArr3 = writeBuffer.PlaceComponentResult;
        int i5 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i5 + 1;
        bArr3[i5] = (byte) (i4 & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThriftField KClassImpl$Data$declaredNonStaticMembers$2(ReadBuffer readBuffer) {
        byte MyBillsEntityDataFactory = readBuffer.MyBillsEntityDataFactory();
        return new ThriftField(MyBillsEntityDataFactory, MyBillsEntityDataFactory == 0 ? (short) 0 : readBuffer.NetworkUserEntityData$$ExternalSyntheticLambda0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(ThriftField thriftField) {
        return this.PlaceComponentResult == thriftField.PlaceComponentResult && this.MyBillsEntityDataFactory == thriftField.MyBillsEntityDataFactory;
    }
}
