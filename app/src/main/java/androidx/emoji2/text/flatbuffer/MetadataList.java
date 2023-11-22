package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public final class MetadataList extends Table {

    /* loaded from: classes6.dex */
    public static final class Vector extends BaseVector {
    }

    public static MetadataList BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) {
        MetadataList metadataList = new MetadataList();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        metadataList.BuiltInFictitiousFunctionClassFactory(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
        return metadataList;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        int authRequestContext = getAuthRequestContext(4);
        if (authRequestContext != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext + this.BuiltInFictitiousFunctionClassFactory);
        }
        return 0;
    }

    public final MetadataItem KClassImpl$Data$declaredNonStaticMembers$2(MetadataItem metadataItem, int i) {
        int authRequestContext = getAuthRequestContext(6);
        if (authRequestContext != 0) {
            return metadataItem.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(authRequestContext) + (i * 4)), this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return null;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        int authRequestContext = getAuthRequestContext(6);
        if (authRequestContext != 0) {
            return KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        }
        return 0;
    }
}
