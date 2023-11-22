package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: classes7.dex */
public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private String[] NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private int PrepareContext;
    private int isLayoutRequested;
    private float newProxyInstance;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    public final /* synthetic */ void PlaceComponentResult(Entry entry) {
        BarEntry barEntry = (BarEntry) entry;
        if (barEntry == null || Float.isNaN(barEntry.getAuthRequestContext())) {
            return;
        }
        if (barEntry.PlaceComponentResult == null) {
            if (barEntry.getAuthRequestContext() < this.FragmentBottomSheetPaymentSettingBinding) {
                this.FragmentBottomSheetPaymentSettingBinding = barEntry.getAuthRequestContext();
            }
            if (barEntry.getAuthRequestContext() > this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = barEntry.getAuthRequestContext();
            }
        } else {
            if ((-barEntry.BuiltInFictitiousFunctionClassFactory) < this.FragmentBottomSheetPaymentSettingBinding) {
                this.FragmentBottomSheetPaymentSettingBinding = -barEntry.BuiltInFictitiousFunctionClassFactory;
            }
            if (barEntry.MyBillsEntityDataFactory > this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = barEntry.MyBillsEntityDataFactory;
            }
        }
        BuiltInFictitiousFunctionClassFactory((BarDataSet) barEntry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public final int getErrorConfigVersion() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public final boolean lookAheadTest() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 > 1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.isLayoutRequested;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public final float MyBillsEntityDataFactory() {
        return this.newProxyInstance;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public final int getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public final int PlaceComponentResult() {
        return this.PrepareContext;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBarDataSet
    public final String[] BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }
}
