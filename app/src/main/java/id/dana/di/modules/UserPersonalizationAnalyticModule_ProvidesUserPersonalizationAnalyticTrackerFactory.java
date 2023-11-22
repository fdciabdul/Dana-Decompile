package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.userpersonalization.tracker.UserPersonalizationAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UserPersonalizationAnalyticModule_ProvidesUserPersonalizationAnalyticTrackerFactory implements Factory<UserPersonalizationAnalyticTracker> {
    private final UserPersonalizationAnalyticModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> PlaceComponentResult;

    public static UserPersonalizationAnalyticTracker MyBillsEntityDataFactory(UserPersonalizationAnalyticModule userPersonalizationAnalyticModule, Context context) {
        return (UserPersonalizationAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(userPersonalizationAnalyticModule.KClassImpl$Data$declaredNonStaticMembers$2(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserPersonalizationAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
