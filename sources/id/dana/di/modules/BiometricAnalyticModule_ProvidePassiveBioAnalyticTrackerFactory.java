package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.tracker.mixpanel.BiometricAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BiometricAnalyticModule_ProvidePassiveBioAnalyticTrackerFactory implements Factory<BiometricAnalyticTracker> {
    private final BiometricAnalyticModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    public static BiometricAnalyticTracker KClassImpl$Data$declaredNonStaticMembers$2(BiometricAnalyticModule biometricAnalyticModule, Context context) {
        return (BiometricAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(biometricAnalyticModule.PlaceComponentResult(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BiometricAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
