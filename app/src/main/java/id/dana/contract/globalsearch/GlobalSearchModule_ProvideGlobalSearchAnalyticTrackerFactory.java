package id.dana.contract.globalsearch;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalSearchModule_ProvideGlobalSearchAnalyticTrackerFactory implements Factory<GlobalSearchAnalyticTracker> {
    private final Provider<Context> PlaceComponentResult;
    private final GlobalSearchModule getAuthRequestContext;

    public static GlobalSearchAnalyticTracker MyBillsEntityDataFactory(GlobalSearchModule globalSearchModule, Context context) {
        return (GlobalSearchAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(globalSearchModule.getAuthRequestContext(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalSearchAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
