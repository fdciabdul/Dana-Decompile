package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes7.dex */
public class XAxisRendererRadarChart extends XAxisRenderer {
    private RadarChart DatabaseTableConfigUtil;

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public final void PlaceComponentResult(Canvas canvas) {
    }

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, null);
        this.DatabaseTableConfigUtil = radarChart;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public final void getAuthRequestContext(Canvas canvas) {
        if (this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda3() && this.GetContactSyncConfig.lookAheadTest()) {
            float NetworkUserEntityData$$ExternalSyntheticLambda6 = this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda6();
            MPPointF authRequestContext = MPPointF.getAuthRequestContext(0.5f, 0.25f);
            this.MyBillsEntityDataFactory.setTypeface(this.GetContactSyncConfig.PrepareContext());
            this.MyBillsEntityDataFactory.setTextSize(this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda7());
            this.MyBillsEntityDataFactory.setColor(this.GetContactSyncConfig.isLayoutRequested());
            float sliceAngle = this.DatabaseTableConfigUtil.getSliceAngle();
            float factor = this.DatabaseTableConfigUtil.getFactor();
            MPPointF centerOffsets = this.DatabaseTableConfigUtil.getCenterOffsets();
            MPPointF authRequestContext2 = MPPointF.getAuthRequestContext(0.0f, 0.0f);
            for (int i = 0; i < ((RadarData) this.DatabaseTableConfigUtil.getData()).getErrorConfigVersion().BottomSheetCardBindingView$watcherCardNumberView$1(); i++) {
                ValueFormatter PlaceComponentResult = this.GetContactSyncConfig.PlaceComponentResult();
                float f = i;
                XAxis xAxis = this.GetContactSyncConfig;
                String MyBillsEntityDataFactory = PlaceComponentResult.MyBillsEntityDataFactory(f);
                Utils.KClassImpl$Data$declaredNonStaticMembers$2(centerOffsets, (this.DatabaseTableConfigUtil.getYRange() * factor) + (this.GetContactSyncConfig.E / 2.0f), ((f * sliceAngle) + this.DatabaseTableConfigUtil.getRotationAngle()) % 360.0f, authRequestContext2);
                MyBillsEntityDataFactory(canvas, MyBillsEntityDataFactory, authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext2.PlaceComponentResult - (this.GetContactSyncConfig.D / 2.0f), authRequestContext, NetworkUserEntityData$$ExternalSyntheticLambda6);
            }
            MPPointF.BuiltInFictitiousFunctionClassFactory(centerOffsets);
            MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
            MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
        }
    }
}
