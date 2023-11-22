package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.domain.h5event.H5EventRepository;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidesH5EventRepositoryFactory implements Factory<H5EventRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;

    private ApplicationModule_ProvidesH5EventRepositoryFactory(ApplicationModule applicationModule) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
    }

    public static ApplicationModule_ProvidesH5EventRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesH5EventRepositoryFactory(applicationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (H5EventRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
    }
}
