package androidx.text.emoji.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class MetadataItem extends Table {
    public final int MyBillsEntityDataFactory() {
        int PlaceComponentResult = PlaceComponentResult(4);
        if (PlaceComponentResult != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(PlaceComponentResult + this.PlaceComponentResult);
        }
        return 0;
    }

    public final boolean PlaceComponentResult() {
        int PlaceComponentResult = PlaceComponentResult(6);
        return (PlaceComponentResult == 0 || this.KClassImpl$Data$declaredNonStaticMembers$2.get(PlaceComponentResult + this.PlaceComponentResult) == 0) ? false : true;
    }

    public final short getAuthRequestContext() {
        int PlaceComponentResult = PlaceComponentResult(8);
        if (PlaceComponentResult != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(PlaceComponentResult + this.PlaceComponentResult);
        }
        return (short) 0;
    }

    public final short NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int PlaceComponentResult = PlaceComponentResult(12);
        if (PlaceComponentResult != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(PlaceComponentResult + this.PlaceComponentResult);
        }
        return (short) 0;
    }

    public final short BuiltInFictitiousFunctionClassFactory() {
        int PlaceComponentResult = PlaceComponentResult(14);
        if (PlaceComponentResult != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getShort(PlaceComponentResult + this.PlaceComponentResult);
        }
        return (short) 0;
    }

    public final int BuiltInFictitiousFunctionClassFactory(int i) {
        int PlaceComponentResult = PlaceComponentResult(16);
        if (PlaceComponentResult != 0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getInt(getAuthRequestContext(PlaceComponentResult) + (i * 4));
        }
        return 0;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        int PlaceComponentResult = PlaceComponentResult(16);
        if (PlaceComponentResult != 0) {
            return MyBillsEntityDataFactory(PlaceComponentResult);
        }
        return 0;
    }

    public final MetadataItem KClassImpl$Data$declaredNonStaticMembers$2(int i, ByteBuffer byteBuffer) {
        this.PlaceComponentResult = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = byteBuffer;
        return this;
    }
}
