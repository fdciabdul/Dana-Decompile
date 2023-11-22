package androidx.text.emoji.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class MetadataList extends Table {
    public static MetadataList getAuthRequestContext(ByteBuffer byteBuffer) {
        MetadataList metadataList = new MetadataList();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        metadataList.PlaceComponentResult = byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position();
        metadataList.KClassImpl$Data$declaredNonStaticMembers$2 = byteBuffer;
        return metadataList;
    }

    public final int MyBillsEntityDataFactory() {
        int PlaceComponentResult = PlaceComponentResult(4);
        if (PlaceComponentResult != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(PlaceComponentResult + this.PlaceComponentResult);
        }
        return 0;
    }

    public final MetadataItem MyBillsEntityDataFactory(MetadataItem metadataItem, int i) {
        int PlaceComponentResult = PlaceComponentResult(6);
        if (PlaceComponentResult != 0) {
            return metadataItem.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext(PlaceComponentResult) + (i * 4)), this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return null;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        int PlaceComponentResult = PlaceComponentResult(6);
        if (PlaceComponentResult != 0) {
            return MyBillsEntityDataFactory(PlaceComponentResult);
        }
        return 0;
    }
}
