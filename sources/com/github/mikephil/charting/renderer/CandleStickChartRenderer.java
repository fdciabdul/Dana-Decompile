package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes7.dex */
public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
    private float[] BuiltInFictitiousFunctionClassFactory;
    private float[] GetContactSyncConfig;
    private float[] KClassImpl$Data$declaredNonStaticMembers$2;
    protected CandleDataProvider MyBillsEntityDataFactory;
    private float[] PlaceComponentResult;
    private float[] getAuthRequestContext;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void getAuthRequestContext(Canvas canvas) {
    }

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.GetContactSyncConfig = new float[8];
        this.PlaceComponentResult = new float[4];
        this.getAuthRequestContext = new float[4];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new float[4];
        this.BuiltInFictitiousFunctionClassFactory = new float[4];
        this.MyBillsEntityDataFactory = candleDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        int errorConfigVersion;
        int lookAheadTest;
        int errorConfigVersion2;
        int MyBillsEntityDataFactory;
        int authRequestContext;
        for (T t : this.MyBillsEntityDataFactory.getCandleData().BuiltInFictitiousFunctionClassFactory()) {
            if (t.whenAvailable()) {
                Transformer transformer = this.MyBillsEntityDataFactory.getTransformer(t.scheduleImpl());
                float MyBillsEntityDataFactory2 = this.scheduleImpl.MyBillsEntityDataFactory();
                float PlaceComponentResult = t.PlaceComponentResult();
                boolean B = t.B();
                this.getErrorConfigVersion.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, t);
                this.lookAheadTest.setStrokeWidth(t.A());
                for (int i = this.getErrorConfigVersion.PlaceComponentResult; i <= this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 + this.getErrorConfigVersion.PlaceComponentResult; i++) {
                    CandleEntry candleEntry = (CandleEntry) t.getErrorConfigVersion(i);
                    if (candleEntry != null) {
                        float MyBillsEntityDataFactory3 = candleEntry.MyBillsEntityDataFactory();
                        float f = candleEntry.PlaceComponentResult;
                        float f2 = candleEntry.BuiltInFictitiousFunctionClassFactory;
                        float f3 = candleEntry.getAuthRequestContext;
                        float f4 = candleEntry.MyBillsEntityDataFactory;
                        if (B) {
                            float[] fArr = this.GetContactSyncConfig;
                            fArr[0] = MyBillsEntityDataFactory3;
                            fArr[2] = MyBillsEntityDataFactory3;
                            fArr[4] = MyBillsEntityDataFactory3;
                            fArr[6] = MyBillsEntityDataFactory3;
                            if (f > f2) {
                                fArr[1] = f3 * MyBillsEntityDataFactory2;
                                fArr[3] = f * MyBillsEntityDataFactory2;
                                fArr[5] = f4 * MyBillsEntityDataFactory2;
                                fArr[7] = f2 * MyBillsEntityDataFactory2;
                            } else if (f < f2) {
                                fArr[1] = f3 * MyBillsEntityDataFactory2;
                                fArr[3] = f2 * MyBillsEntityDataFactory2;
                                fArr[5] = f4 * MyBillsEntityDataFactory2;
                                fArr[7] = f * MyBillsEntityDataFactory2;
                            } else {
                                fArr[1] = f3 * MyBillsEntityDataFactory2;
                                float f5 = f * MyBillsEntityDataFactory2;
                                fArr[3] = f5;
                                fArr[5] = f4 * MyBillsEntityDataFactory2;
                                fArr[7] = f5;
                            }
                            transformer.PlaceComponentResult(fArr);
                            if (!t.SubSequence()) {
                                Paint paint = this.lookAheadTest;
                                if (t.lookAheadTest() == 1122867) {
                                    lookAheadTest = t.PlaceComponentResult(i);
                                } else {
                                    lookAheadTest = t.lookAheadTest();
                                }
                                paint.setColor(lookAheadTest);
                            } else if (f > f2) {
                                Paint paint2 = this.lookAheadTest;
                                if (t.getAuthRequestContext() == 1122867) {
                                    authRequestContext = t.PlaceComponentResult(i);
                                } else {
                                    authRequestContext = t.getAuthRequestContext();
                                }
                                paint2.setColor(authRequestContext);
                            } else if (f < f2) {
                                Paint paint3 = this.lookAheadTest;
                                if (t.MyBillsEntityDataFactory() == 1122867) {
                                    MyBillsEntityDataFactory = t.PlaceComponentResult(i);
                                } else {
                                    MyBillsEntityDataFactory = t.MyBillsEntityDataFactory();
                                }
                                paint3.setColor(MyBillsEntityDataFactory);
                            } else {
                                Paint paint4 = this.lookAheadTest;
                                if (t.getErrorConfigVersion() == 1122867) {
                                    errorConfigVersion2 = t.PlaceComponentResult(i);
                                } else {
                                    errorConfigVersion2 = t.getErrorConfigVersion();
                                }
                                paint4.setColor(errorConfigVersion2);
                            }
                            this.lookAheadTest.setStyle(Paint.Style.STROKE);
                            canvas.drawLines(this.GetContactSyncConfig, this.lookAheadTest);
                            float[] fArr2 = this.PlaceComponentResult;
                            fArr2[0] = (MyBillsEntityDataFactory3 - 0.5f) + PlaceComponentResult;
                            fArr2[1] = f2 * MyBillsEntityDataFactory2;
                            fArr2[2] = (MyBillsEntityDataFactory3 + 0.5f) - PlaceComponentResult;
                            fArr2[3] = f * MyBillsEntityDataFactory2;
                            transformer.PlaceComponentResult(fArr2);
                            if (f > f2) {
                                if (t.getAuthRequestContext() == 1122867) {
                                    this.lookAheadTest.setColor(t.PlaceComponentResult(i));
                                } else {
                                    this.lookAheadTest.setColor(t.getAuthRequestContext());
                                }
                                this.lookAheadTest.setStyle(t.BuiltInFictitiousFunctionClassFactory());
                                float[] fArr3 = this.PlaceComponentResult;
                                canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.lookAheadTest);
                            } else if (f < f2) {
                                if (t.MyBillsEntityDataFactory() == 1122867) {
                                    this.lookAheadTest.setColor(t.PlaceComponentResult(i));
                                } else {
                                    this.lookAheadTest.setColor(t.MyBillsEntityDataFactory());
                                }
                                this.lookAheadTest.setStyle(t.KClassImpl$Data$declaredNonStaticMembers$2());
                                float[] fArr4 = this.PlaceComponentResult;
                                canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.lookAheadTest);
                            } else {
                                if (t.getErrorConfigVersion() == 1122867) {
                                    this.lookAheadTest.setColor(t.PlaceComponentResult(i));
                                } else {
                                    this.lookAheadTest.setColor(t.getErrorConfigVersion());
                                }
                                float[] fArr5 = this.PlaceComponentResult;
                                canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.lookAheadTest);
                            }
                        } else {
                            float[] fArr6 = this.getAuthRequestContext;
                            fArr6[0] = MyBillsEntityDataFactory3;
                            fArr6[1] = f3 * MyBillsEntityDataFactory2;
                            fArr6[2] = MyBillsEntityDataFactory3;
                            fArr6[3] = f4 * MyBillsEntityDataFactory2;
                            float[] fArr7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            fArr7[0] = (MyBillsEntityDataFactory3 - 0.5f) + PlaceComponentResult;
                            float f6 = f * MyBillsEntityDataFactory2;
                            fArr7[1] = f6;
                            fArr7[2] = MyBillsEntityDataFactory3;
                            fArr7[3] = f6;
                            float[] fArr8 = this.BuiltInFictitiousFunctionClassFactory;
                            fArr8[0] = (0.5f + MyBillsEntityDataFactory3) - PlaceComponentResult;
                            float f7 = f2 * MyBillsEntityDataFactory2;
                            fArr8[1] = f7;
                            fArr8[2] = MyBillsEntityDataFactory3;
                            fArr8[3] = f7;
                            transformer.PlaceComponentResult(fArr6);
                            transformer.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
                            transformer.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
                            if (f > f2) {
                                if (t.getAuthRequestContext() == 1122867) {
                                    errorConfigVersion = t.PlaceComponentResult(i);
                                } else {
                                    errorConfigVersion = t.getAuthRequestContext();
                                }
                            } else if (f < f2) {
                                if (t.MyBillsEntityDataFactory() == 1122867) {
                                    errorConfigVersion = t.PlaceComponentResult(i);
                                } else {
                                    errorConfigVersion = t.MyBillsEntityDataFactory();
                                }
                            } else if (t.getErrorConfigVersion() == 1122867) {
                                errorConfigVersion = t.PlaceComponentResult(i);
                            } else {
                                errorConfigVersion = t.getErrorConfigVersion();
                            }
                            this.lookAheadTest.setColor(errorConfigVersion);
                            float[] fArr9 = this.getAuthRequestContext;
                            canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.lookAheadTest);
                            float[] fArr10 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.lookAheadTest);
                            float[] fArr11 = this.BuiltInFictitiousFunctionClassFactory;
                            canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.lookAheadTest);
                        }
                    }
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory)) {
            List<T> BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.getCandleData().BuiltInFictitiousFunctionClassFactory();
            for (int i = 0; i < BuiltInFictitiousFunctionClassFactory.size(); i++) {
                ICandleDataSet iCandleDataSet = (ICandleDataSet) BuiltInFictitiousFunctionClassFactory.get(i);
                if (BuiltInFictitiousFunctionClassFactory(iCandleDataSet) && iCandleDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() > 0) {
                    PlaceComponentResult(iCandleDataSet);
                    Transformer transformer = this.MyBillsEntityDataFactory.getTransformer(iCandleDataSet.scheduleImpl());
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, iCandleDataSet);
                    float[] authRequestContext = transformer.getAuthRequestContext(iCandleDataSet, this.scheduleImpl.PlaceComponentResult(), this.scheduleImpl.MyBillsEntityDataFactory(), this.getErrorConfigVersion.PlaceComponentResult, this.getErrorConfigVersion.getAuthRequestContext);
                    float PlaceComponentResult = Utils.PlaceComponentResult(5.0f);
                    ValueFormatter NetworkUserEntityData$$ExternalSyntheticLambda7 = iCandleDataSet.NetworkUserEntityData$$ExternalSyntheticLambda7();
                    MPPointF authRequestContext2 = MPPointF.getAuthRequestContext(iCandleDataSet.PrepareContext());
                    authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2);
                    authRequestContext2.PlaceComponentResult = Utils.PlaceComponentResult(authRequestContext2.PlaceComponentResult);
                    for (int i2 = 0; i2 < authRequestContext.length; i2 += 2) {
                        float f = authRequestContext[i2];
                        float f2 = authRequestContext[i2 + 1];
                        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(f)) {
                            break;
                        }
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(f) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(f2)) {
                            int i3 = i2 / 2;
                            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getErrorConfigVersion(this.getErrorConfigVersion.PlaceComponentResult + i3);
                            if (iCandleDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(iCandleDataSet.getAuthRequestContext(i3));
                                canvas.drawText(NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(candleEntry.getAuthRequestContext), f, f2 - PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                            }
                            if (candleEntry.lookAheadTest != null && iCandleDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                Drawable drawable = candleEntry.lookAheadTest;
                                Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable, (int) (f + authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2), (int) (f2 + authRequestContext2.PlaceComponentResult), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                            }
                        }
                    }
                    MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext2);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr) {
        CandleData candleData = this.MyBillsEntityDataFactory.getCandleData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (ICandleDataSet) candleData.MyBillsEntityDataFactory(highlight.MyBillsEntityDataFactory);
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                CandleEntry candleEntry = (CandleEntry) iLineScatterCandleRadarDataSet.getAuthRequestContext(highlight.moveToNextValue, highlight.lookAheadTest);
                if (BuiltInFictitiousFunctionClassFactory(candleEntry, iLineScatterCandleRadarDataSet)) {
                    MPPointD BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.getTransformer(iLineScatterCandleRadarDataSet.scheduleImpl()).BuiltInFictitiousFunctionClassFactory(candleEntry.MyBillsEntityDataFactory(), ((candleEntry.MyBillsEntityDataFactory * this.scheduleImpl.MyBillsEntityDataFactory()) + (candleEntry.getAuthRequestContext * this.scheduleImpl.MyBillsEntityDataFactory())) / 2.0f);
                    float f = (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    float f2 = (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    highlight.PlaceComponentResult = f;
                    highlight.BuiltInFictitiousFunctionClassFactory = f2;
                    MyBillsEntityDataFactory(canvas, (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, iLineScatterCandleRadarDataSet);
                }
            }
        }
    }
}
