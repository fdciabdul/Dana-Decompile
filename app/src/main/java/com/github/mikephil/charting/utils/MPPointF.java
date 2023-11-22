package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;

/* loaded from: classes3.dex */
public class MPPointF extends ObjectPool.Poolable {
    public static final Parcelable.Creator<MPPointF> BuiltInFictitiousFunctionClassFactory;
    private static ObjectPool<MPPointF> MyBillsEntityDataFactory;
    public float KClassImpl$Data$declaredNonStaticMembers$2;
    public float PlaceComponentResult;

    static {
        ObjectPool<MPPointF> PlaceComponentResult = ObjectPool.PlaceComponentResult(32, new MPPointF(0.0f, 0.0f));
        MyBillsEntityDataFactory = PlaceComponentResult;
        PlaceComponentResult.PlaceComponentResult = 0.5f;
        BuiltInFictitiousFunctionClassFactory = new Parcelable.Creator<MPPointF>() { // from class: com.github.mikephil.charting.utils.MPPointF.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MPPointF createFromParcel(Parcel parcel) {
                MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
                mPPointF.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readFloat();
                mPPointF.PlaceComponentResult = parcel.readFloat();
                return mPPointF;
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MPPointF[] newArray(int i) {
                return new MPPointF[i];
            }
        };
    }

    public MPPointF() {
    }

    public MPPointF(float f, float f2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        this.PlaceComponentResult = f2;
    }

    public static MPPointF getAuthRequestContext(float f, float f2) {
        MPPointF PlaceComponentResult = MyBillsEntityDataFactory.PlaceComponentResult();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        PlaceComponentResult.PlaceComponentResult = f2;
        return PlaceComponentResult;
    }

    public static MPPointF getAuthRequestContext(MPPointF mPPointF) {
        MPPointF PlaceComponentResult = MyBillsEntityDataFactory.PlaceComponentResult();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = mPPointF.KClassImpl$Data$declaredNonStaticMembers$2;
        PlaceComponentResult.PlaceComponentResult = mPPointF.PlaceComponentResult;
        return PlaceComponentResult;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MPPointF mPPointF) {
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointF>) mPPointF);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected final ObjectPool.Poolable MyBillsEntityDataFactory() {
        return new MPPointF(0.0f, 0.0f);
    }
}
