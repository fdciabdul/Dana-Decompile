package id.dana.explore.data.toggle.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitExploreConfigEntityData_Factory implements Factory<SplitExploreConfigEntityData> {
    private final Provider<SplitFacade> KClassImpl$Data$declaredNonStaticMembers$2;

    private SplitExploreConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SplitExploreConfigEntityData_Factory BuiltInFictitiousFunctionClassFactory(Provider<SplitFacade> provider) {
        return new SplitExploreConfigEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitExploreConfigEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
