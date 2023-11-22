package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.foundation.logger.rds.RDSTracker;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideRDSTrackerFactory implements Factory<RDSTracker> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideRDSTrackerFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideRDSTrackerFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvideRDSTrackerFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RDSTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
