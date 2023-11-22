package id.dana.explore.data.toggle.source;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.explore.data.toggle.source.split.SplitExploreConfigEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExploreConfigEntityDataFactory_Factory implements Factory<ExploreConfigEntityDataFactory> {
    private final Provider<SplitExploreConfigEntityData> KClassImpl$Data$declaredNonStaticMembers$2;

    private ExploreConfigEntityDataFactory_Factory(Provider<SplitExploreConfigEntityData> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ExploreConfigEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<SplitExploreConfigEntityData> provider) {
        return new ExploreConfigEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ExploreConfigEntityDataFactory(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
