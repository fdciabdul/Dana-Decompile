package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes7.dex */
public class ZoomJob extends ViewPortJob {
    private static ObjectPool<ZoomJob> KClassImpl$Data$declaredNonStaticMembers$2;
    protected float BuiltInFictitiousFunctionClassFactory;
    protected Matrix MyBillsEntityDataFactory;
    protected YAxis.AxisDependency PlaceComponentResult;
    protected float getAuthRequestContext;

    static {
        ObjectPool<ZoomJob> PlaceComponentResult = ObjectPool.PlaceComponentResult(1, new ZoomJob());
        KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        PlaceComponentResult.PlaceComponentResult = 0.5f;
    }

    public static ZoomJob MyBillsEntityDataFactory(ViewPortHandler viewPortHandler, float f, float f2, float f3, float f4, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        ZoomJob PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
        PlaceComponentResult.isLayoutRequested = f3;
        PlaceComponentResult.newProxyInstance = f4;
        PlaceComponentResult.getAuthRequestContext = f;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = f2;
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1 = viewPortHandler;
        PlaceComponentResult.DatabaseTableConfigUtil = transformer;
        PlaceComponentResult.PlaceComponentResult = axisDependency;
        PlaceComponentResult.initRecordTimeStamp = view;
        return PlaceComponentResult;
    }

    private ZoomJob() {
        super(null, 0.0f, 0.0f, null, null);
        this.MyBillsEntityDataFactory = new Matrix();
        this.getAuthRequestContext = 0.0f;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.PlaceComponentResult = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = this.MyBillsEntityDataFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, matrix);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(matrix, this.initRecordTimeStamp, false);
        float f = ((BarLineChartBase) this.initRecordTimeStamp).getAxis(this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0 / this.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion;
        this.GetContactSyncConfig[0] = this.isLayoutRequested - ((((BarLineChartBase) this.initRecordTimeStamp).getXAxis().NetworkUserEntityData$$ExternalSyntheticLambda0 / this.NetworkUserEntityData$$ExternalSyntheticLambda1.scheduleImpl) / 2.0f);
        this.GetContactSyncConfig[1] = this.newProxyInstance + (f / 2.0f);
        this.DatabaseTableConfigUtil.PlaceComponentResult(this.GetContactSyncConfig);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(this.GetContactSyncConfig, matrix);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(matrix, this.initRecordTimeStamp, false);
        ((BarLineChartBase) this.initRecordTimeStamp).calculateOffsets();
        this.initRecordTimeStamp.postInvalidate();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((ObjectPool<ZoomJob>) this);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    public final ObjectPool.Poolable MyBillsEntityDataFactory() {
        return new ZoomJob();
    }
}
