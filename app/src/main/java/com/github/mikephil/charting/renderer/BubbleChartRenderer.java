package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes7.dex */
public class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected BubbleDataProvider BuiltInFictitiousFunctionClassFactory;
    private float[] KClassImpl$Data$declaredNonStaticMembers$2;
    private float[] MyBillsEntityDataFactory;
    private float[] PlaceComponentResult;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void getAuthRequestContext(Canvas canvas) {
    }

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.PlaceComponentResult = new float[4];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new float[2];
        this.MyBillsEntityDataFactory = new float[3];
        this.BuiltInFictitiousFunctionClassFactory = bubbleDataProvider;
        this.lookAheadTest.setStyle(Paint.Style.FILL);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStyle(Paint.Style.STROKE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeWidth(Utils.PlaceComponentResult(1.5f));
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        for (T t : this.BuiltInFictitiousFunctionClassFactory.getBubbleData().BuiltInFictitiousFunctionClassFactory()) {
            if (t.whenAvailable() && t.BottomSheetCardBindingView$watcherCardNumberView$1() > 0) {
                Transformer transformer = this.BuiltInFictitiousFunctionClassFactory.getTransformer(t.scheduleImpl());
                float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
                this.getErrorConfigVersion.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, t);
                float[] fArr = this.PlaceComponentResult;
                fArr[0] = 0.0f;
                fArr[2] = 1.0f;
                transformer.PlaceComponentResult(fArr);
                boolean MyBillsEntityDataFactory2 = t.MyBillsEntityDataFactory();
                float[] fArr2 = this.PlaceComponentResult;
                float min = Math.min(Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory() - this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue()), Math.abs(fArr2[2] - fArr2[0]));
                for (int i = this.getErrorConfigVersion.PlaceComponentResult; i <= this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 + this.getErrorConfigVersion.PlaceComponentResult; i++) {
                    BubbleEntry bubbleEntry = (BubbleEntry) t.getErrorConfigVersion(i);
                    this.KClassImpl$Data$declaredNonStaticMembers$2[0] = bubbleEntry.MyBillsEntityDataFactory();
                    this.KClassImpl$Data$declaredNonStaticMembers$2[1] = bubbleEntry.getAuthRequestContext() * MyBillsEntityDataFactory;
                    transformer.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    float BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(bubbleEntry.MyBillsEntityDataFactory, t.BuiltInFictitiousFunctionClassFactory(), min, MyBillsEntityDataFactory2) / 2.0f;
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2[1] + BuiltInFictitiousFunctionClassFactory) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2[1] - BuiltInFictitiousFunctionClassFactory) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2[0] + BuiltInFictitiousFunctionClassFactory)) {
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2[0] - BuiltInFictitiousFunctionClassFactory)) {
                            this.lookAheadTest.setColor(t.PlaceComponentResult((int) bubbleEntry.MyBillsEntityDataFactory()));
                            float[] fArr3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            canvas.drawCircle(fArr3[0], fArr3[1], BuiltInFictitiousFunctionClassFactory, this.lookAheadTest);
                        }
                    }
                }
            }
        }
    }

    private static float BuiltInFictitiousFunctionClassFactory(float f, float f2, float f3, boolean z) {
        if (z) {
            f = f2 == 0.0f ? 1.0f : (float) Math.sqrt(f / f2);
        }
        return f3 * f;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        List list;
        List list2;
        BubbleData bubbleData = this.BuiltInFictitiousFunctionClassFactory.getBubbleData();
        if (bubbleData != null && KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory)) {
            List BuiltInFictitiousFunctionClassFactory = bubbleData.BuiltInFictitiousFunctionClassFactory();
            float authRequestContext = Utils.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda2, "1");
            int i = 0;
            while (i < BuiltInFictitiousFunctionClassFactory.size()) {
                IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) BuiltInFictitiousFunctionClassFactory.get(i);
                if (!BuiltInFictitiousFunctionClassFactory(iBubbleDataSet) || iBubbleDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() <= 0) {
                    list = BuiltInFictitiousFunctionClassFactory;
                } else {
                    PlaceComponentResult(iBubbleDataSet);
                    float max = Math.max(0.0f, Math.min(1.0f, this.scheduleImpl.PlaceComponentResult()));
                    float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, iBubbleDataSet);
                    float[] KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iBubbleDataSet.scheduleImpl()).KClassImpl$Data$declaredNonStaticMembers$2(iBubbleDataSet, MyBillsEntityDataFactory, this.getErrorConfigVersion.PlaceComponentResult, this.getErrorConfigVersion.getAuthRequestContext);
                    if (max == 1.0f) {
                        max = MyBillsEntityDataFactory;
                    }
                    ValueFormatter NetworkUserEntityData$$ExternalSyntheticLambda7 = iBubbleDataSet.NetworkUserEntityData$$ExternalSyntheticLambda7();
                    MPPointF authRequestContext2 = MPPointF.getAuthRequestContext(iBubbleDataSet.PrepareContext());
                    authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2);
                    authRequestContext2.PlaceComponentResult = Utils.PlaceComponentResult(authRequestContext2.PlaceComponentResult);
                    int i2 = 0;
                    while (i2 < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                        int i3 = i2 / 2;
                        int authRequestContext3 = iBubbleDataSet.getAuthRequestContext(this.getErrorConfigVersion.PlaceComponentResult + i3);
                        int argb = Color.argb(Math.round(255.0f * max), Color.red(authRequestContext3), Color.green(authRequestContext3), Color.blue(authRequestContext3));
                        float f = KClassImpl$Data$declaredNonStaticMembers$2[i2];
                        float f2 = KClassImpl$Data$declaredNonStaticMembers$2[i2 + 1];
                        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(f)) {
                            break;
                        }
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(f) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(f2)) {
                            BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getErrorConfigVersion(i3 + this.getErrorConfigVersion.PlaceComponentResult);
                            if (iBubbleDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                list2 = BuiltInFictitiousFunctionClassFactory;
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(argb);
                                canvas.drawText(NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(bubbleEntry.MyBillsEntityDataFactory), f, f2 + (0.5f * authRequestContext), this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                            } else {
                                list2 = BuiltInFictitiousFunctionClassFactory;
                            }
                            if (bubbleEntry.lookAheadTest != null && iBubbleDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                Drawable drawable = bubbleEntry.lookAheadTest;
                                Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable, (int) (f + authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2), (int) (f2 + authRequestContext2.PlaceComponentResult), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                            }
                        } else {
                            list2 = BuiltInFictitiousFunctionClassFactory;
                        }
                        i2 += 2;
                        BuiltInFictitiousFunctionClassFactory = list2;
                    }
                    list = BuiltInFictitiousFunctionClassFactory;
                    MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
                }
                i++;
                BuiltInFictitiousFunctionClassFactory = list;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr) {
        BubbleData bubbleData = this.BuiltInFictitiousFunctionClassFactory.getBubbleData();
        float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
        for (Highlight highlight : highlightArr) {
            IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) bubbleData.MyBillsEntityDataFactory(highlight.MyBillsEntityDataFactory);
            if (iBubbleDataSet != null && iBubbleDataSet.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getAuthRequestContext(highlight.moveToNextValue, highlight.lookAheadTest);
                if (bubbleEntry.getAuthRequestContext() == highlight.lookAheadTest && BuiltInFictitiousFunctionClassFactory(bubbleEntry, iBubbleDataSet)) {
                    Transformer transformer = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iBubbleDataSet.scheduleImpl());
                    float[] fArr = this.PlaceComponentResult;
                    fArr[0] = 0.0f;
                    fArr[2] = 1.0f;
                    transformer.PlaceComponentResult(fArr);
                    boolean MyBillsEntityDataFactory2 = iBubbleDataSet.MyBillsEntityDataFactory();
                    float[] fArr2 = this.PlaceComponentResult;
                    float min = Math.min(Math.abs(this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory() - this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue()), Math.abs(fArr2[2] - fArr2[0]));
                    this.KClassImpl$Data$declaredNonStaticMembers$2[0] = bubbleEntry.MyBillsEntityDataFactory();
                    this.KClassImpl$Data$declaredNonStaticMembers$2[1] = bubbleEntry.getAuthRequestContext() * MyBillsEntityDataFactory;
                    transformer.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    float[] fArr3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    float f = fArr3[0];
                    float f2 = fArr3[1];
                    highlight.PlaceComponentResult = f;
                    highlight.BuiltInFictitiousFunctionClassFactory = f2;
                    float BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(bubbleEntry.MyBillsEntityDataFactory, iBubbleDataSet.BuiltInFictitiousFunctionClassFactory(), min, MyBillsEntityDataFactory2) / 2.0f;
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2[1] + BuiltInFictitiousFunctionClassFactory) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2[1] - BuiltInFictitiousFunctionClassFactory) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2[0] + BuiltInFictitiousFunctionClassFactory)) {
                        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2[0] - BuiltInFictitiousFunctionClassFactory)) {
                            return;
                        }
                        int PlaceComponentResult = iBubbleDataSet.PlaceComponentResult((int) bubbleEntry.MyBillsEntityDataFactory());
                        Color.RGBToHSV(Color.red(PlaceComponentResult), Color.green(PlaceComponentResult), Color.blue(PlaceComponentResult), this.MyBillsEntityDataFactory);
                        float[] fArr4 = this.MyBillsEntityDataFactory;
                        fArr4[2] = fArr4[2] * 0.5f;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(Color.HSVToColor(Color.alpha(PlaceComponentResult), this.MyBillsEntityDataFactory));
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeWidth(iBubbleDataSet.KClassImpl$Data$declaredNonStaticMembers$2());
                        float[] fArr5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        canvas.drawCircle(fArr5[0], fArr5[1], BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    }
                }
            }
        }
    }
}
