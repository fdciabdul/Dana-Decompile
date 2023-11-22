package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;

/* loaded from: classes7.dex */
public class CandleDataSet extends LineScatterCandleRadarDataSet<CandleEntry> implements ICandleDataSet {
    private float A;
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda7;
    protected Paint.Style NetworkUserEntityData$$ExternalSyntheticLambda8;
    protected int PrepareContext;
    private boolean VerifyPinStateManager$executeRiskChallenge$2$1;
    protected int isLayoutRequested;
    protected Paint.Style newProxyInstance;
    private float readMicros;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public final /* bridge */ /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Entry entry) {
        CandleEntry candleEntry = (CandleEntry) entry;
        if (candleEntry.getAuthRequestContext < this.FragmentBottomSheetPaymentSettingBinding) {
            this.FragmentBottomSheetPaymentSettingBinding = candleEntry.getAuthRequestContext;
        }
        if (candleEntry.getAuthRequestContext > this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = candleEntry.getAuthRequestContext;
        }
        if (candleEntry.MyBillsEntityDataFactory < this.FragmentBottomSheetPaymentSettingBinding) {
            this.FragmentBottomSheetPaymentSettingBinding = candleEntry.MyBillsEntityDataFactory;
        }
        if (candleEntry.MyBillsEntityDataFactory > this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = candleEntry.MyBillsEntityDataFactory;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public final /* synthetic */ void PlaceComponentResult(Entry entry) {
        CandleEntry candleEntry = (CandleEntry) entry;
        if (candleEntry.MyBillsEntityDataFactory < this.FragmentBottomSheetPaymentSettingBinding) {
            this.FragmentBottomSheetPaymentSettingBinding = candleEntry.MyBillsEntityDataFactory;
        }
        if (candleEntry.getAuthRequestContext > this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = candleEntry.getAuthRequestContext;
        }
        BuiltInFictitiousFunctionClassFactory((CandleDataSet) candleEntry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final float PlaceComponentResult() {
        return this.readMicros;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final float A() {
        return this.A;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final boolean B() {
        return this.BottomSheetCardBindingView$watcherCardNumberView$1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final int getErrorConfigVersion() {
        return this.isLayoutRequested;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final int MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final int getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final Paint.Style KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.newProxyInstance;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final Paint.Style BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final int lookAheadTest() {
        return this.PrepareContext;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public final boolean SubSequence() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1;
    }
}
