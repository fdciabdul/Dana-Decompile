package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.tncsummary.TncSummaryContract;

/* loaded from: classes4.dex */
public final class TncSummaryModules_ProvideTncSummaryViewFactory implements Factory<TncSummaryContract.View> {
    private final TncSummaryModules MyBillsEntityDataFactory;

    private TncSummaryModules_ProvideTncSummaryViewFactory(TncSummaryModules tncSummaryModules) {
        this.MyBillsEntityDataFactory = tncSummaryModules;
    }

    public static TncSummaryModules_ProvideTncSummaryViewFactory getAuthRequestContext(TncSummaryModules tncSummaryModules) {
        return new TncSummaryModules_ProvideTncSummaryViewFactory(tncSummaryModules);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TncSummaryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory());
    }
}
