package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> BuiltInFictitiousFunctionClassFactory;
    public double getAuthRequestContext = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    public double KClassImpl$Data$declaredNonStaticMembers$2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    static {
        ObjectPool<MPPointD> PlaceComponentResult = ObjectPool.PlaceComponentResult(64, new MPPointD());
        BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
        PlaceComponentResult.PlaceComponentResult = 0.5f;
    }

    public static MPPointD KClassImpl$Data$declaredNonStaticMembers$2(double d, double d2) {
        MPPointD PlaceComponentResult = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        PlaceComponentResult.getAuthRequestContext = d;
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = d2;
        return PlaceComponentResult;
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected final ObjectPool.Poolable MyBillsEntityDataFactory() {
        return new MPPointD();
    }

    private MPPointD() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MPPointD, x: ");
        sb.append(this.getAuthRequestContext);
        sb.append(", y: ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        return sb.toString();
    }
}
