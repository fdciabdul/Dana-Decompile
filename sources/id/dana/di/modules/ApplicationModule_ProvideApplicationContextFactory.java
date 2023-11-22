package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideApplicationContextFactory implements Factory<Context> {
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideApplicationContextFactory(ApplicationModule applicationModule) {
        this.MyBillsEntityDataFactory = applicationModule;
    }

    public static ApplicationModule_ProvideApplicationContextFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideApplicationContextFactory(applicationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (Context) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
