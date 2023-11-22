package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {
    protected List<Highlight> PlaceComponentResult = new ArrayList();
    protected T getAuthRequestContext;

    public ChartHighlighter(T t) {
        this.getAuthRequestContext = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MPPointD BuiltInFictitiousFunctionClassFactory(float f, float f2) {
        Transformer transformer = this.getAuthRequestContext.getTransformer(YAxis.AxisDependency.LEFT);
        MPPointD KClassImpl$Data$declaredNonStaticMembers$2 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        transformer.getAuthRequestContext(f, f2, KClassImpl$Data$declaredNonStaticMembers$2);
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Highlight getAuthRequestContext(float f, float f2, float f3) {
        List<Highlight> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(f, f2, f3);
        if (KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            return null;
        }
        return PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, f2, f3, PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, f3, YAxis.AxisDependency.LEFT) < PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, f3, YAxis.AxisDependency.RIGHT) ? YAxis.AxisDependency.LEFT : YAxis.AxisDependency.RIGHT, this.getAuthRequestContext.getMaxHighlightDistance());
    }

    private static float PlaceComponentResult(List<Highlight> list, float f, YAxis.AxisDependency axisDependency) {
        float f2 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Highlight highlight = list.get(i);
            if (highlight.KClassImpl$Data$declaredNonStaticMembers$2 == axisDependency) {
                float abs = Math.abs(highlight.scheduleImpl - f);
                if (abs < f2) {
                    f2 = abs;
                }
            }
        }
        return f2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    protected List<Highlight> KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3) {
        this.PlaceComponentResult.clear();
        BarLineScatterCandleBubbleData authRequestContext = getAuthRequestContext();
        if (authRequestContext == null) {
            return this.PlaceComponentResult;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        for (int i = 0; i < KClassImpl$Data$declaredNonStaticMembers$2; i++) {
            ?? MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory(i);
            if (MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                this.PlaceComponentResult.addAll(KClassImpl$Data$declaredNonStaticMembers$2((IDataSet) MyBillsEntityDataFactory, i, f, DataSet.Rounding.CLOSEST));
            }
        }
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Highlight> KClassImpl$Data$declaredNonStaticMembers$2(IDataSet iDataSet, int i, float f, DataSet.Rounding rounding) {
        Entry BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList();
        List<Entry> MyBillsEntityDataFactory = iDataSet.MyBillsEntityDataFactory(f);
        if (MyBillsEntityDataFactory.size() == 0 && (BuiltInFictitiousFunctionClassFactory = iDataSet.BuiltInFictitiousFunctionClassFactory(f, rounding)) != null) {
            MyBillsEntityDataFactory = iDataSet.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
        }
        if (MyBillsEntityDataFactory.size() == 0) {
            return arrayList;
        }
        for (Entry entry : MyBillsEntityDataFactory) {
            MPPointD BuiltInFictitiousFunctionClassFactory2 = this.getAuthRequestContext.getTransformer(iDataSet.scheduleImpl()).BuiltInFictitiousFunctionClassFactory(entry.MyBillsEntityDataFactory(), entry.getAuthRequestContext());
            arrayList.add(new Highlight(entry.MyBillsEntityDataFactory(), entry.getAuthRequestContext(), (float) BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext, (float) BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2, i, iDataSet.scheduleImpl()));
        }
        return arrayList;
    }

    private Highlight PlaceComponentResult(List<Highlight> list, float f, float f2, YAxis.AxisDependency axisDependency, float f3) {
        Highlight highlight = null;
        for (int i = 0; i < list.size(); i++) {
            Highlight highlight2 = list.get(i);
            if (axisDependency == null || highlight2.KClassImpl$Data$declaredNonStaticMembers$2 == axisDependency) {
                float KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(f, f2, highlight2.NetworkUserEntityData$$ExternalSyntheticLambda0, highlight2.scheduleImpl);
                if (KClassImpl$Data$declaredNonStaticMembers$2 < f3) {
                    highlight = highlight2;
                    f3 = KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }
        }
        return highlight;
    }

    protected float KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f - f3, f2 - f4);
    }

    protected BarLineScatterCandleBubbleData getAuthRequestContext() {
        return this.getAuthRequestContext.getData();
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight PlaceComponentResult(float f, float f2) {
        Transformer transformer = this.getAuthRequestContext.getTransformer(YAxis.AxisDependency.LEFT);
        MPPointD KClassImpl$Data$declaredNonStaticMembers$2 = MPPointD.KClassImpl$Data$declaredNonStaticMembers$2(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        transformer.getAuthRequestContext(f, f2, KClassImpl$Data$declaredNonStaticMembers$2);
        float f3 = (float) KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) KClassImpl$Data$declaredNonStaticMembers$2);
        return getAuthRequestContext(f3, f, f2);
    }
}
