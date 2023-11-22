package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.InstrumentInjector;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes7.dex */
public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider BuiltInFictitiousFunctionClassFactory;
    float[] PlaceComponentResult;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void getAuthRequestContext(Canvas canvas) {
    }

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.PlaceComponentResult = new float[2];
        this.BuiltInFictitiousFunctionClassFactory = scatterDataProvider;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        for (T t : this.BuiltInFictitiousFunctionClassFactory.getScatterData().BuiltInFictitiousFunctionClassFactory()) {
            if (t.whenAvailable() && t.BottomSheetCardBindingView$watcherCardNumberView$1() > 0) {
                ViewPortHandler viewPortHandler = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                Transformer transformer = this.BuiltInFictitiousFunctionClassFactory.getTransformer(t.scheduleImpl());
                float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
                IShapeRenderer MyBillsEntityDataFactory2 = t.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory2 == null) {
                    InstrumentInjector.log_i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
                } else {
                    int min = (int) Math.min(Math.ceil(t.BottomSheetCardBindingView$watcherCardNumberView$1() * this.scheduleImpl.PlaceComponentResult()), t.BottomSheetCardBindingView$watcherCardNumberView$1());
                    for (int i = 0; i < min; i++) {
                        ?? errorConfigVersion = t.getErrorConfigVersion(i);
                        this.PlaceComponentResult[0] = errorConfigVersion.MyBillsEntityDataFactory();
                        this.PlaceComponentResult[1] = errorConfigVersion.getAuthRequestContext() * MyBillsEntityDataFactory;
                        transformer.PlaceComponentResult(this.PlaceComponentResult);
                        if (viewPortHandler.MyBillsEntityDataFactory(this.PlaceComponentResult[0])) {
                            if (viewPortHandler.getAuthRequestContext(this.PlaceComponentResult[0]) && viewPortHandler.getErrorConfigVersion(this.PlaceComponentResult[1])) {
                                this.lookAheadTest.setColor(t.PlaceComponentResult(i / 2));
                                ViewPortHandler viewPortHandler2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                                float[] fArr = this.PlaceComponentResult;
                                MyBillsEntityDataFactory2.PlaceComponentResult(canvas, t, fArr[0], fArr[1], this.lookAheadTest);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r12v4, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory)) {
            List<T> BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getScatterData().BuiltInFictitiousFunctionClassFactory();
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.getScatterData().KClassImpl$Data$declaredNonStaticMembers$2(); i++) {
                IScatterDataSet iScatterDataSet = (IScatterDataSet) BuiltInFictitiousFunctionClassFactory.get(i);
                if (BuiltInFictitiousFunctionClassFactory(iScatterDataSet) && iScatterDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() > 0) {
                    PlaceComponentResult(iScatterDataSet);
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, iScatterDataSet);
                    float[] KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iScatterDataSet.scheduleImpl()).KClassImpl$Data$declaredNonStaticMembers$2(iScatterDataSet, this.scheduleImpl.PlaceComponentResult(), this.scheduleImpl.MyBillsEntityDataFactory(), this.getErrorConfigVersion.PlaceComponentResult, this.getErrorConfigVersion.getAuthRequestContext);
                    float PlaceComponentResult = Utils.PlaceComponentResult(iScatterDataSet.BuiltInFictitiousFunctionClassFactory());
                    ValueFormatter NetworkUserEntityData$$ExternalSyntheticLambda7 = iScatterDataSet.NetworkUserEntityData$$ExternalSyntheticLambda7();
                    MPPointF authRequestContext = MPPointF.getAuthRequestContext(iScatterDataSet.PrepareContext());
                    authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
                    authRequestContext.PlaceComponentResult = Utils.PlaceComponentResult(authRequestContext.PlaceComponentResult);
                    for (int i2 = 0; i2 < KClassImpl$Data$declaredNonStaticMembers$2.length && this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2[i2]); i2 += 2) {
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2[i2])) {
                            int i3 = i2 + 1;
                            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(KClassImpl$Data$declaredNonStaticMembers$2[i3])) {
                                int i4 = i2 / 2;
                                ?? errorConfigVersion = iScatterDataSet.getErrorConfigVersion(this.getErrorConfigVersion.PlaceComponentResult + i4);
                                if (iScatterDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                    String MyBillsEntityDataFactory = NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(errorConfigVersion.getAuthRequestContext());
                                    float f = KClassImpl$Data$declaredNonStaticMembers$2[i2];
                                    float f2 = KClassImpl$Data$declaredNonStaticMembers$2[i3] - PlaceComponentResult;
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(iScatterDataSet.getAuthRequestContext(i4 + this.getErrorConfigVersion.PlaceComponentResult));
                                    canvas.drawText(MyBillsEntityDataFactory, f, f2, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                }
                                if (errorConfigVersion.lookAheadTest != null && iScatterDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                    Drawable drawable = errorConfigVersion.lookAheadTest;
                                    Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable, (int) (KClassImpl$Data$declaredNonStaticMembers$2[i2] + authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2), (int) (KClassImpl$Data$declaredNonStaticMembers$2[i3] + authRequestContext.PlaceComponentResult), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                }
                            }
                        }
                    }
                    MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.BuiltInFictitiousFunctionClassFactory.getScatterData();
        for (Highlight highlight : highlightArr) {
            IScatterDataSet iScatterDataSet = (IScatterDataSet) scatterData.MyBillsEntityDataFactory(highlight.MyBillsEntityDataFactory);
            if (iScatterDataSet != null && iScatterDataSet.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                ?? authRequestContext = iScatterDataSet.getAuthRequestContext(highlight.moveToNextValue, highlight.lookAheadTest);
                if (BuiltInFictitiousFunctionClassFactory(authRequestContext, iScatterDataSet)) {
                    MPPointD BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iScatterDataSet.scheduleImpl()).BuiltInFictitiousFunctionClassFactory(authRequestContext.MyBillsEntityDataFactory(), authRequestContext.getAuthRequestContext() * this.scheduleImpl.MyBillsEntityDataFactory());
                    float f = (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    float f2 = (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    highlight.PlaceComponentResult = f;
                    highlight.BuiltInFictitiousFunctionClassFactory = f2;
                    MyBillsEntityDataFactory(canvas, (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, iScatterDataSet);
                }
            }
        }
    }
}
