package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class MetadataItem extends Table {

    /* loaded from: classes6.dex */
    public static final class Vector extends BaseVector {
    }

    public final int MyBillsEntityDataFactory() {
        int authRequestContext = getAuthRequestContext(4);
        if (authRequestContext != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext + this.BuiltInFictitiousFunctionClassFactory);
        }
        return 0;
    }

    public final boolean getAuthRequestContext() {
        int authRequestContext = getAuthRequestContext(6);
        return (authRequestContext == 0 || this.KClassImpl$Data$declaredNonStaticMembers$2.get(authRequestContext + this.BuiltInFictitiousFunctionClassFactory) == 0) ? false : true;
    }

    public final short PlaceComponentResult() {
        int authRequestContext = getAuthRequestContext(8);
        if (authRequestContext != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(authRequestContext + this.BuiltInFictitiousFunctionClassFactory);
        }
        return (short) 0;
    }

    public final short moveToNextValue() {
        int authRequestContext = getAuthRequestContext(12);
        if (authRequestContext != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(authRequestContext + this.BuiltInFictitiousFunctionClassFactory);
        }
        return (short) 0;
    }

    public final short KClassImpl$Data$declaredNonStaticMembers$2() {
        int authRequestContext = getAuthRequestContext(14);
        if (authRequestContext != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(authRequestContext + this.BuiltInFictitiousFunctionClassFactory);
        }
        return (short) 0;
    }

    public final int MyBillsEntityDataFactory(int i) {
        int authRequestContext = getAuthRequestContext(16);
        if (authRequestContext != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(PlaceComponentResult(authRequestContext) + (i * 4));
        }
        return 0;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        int authRequestContext = getAuthRequestContext(16);
        if (authRequestContext != 0) {
            return KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        }
        return 0;
    }

    public final MetadataItem MyBillsEntityDataFactory(int i, ByteBuffer byteBuffer) {
        BuiltInFictitiousFunctionClassFactory(i, byteBuffer);
        return this;
    }
}
