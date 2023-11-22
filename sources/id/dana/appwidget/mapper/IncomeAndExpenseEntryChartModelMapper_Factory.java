package id.dana.appwidget.mapper;

import dagger.internal.Factory;

/* loaded from: classes8.dex */
public final class IncomeAndExpenseEntryChartModelMapper_Factory implements Factory<IncomeAndExpenseEntryChartModelMapper> {
    public static IncomeAndExpenseEntryChartModelMapper_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes8.dex */
    static final class InstanceHolder {
        private static final IncomeAndExpenseEntryChartModelMapper_Factory MyBillsEntityDataFactory = new IncomeAndExpenseEntryChartModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new IncomeAndExpenseEntryChartModelMapper();
    }
}
