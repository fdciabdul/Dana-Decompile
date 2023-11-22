package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class LegendRenderer extends Renderer {
    protected Paint.FontMetrics BuiltInFictitiousFunctionClassFactory;
    protected Legend KClassImpl$Data$declaredNonStaticMembers$2;
    protected Paint MyBillsEntityDataFactory;
    protected Paint PlaceComponentResult;
    protected List<LegendEntry> getAuthRequestContext;
    private Path moveToNextValue;

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.getAuthRequestContext = new ArrayList(16);
        this.BuiltInFictitiousFunctionClassFactory = new Paint.FontMetrics();
        this.moveToNextValue = new Path();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = legend;
        Paint paint = new Paint(1);
        this.MyBillsEntityDataFactory = paint;
        paint.setTextSize(Utils.PlaceComponentResult(9.0f));
        this.MyBillsEntityDataFactory.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.PlaceComponentResult = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public final Paint BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    public final void PlaceComponentResult(ChartData<?> chartData) {
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory()) {
            this.getAuthRequestContext.clear();
            ChartData<?> chartData2 = chartData;
            for (int i = 0; i < chartData.KClassImpl$Data$declaredNonStaticMembers$2(); i++) {
                ?? MyBillsEntityDataFactory = chartData2.MyBillsEntityDataFactory(i);
                List<Integer> NetworkUserEntityData$$ExternalSyntheticLambda2 = MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2();
                int BottomSheetCardBindingView$watcherCardNumberView$1 = MyBillsEntityDataFactory.BottomSheetCardBindingView$watcherCardNumberView$1();
                if (MyBillsEntityDataFactory instanceof IBarDataSet) {
                    IBarDataSet iBarDataSet = (IBarDataSet) MyBillsEntityDataFactory;
                    if (iBarDataSet.lookAheadTest()) {
                        String[] BuiltInFictitiousFunctionClassFactory = iBarDataSet.BuiltInFictitiousFunctionClassFactory();
                        for (int i2 = 0; i2 < NetworkUserEntityData$$ExternalSyntheticLambda2.size() && i2 < iBarDataSet.getErrorConfigVersion(); i2++) {
                            this.getAuthRequestContext.add(new LegendEntry(BuiltInFictitiousFunctionClassFactory[i2 % BuiltInFictitiousFunctionClassFactory.length], MyBillsEntityDataFactory.DatabaseTableConfigUtil(), MyBillsEntityDataFactory.GetContactSyncConfig(), MyBillsEntityDataFactory.initRecordTimeStamp(), MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1(), NetworkUserEntityData$$ExternalSyntheticLambda2.get(i2).intValue()));
                        }
                        if (iBarDataSet.newProxyInstance() != null) {
                            this.getAuthRequestContext.add(new LegendEntry(MyBillsEntityDataFactory.newProxyInstance(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867));
                        }
                    }
                }
                if (MyBillsEntityDataFactory instanceof IPieDataSet) {
                    IPieDataSet iPieDataSet = (IPieDataSet) MyBillsEntityDataFactory;
                    for (int i3 = 0; i3 < NetworkUserEntityData$$ExternalSyntheticLambda2.size() && i3 < BottomSheetCardBindingView$watcherCardNumberView$1; i3++) {
                        this.getAuthRequestContext.add(new LegendEntry(iPieDataSet.getErrorConfigVersion(i3).MyBillsEntityDataFactory, MyBillsEntityDataFactory.DatabaseTableConfigUtil(), MyBillsEntityDataFactory.GetContactSyncConfig(), MyBillsEntityDataFactory.initRecordTimeStamp(), MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1(), NetworkUserEntityData$$ExternalSyntheticLambda2.get(i3).intValue()));
                    }
                    if (iPieDataSet.newProxyInstance() != null) {
                        this.getAuthRequestContext.add(new LegendEntry(MyBillsEntityDataFactory.newProxyInstance(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867));
                    }
                } else {
                    if (MyBillsEntityDataFactory instanceof ICandleDataSet) {
                        ICandleDataSet iCandleDataSet = (ICandleDataSet) MyBillsEntityDataFactory;
                        if (iCandleDataSet.getAuthRequestContext() != 1122867) {
                            int authRequestContext = iCandleDataSet.getAuthRequestContext();
                            int MyBillsEntityDataFactory2 = iCandleDataSet.MyBillsEntityDataFactory();
                            this.getAuthRequestContext.add(new LegendEntry(null, MyBillsEntityDataFactory.DatabaseTableConfigUtil(), MyBillsEntityDataFactory.GetContactSyncConfig(), MyBillsEntityDataFactory.initRecordTimeStamp(), MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1(), authRequestContext));
                            this.getAuthRequestContext.add(new LegendEntry(MyBillsEntityDataFactory.newProxyInstance(), MyBillsEntityDataFactory.DatabaseTableConfigUtil(), MyBillsEntityDataFactory.GetContactSyncConfig(), MyBillsEntityDataFactory.initRecordTimeStamp(), MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1(), MyBillsEntityDataFactory2));
                        }
                    }
                    int i4 = 0;
                    while (i4 < NetworkUserEntityData$$ExternalSyntheticLambda2.size() && i4 < BottomSheetCardBindingView$watcherCardNumberView$1) {
                        this.getAuthRequestContext.add(new LegendEntry((i4 >= NetworkUserEntityData$$ExternalSyntheticLambda2.size() + (-1) || i4 >= BottomSheetCardBindingView$watcherCardNumberView$1 + (-1)) ? chartData.MyBillsEntityDataFactory(i).newProxyInstance() : null, MyBillsEntityDataFactory.DatabaseTableConfigUtil(), MyBillsEntityDataFactory.GetContactSyncConfig(), MyBillsEntityDataFactory.initRecordTimeStamp(), MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1(), NetworkUserEntityData$$ExternalSyntheticLambda2.get(i4).intValue()));
                        i4++;
                    }
                }
                chartData2 = chartData;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                Collections.addAll(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            Legend legend = this.KClassImpl$Data$declaredNonStaticMembers$2;
            List<LegendEntry> list = this.getAuthRequestContext;
            legend.KClassImpl$Data$declaredNonStaticMembers$2 = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        }
        Typeface PrepareContext = this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext();
        if (PrepareContext != null) {
            this.MyBillsEntityDataFactory.setTypeface(PrepareContext);
        }
        this.MyBillsEntityDataFactory.setTextSize(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7());
        this.MyBillsEntityDataFactory.setColor(this.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested());
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
    }

    public final void getAuthRequestContext(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        List<Boolean> list;
        float f7;
        List<FSize> list2;
        Canvas canvas2;
        int i;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float moveToNextValue;
        float f14;
        float f15;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        float f16;
        float BuiltInFictitiousFunctionClassFactory;
        float lookAheadTest;
        float scheduleImpl;
        double d;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3()) {
            Typeface PrepareContext = this.KClassImpl$Data$declaredNonStaticMembers$2.PrepareContext();
            if (PrepareContext != null) {
                this.MyBillsEntityDataFactory.setTypeface(PrepareContext);
            }
            this.MyBillsEntityDataFactory.setTextSize(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7());
            this.MyBillsEntityDataFactory.setColor(this.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested());
            float MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
            float BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory) + Utils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6);
            float authRequestContext = MyBillsEntityDataFactory - (Utils.getAuthRequestContext(this.MyBillsEntityDataFactory, "ABC") / 2.0f);
            LegendEntry[] legendEntryArr = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            float PlaceComponentResult = Utils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl);
            float PlaceComponentResult2 = Utils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4);
            Legend.LegendOrientation legendOrientation = this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil;
            Legend.LegendHorizontalAlignment legendHorizontalAlignment = this.KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp;
            Legend.LegendVerticalAlignment legendVerticalAlignment = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7;
            Legend.LegendDirection legendDirection2 = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            float PlaceComponentResult3 = Utils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue);
            float PlaceComponentResult4 = Utils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance);
            float FragmentBottomSheetPaymentSettingBinding = this.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding();
            float newProxyInstance = this.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance();
            int i2 = AnonymousClass1.getAuthRequestContext[legendHorizontalAlignment.ordinal()];
            float f17 = PlaceComponentResult4;
            float f18 = PlaceComponentResult2;
            if (i2 != 1) {
                if (i2 == 2) {
                    f = MyBillsEntityDataFactory;
                    f2 = BuiltInFictitiousFunctionClassFactory2;
                    if (legendOrientation == Legend.LegendOrientation.VERTICAL) {
                        lookAheadTest = this.NetworkUserEntityData$$ExternalSyntheticLambda7.initRecordTimeStamp();
                    } else {
                        lookAheadTest = this.NetworkUserEntityData$$ExternalSyntheticLambda7.lookAheadTest();
                    }
                    f4 = lookAheadTest - newProxyInstance;
                    if (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f4 -= this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    }
                } else if (i2 != 3) {
                    f = MyBillsEntityDataFactory;
                    f2 = BuiltInFictitiousFunctionClassFactory2;
                    f3 = 0.0f;
                } else {
                    if (legendOrientation == Legend.LegendOrientation.VERTICAL) {
                        scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda7.initRecordTimeStamp() / 2.0f;
                    } else {
                        scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl() + (this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda0() / 2.0f);
                    }
                    f4 = scheduleImpl + (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT ? newProxyInstance : -newProxyInstance);
                    if (legendOrientation == Legend.LegendOrientation.VERTICAL) {
                        f2 = BuiltInFictitiousFunctionClassFactory2;
                        double d2 = f4;
                        if (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            f = MyBillsEntityDataFactory;
                            double d3 = -this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                            Double.isNaN(d3);
                            double d4 = newProxyInstance;
                            Double.isNaN(d4);
                            d = (d3 / 2.0d) + d4;
                        } else {
                            f = MyBillsEntityDataFactory;
                            double d5 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2;
                            Double.isNaN(d5);
                            double d6 = newProxyInstance;
                            Double.isNaN(d6);
                            d = (d5 / 2.0d) - d6;
                        }
                        Double.isNaN(d2);
                        f4 = (float) (d2 + d);
                    } else {
                        f = MyBillsEntityDataFactory;
                        f2 = BuiltInFictitiousFunctionClassFactory2;
                    }
                }
                f3 = f4;
            } else {
                f = MyBillsEntityDataFactory;
                f2 = BuiltInFictitiousFunctionClassFactory2;
                if (legendOrientation != Legend.LegendOrientation.VERTICAL) {
                    newProxyInstance += this.NetworkUserEntityData$$ExternalSyntheticLambda7.scheduleImpl();
                }
                if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                    f4 = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2 + newProxyInstance;
                    f3 = f4;
                } else {
                    f3 = newProxyInstance;
                }
            }
            int i3 = AnonymousClass1.PlaceComponentResult[legendOrientation.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = AnonymousClass1.MyBillsEntityDataFactory[legendVerticalAlignment.ordinal()];
                    if (i4 == 1) {
                        moveToNextValue = (legendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.NetworkUserEntityData$$ExternalSyntheticLambda7.moveToNextValue()) + FragmentBottomSheetPaymentSettingBinding;
                    } else if (i4 == 2) {
                        if (legendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                            BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda1();
                        } else {
                            BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory();
                        }
                        moveToNextValue = BuiltInFictitiousFunctionClassFactory - (this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 + FragmentBottomSheetPaymentSettingBinding);
                    } else {
                        moveToNextValue = i4 != 3 ? 0.0f : ((this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda1() / 2.0f) - (this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 / 2.0f)) + this.KClassImpl$Data$declaredNonStaticMembers$2.FragmentBottomSheetPaymentSettingBinding();
                    }
                    float f19 = moveToNextValue;
                    boolean z = false;
                    int i5 = 0;
                    float f20 = 0.0f;
                    while (i5 < legendEntryArr.length) {
                        LegendEntry legendEntry2 = legendEntryArr[i5];
                        boolean z2 = legendEntry2.BuiltInFictitiousFunctionClassFactory != Legend.LegendForm.NONE;
                        float PlaceComponentResult5 = Float.isNaN(legendEntry2.KClassImpl$Data$declaredNonStaticMembers$2) ? PlaceComponentResult3 : Utils.PlaceComponentResult(legendEntry2.KClassImpl$Data$declaredNonStaticMembers$2);
                        if (z2) {
                            f16 = legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT ? f3 + f20 : f3 - (PlaceComponentResult5 - f20);
                            f15 = f17;
                            f14 = authRequestContext;
                            legendDirection = legendDirection2;
                            BuiltInFictitiousFunctionClassFactory(canvas, f16, f19 + authRequestContext, legendEntry2, this.KClassImpl$Data$declaredNonStaticMembers$2);
                            if (legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                f16 += PlaceComponentResult5;
                            }
                            legendEntry = legendEntry2;
                        } else {
                            f14 = authRequestContext;
                            f15 = f17;
                            legendDirection = legendDirection2;
                            legendEntry = legendEntry2;
                            f16 = f3;
                        }
                        if (legendEntry.getErrorConfigVersion != null) {
                            if (z2 && !z) {
                                f16 += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? PlaceComponentResult : -PlaceComponentResult;
                            } else if (z) {
                                f16 = f3;
                            }
                            if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                f16 -= Utils.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, legendEntry.getErrorConfigVersion);
                            }
                            float f21 = f16;
                            if (!z) {
                                canvas.drawText(legendEntry.getErrorConfigVersion, f21, f19 + f, this.MyBillsEntityDataFactory);
                            } else {
                                f19 += f + f2;
                                canvas.drawText(legendEntry.getErrorConfigVersion, f21, f19 + f, this.MyBillsEntityDataFactory);
                            }
                            f19 += f + f2;
                            f20 = 0.0f;
                        } else {
                            f20 += PlaceComponentResult5 + f15;
                            z = true;
                        }
                        i5++;
                        f17 = f15;
                        legendDirection2 = legendDirection;
                        authRequestContext = f14;
                    }
                    return;
                }
                return;
            }
            float f22 = f17;
            List<FSize> list3 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
            List<FSize> list4 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            List<Boolean> list5 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
            int i6 = AnonymousClass1.MyBillsEntityDataFactory[legendVerticalAlignment.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    FragmentBottomSheetPaymentSettingBinding = (this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda1() - FragmentBottomSheetPaymentSettingBinding) - this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                } else {
                    FragmentBottomSheetPaymentSettingBinding = i6 != 3 ? 0.0f : FragmentBottomSheetPaymentSettingBinding + ((this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda1() - this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1) / 2.0f);
                }
            }
            int length = legendEntryArr.length;
            float f23 = f3;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length) {
                float f24 = f22;
                LegendEntry legendEntry3 = legendEntryArr[i7];
                int i9 = length;
                boolean z3 = legendEntry3.BuiltInFictitiousFunctionClassFactory != Legend.LegendForm.NONE;
                float PlaceComponentResult6 = Float.isNaN(legendEntry3.KClassImpl$Data$declaredNonStaticMembers$2) ? PlaceComponentResult3 : Utils.PlaceComponentResult(legendEntry3.KClassImpl$Data$declaredNonStaticMembers$2);
                if (i7 >= list5.size() || !list5.get(i7).booleanValue()) {
                    f5 = f23;
                    f6 = FragmentBottomSheetPaymentSettingBinding;
                } else {
                    f6 = FragmentBottomSheetPaymentSettingBinding + f + f2;
                    f5 = f3;
                }
                if (f5 == f3 && legendHorizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i8 < list3.size()) {
                    if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f13 = list3.get(i8).PlaceComponentResult;
                    } else {
                        f13 = -list3.get(i8).PlaceComponentResult;
                    }
                    f5 += f13 / 2.0f;
                    i8++;
                }
                int i10 = i8;
                boolean z4 = legendEntry3.getErrorConfigVersion == null;
                if (z3) {
                    if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f5 -= PlaceComponentResult6;
                    }
                    float f25 = f5;
                    f7 = f3;
                    i = i7;
                    list = list5;
                    list2 = list3;
                    canvas2 = canvas;
                    BuiltInFictitiousFunctionClassFactory(canvas, f25, f6 + authRequestContext, legendEntry3, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    f5 = legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT ? f25 + PlaceComponentResult6 : f25;
                } else {
                    list = list5;
                    f7 = f3;
                    list2 = list3;
                    canvas2 = canvas;
                    i = i7;
                }
                if (!z4) {
                    if (z3) {
                        f5 += legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT ? -PlaceComponentResult : PlaceComponentResult;
                    }
                    if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f5 -= list4.get(i).PlaceComponentResult;
                    }
                    canvas2.drawText(legendEntry3.getErrorConfigVersion, f5, f6 + f, this.MyBillsEntityDataFactory);
                    if (legendDirection2 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f5 += list4.get(i).PlaceComponentResult;
                    }
                    if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f8 = f18;
                        f12 = -f8;
                    } else {
                        f8 = f18;
                        f12 = f8;
                    }
                    f11 = f5 + f12;
                    f9 = f24;
                } else {
                    f8 = f18;
                    if (legendDirection2 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f9 = f24;
                        f10 = -f9;
                    } else {
                        f9 = f24;
                        f10 = f9;
                    }
                    f11 = f5 + f10;
                }
                f18 = f8;
                f22 = f9;
                i7 = i + 1;
                FragmentBottomSheetPaymentSettingBinding = f6;
                i8 = i10;
                f3 = f7;
                list5 = list;
                list3 = list2;
                f23 = f11;
                length = i9;
            }
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(Canvas canvas, float f, float f2, LegendEntry legendEntry, Legend legend) {
        float f3;
        float f4;
        DashPathEffect dashPathEffect;
        if (legendEntry.MyBillsEntityDataFactory == 1122868 || legendEntry.MyBillsEntityDataFactory == 1122867 || legendEntry.MyBillsEntityDataFactory == 0) {
            return;
        }
        int save = canvas.save();
        Legend.LegendForm legendForm = legendEntry.BuiltInFictitiousFunctionClassFactory;
        if (legendForm == Legend.LegendForm.DEFAULT) {
            legendForm = legend.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
        this.PlaceComponentResult.setColor(legendEntry.MyBillsEntityDataFactory);
        if (!Float.isNaN(legendEntry.KClassImpl$Data$declaredNonStaticMembers$2)) {
            f3 = legendEntry.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            f3 = legend.moveToNextValue;
        }
        float PlaceComponentResult = Utils.PlaceComponentResult(f3);
        float f5 = PlaceComponentResult / 2.0f;
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[legendForm.ordinal()];
        if (i == 3 || i == 4) {
            this.PlaceComponentResult.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f + f5, f2, f5, this.PlaceComponentResult);
        } else if (i == 5) {
            this.PlaceComponentResult.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, f2 - f5, f + PlaceComponentResult, f2 + f5, this.PlaceComponentResult);
        } else if (i == 6) {
            if (!Float.isNaN(legendEntry.getAuthRequestContext)) {
                f4 = legendEntry.getAuthRequestContext;
            } else {
                f4 = legend.lookAheadTest;
            }
            float PlaceComponentResult2 = Utils.PlaceComponentResult(f4);
            if (legendEntry.PlaceComponentResult != null) {
                dashPathEffect = legendEntry.PlaceComponentResult;
            } else {
                dashPathEffect = legend.getErrorConfigVersion;
            }
            this.PlaceComponentResult.setStyle(Paint.Style.STROKE);
            this.PlaceComponentResult.setStrokeWidth(PlaceComponentResult2);
            this.PlaceComponentResult.setPathEffect(dashPathEffect);
            this.moveToNextValue.reset();
            this.moveToNextValue.moveTo(f, f2);
            this.moveToNextValue.lineTo(f + PlaceComponentResult, f2);
            canvas.drawPath(this.moveToNextValue, this.PlaceComponentResult);
        }
        canvas.restoreToCount(save);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] MyBillsEntityDataFactory;
        static final /* synthetic */ int[] PlaceComponentResult;
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            PlaceComponentResult = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                PlaceComponentResult[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            MyBillsEntityDataFactory = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                MyBillsEntityDataFactory[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                MyBillsEntityDataFactory[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            getAuthRequestContext = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                getAuthRequestContext[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                getAuthRequestContext[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }
}
