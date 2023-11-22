package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes3.dex */
public class MoveViewJob extends ViewPortJob {
    private static ObjectPool<MoveViewJob> KClassImpl$Data$declaredNonStaticMembers$2;

    static {
        ObjectPool<MoveViewJob> PlaceComponentResult = ObjectPool.PlaceComponentResult(2, new MoveViewJob(null, 0.0f, 0.0f, null, null));
        KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        PlaceComponentResult.PlaceComponentResult = 0.5f;
    }

    public static MoveViewJob getAuthRequestContext(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        MoveViewJob PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1 = viewPortHandler;
        PlaceComponentResult.isLayoutRequested = f;
        PlaceComponentResult.newProxyInstance = f2;
        PlaceComponentResult.DatabaseTableConfigUtil = transformer;
        PlaceComponentResult.initRecordTimeStamp = view;
        return PlaceComponentResult;
    }

    private MoveViewJob(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        super(viewPortHandler, f, f2, transformer, view);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.GetContactSyncConfig[0] = this.isLayoutRequested;
        this.GetContactSyncConfig[1] = this.newProxyInstance;
        this.DatabaseTableConfigUtil.PlaceComponentResult(this.GetContactSyncConfig);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(this.GetContactSyncConfig, this.initRecordTimeStamp);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((ObjectPool<MoveViewJob>) this);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public final ObjectPool.Poolable MyBillsEntityDataFactory() {
        return new MoveViewJob(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.isLayoutRequested, this.newProxyInstance, this.DatabaseTableConfigUtil, this.initRecordTimeStamp);
    }
}
