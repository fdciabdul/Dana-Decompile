package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

/* loaded from: classes3.dex */
public final class FSize extends ObjectPool.Poolable {
    private static ObjectPool<FSize> KClassImpl$Data$declaredNonStaticMembers$2;
    public float BuiltInFictitiousFunctionClassFactory;
    public float PlaceComponentResult;

    static {
        ObjectPool<FSize> PlaceComponentResult = ObjectPool.PlaceComponentResult(256, new FSize((byte) 0));
        KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        PlaceComponentResult.PlaceComponentResult = 0.5f;
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected final ObjectPool.Poolable MyBillsEntityDataFactory() {
        return new FSize((byte) 0);
    }

    public static FSize MyBillsEntityDataFactory(float f, float f2) {
        FSize PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
        PlaceComponentResult.PlaceComponentResult = f;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = f2;
        return PlaceComponentResult;
    }

    public static void MyBillsEntityDataFactory(FSize fSize) {
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((ObjectPool<FSize>) fSize);
    }

    public FSize() {
    }

    private FSize(byte b) {
        this.PlaceComponentResult = 0.0f;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof FSize) {
            FSize fSize = (FSize) obj;
            return this.PlaceComponentResult == fSize.PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory == fSize.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.PlaceComponentResult);
        sb.append("x");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        return sb.toString();
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.PlaceComponentResult) ^ Float.floatToIntBits(this.BuiltInFictitiousFunctionClassFactory);
    }
}
