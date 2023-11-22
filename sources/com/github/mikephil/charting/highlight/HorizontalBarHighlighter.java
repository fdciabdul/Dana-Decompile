package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.ObjectPool;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class HorizontalBarHighlighter extends BarHighlighter {
    public HorizontalBarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public final Highlight PlaceComponentResult(float f, float f2) {
        BarData barData = ((BarDataProvider) this.getAuthRequestContext).getBarData();
        MPPointD BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(f2, f);
        Highlight authRequestContext = getAuthRequestContext((float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, f2, f);
        if (authRequestContext == null) {
            return null;
        }
        IBarDataSet iBarDataSet = (IBarDataSet) barData.MyBillsEntityDataFactory(authRequestContext.MyBillsEntityDataFactory);
        if (!iBarDataSet.lookAheadTest()) {
            MPPointD.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((ObjectPool<MPPointD>) BuiltInFictitiousFunctionClassFactory);
            return authRequestContext;
        }
        return MyBillsEntityDataFactory(authRequestContext, iBarDataSet, (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    public final List<Highlight> KClassImpl$Data$declaredNonStaticMembers$2(IDataSet iDataSet, int i, float f, DataSet.Rounding rounding) {
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
            MPPointD BuiltInFictitiousFunctionClassFactory2 = ((BarDataProvider) this.getAuthRequestContext).getTransformer(iDataSet.scheduleImpl()).BuiltInFictitiousFunctionClassFactory(entry.getAuthRequestContext(), entry.MyBillsEntityDataFactory());
            arrayList.add(new Highlight(entry.MyBillsEntityDataFactory(), entry.getAuthRequestContext(), (float) BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext, (float) BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2, i, iDataSet.scheduleImpl()));
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter
    protected final float KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3, float f4) {
        return Math.abs(f2 - f4);
    }
}
