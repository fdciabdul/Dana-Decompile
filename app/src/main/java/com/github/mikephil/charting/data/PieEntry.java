package com.github.mikephil.charting.data;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes3.dex */
public class PieEntry extends Entry {
    public String MyBillsEntityDataFactory;

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(f);
        InstrumentInjector.log_i("DEPRECATED", "Pie entries do not have x values");
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public final float MyBillsEntityDataFactory() {
        InstrumentInjector.log_i("DEPRECATED", "Pie entries do not have x values");
        return super.MyBillsEntityDataFactory();
    }
}
