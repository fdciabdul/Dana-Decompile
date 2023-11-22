package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.service.ExploreServiceContract;

/* loaded from: classes4.dex */
public final class ExploreServiceModule_ProvideViewFactory implements Factory<ExploreServiceContract.View> {
    private final ExploreServiceModule MyBillsEntityDataFactory;

    public static ExploreServiceContract.View PlaceComponentResult(ExploreServiceModule exploreServiceModule) {
        return (ExploreServiceContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(exploreServiceModule.getBuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ExploreServiceContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
