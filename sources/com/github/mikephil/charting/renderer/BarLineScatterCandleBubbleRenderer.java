package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes3.dex */
public abstract class BarLineScatterCandleBubbleRenderer extends DataRenderer {
    protected XBounds getErrorConfigVersion;

    public BarLineScatterCandleBubbleRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.getErrorConfigVersion = new XBounds();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean BuiltInFictitiousFunctionClassFactory(IDataSet iDataSet) {
        return iDataSet.whenAvailable() && (iDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6() || iDataSet.FragmentBottomSheetPaymentSettingBinding());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean BuiltInFictitiousFunctionClassFactory(Entry entry, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
        if (entry == null) {
            return false;
        }
        return entry != null && ((float) iBarLineScatterCandleBubbleDataSet.MyBillsEntityDataFactory((IBarLineScatterCandleBubbleDataSet) entry)) < ((float) iBarLineScatterCandleBubbleDataSet.BottomSheetCardBindingView$watcherCardNumberView$1()) * this.scheduleImpl.PlaceComponentResult();
    }

    /* loaded from: classes3.dex */
    protected class XBounds {
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public int PlaceComponentResult;
        public int getAuthRequestContext;

        protected XBounds() {
        }

        public final void MyBillsEntityDataFactory(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
            float max = Math.max(0.0f, Math.min(1.0f, BarLineScatterCandleBubbleRenderer.this.scheduleImpl.PlaceComponentResult()));
            float lowestVisibleX = barLineScatterCandleBubbleDataProvider.getLowestVisibleX();
            float highestVisibleX = barLineScatterCandleBubbleDataProvider.getHighestVisibleX();
            T BuiltInFictitiousFunctionClassFactory = iBarLineScatterCandleBubbleDataSet.BuiltInFictitiousFunctionClassFactory(lowestVisibleX, DataSet.Rounding.DOWN);
            T BuiltInFictitiousFunctionClassFactory2 = iBarLineScatterCandleBubbleDataSet.BuiltInFictitiousFunctionClassFactory(highestVisibleX, DataSet.Rounding.UP);
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory == 0 ? 0 : iBarLineScatterCandleBubbleDataSet.MyBillsEntityDataFactory((IBarLineScatterCandleBubbleDataSet) BuiltInFictitiousFunctionClassFactory);
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2 != 0 ? iBarLineScatterCandleBubbleDataSet.MyBillsEntityDataFactory((IBarLineScatterCandleBubbleDataSet) BuiltInFictitiousFunctionClassFactory2) : 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (int) ((r2 - this.PlaceComponentResult) * max);
        }
    }
}
