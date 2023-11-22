package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.ActivityReactionsContract;

/* loaded from: classes5.dex */
public final class ActivityReactionsModule_ProvideView$app_productionReleaseFactory implements Factory<ActivityReactionsContract.View> {
    private final ActivityReactionsModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static ActivityReactionsContract.View getAuthRequestContext(ActivityReactionsModule activityReactionsModule) {
        return (ActivityReactionsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(activityReactionsModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ActivityReactionsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
